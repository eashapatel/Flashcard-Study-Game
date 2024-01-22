package cs3500.pa01;

import static cs3500.pa01.SrReader.createCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents a study session
 */
public class StudySession {

  private int totalStudiedCards;
  private int easyToHardCards;
  private int hardToEasyCards;
  private int totalHardCards;
  private int totalEasyCards;

  private Readable inputStream;

  private Appendable outputStream;


  /**
   * constructor for a study session
   */
  public StudySession() {
    inputStream = new InputStreamReader(System.in);
    outputStream = System.out;
  }

  /**
   * constructor for a study session
   */
  public StudySession(Readable inputStream, Appendable outputStream) {
    totalStudiedCards = 0;
    easyToHardCards = 0;
    hardToEasyCards = 0;
    totalHardCards = 0;
    totalEasyCards = 0;
    this.inputStream = inputStream;
    this.outputStream = outputStream;
  }

  /**
   * runs the study session
   */
  public void run(boolean random) throws IOException {
    Scanner s = new Scanner(inputStream);

    outputStream.append("Welcome to the study session!\n");
    outputStream.append("Provide a full path to the .sr file you wish to study:\n");
    String path = s.nextLine();

    StudySetImporter importer = new SrReader(path);

    outputStream.append("How many cards would you like to study?\n");
    int numCards = s.nextInt();

    // creates the study set - list of hard, easy, and visited StudyCards

    StudySet studySet = importer.importStudySet(numCards, random);
    this.totalHardCards = studySet.getHardCards().size();
    this.totalEasyCards = studySet.getEasyCards().size();
    ArrayList<StudyCard> hardCards = new ArrayList<StudyCard>();
    ArrayList<StudyCard> easyCards = new ArrayList<StudyCard>();


    for (StudyCard sc : studySet.getHardCards()) {
      if (!sc.containsCard(studySet.getVisitedCards())) {
        outputStream.append(sc.getQues() + "\n");
        outputStream.append("How would you like to proceed? (1) Show answer and mark as easy,"
            + " (2) Show answer and mark as hard, (3) quit session\n");
        int input = s.nextInt();
        if (input == 1) {
          outputStream.append(sc.getAns() + "\n");
          this.hardToEasyCards++;
          this.totalHardCards--;
          this.totalEasyCards++;
          this.totalStudiedCards++;
          easyCards.add(new StudyCard(sc.getQues(), sc.getAns(), false));
          studySet.addVisitedCard(sc);
        } else if (input == 2) {
          outputStream.append(sc.getAns() + "\n");
          this.totalStudiedCards++;
          hardCards.add(new StudyCard(sc.getQues(), sc.getAns()));
          studySet.addVisitedCard(sc);
        } else {
          finalStats();
          return;
        }
      }
    }

    for (StudyCard sc : studySet.getEasyCards()) {
      if (!sc.containsCard(studySet.getVisitedCards())) {
        outputStream.append(sc.getQues() + "\n");
        outputStream.append("How would you like to proceed? (1) Show answer and mark as easy,"
            + " (2) Show answer and mark as hard, (3) quit session\n");
        int input = s.nextInt();
        if (input == 1) {
          outputStream.append(sc.getAns() + "\n");
          this.totalStudiedCards++;
          studySet.addVisitedCard(sc);
          easyCards.add(new StudyCard(sc.getQues(), sc.getAns(), false));
        } else if (input == 2) {
          outputStream.append(sc.getAns() + "\n");
          this.easyToHardCards++;
          this.totalEasyCards--;
          this.totalHardCards++;
          this.totalStudiedCards++;
          hardCards.add(new StudyCard(sc.getQues(), sc.getAns()));
          studySet.addVisitedCard(sc);
        } else {
          finalStats();
          return;
        }
      }
    }
    studySet = new StudySet(hardCards, easyCards, studySet.getVisitedCards());
    finalStats();
    reWriteFile(Path.of(path), studySet);
  }


  /**
   * prints the final stats of the study session
   */
  public void finalStats() throws IOException {
    outputStream.append("You've finished the study session! Here are your stats:\n");
    outputStream.append("Total cards studied: " + this.totalStudiedCards + "\n");
    outputStream.append(Integer.toString(this.easyToHardCards)
        + " cards moved from easy to hard\n");
    outputStream.append(Integer.toString(this.hardToEasyCards)
        + " cards moved from hard to easy\n");
    outputStream.append("Current counts in question bank:\n");
    outputStream.append("Easy cards: " + this.totalEasyCards + "\n");
    outputStream.append("Hard cards: " + this.totalHardCards + "\n");
  }

  /**
   * creates a study card from a string
   *
   * @param path the string to create the study card from
   * @param ss   the study set to add the study card to
   * @throws IOException if the file cannot be read
   */
  public void reWriteFile(Path path, StudySet ss) throws IOException {
    Scanner s = new Scanner(path);
    StringBuilder sb = new StringBuilder();
    while (s.hasNextLine()) {
      String line = s.nextLine();
      StudyCard lineCard = createCard(line);
      if (lineCard.containsCard(ss.getHardCards()) || lineCard.containsCard(ss.getEasyCards())) {
        for (StudyCard sc : ss.getHardCards()) {
          if (lineCard.getAns().equals(sc.getAns()) && lineCard.getQues().equals(sc.getQues())) {
            sb.append(line.substring(0, line.indexOf(" -")) + " -hard\n");
          }
        }
        for (StudyCard sc : ss.getEasyCards()) {
          if (lineCard.getAns().equals(sc.getAns()) && lineCard.getQues().equals(sc.getQues())) {
            sb.append(line.substring(0, line.indexOf(" -")) + " -easy\n");
          }
        }
      } else {
        sb.append(line + "\n");
      }
    }
    File file = new File(path.toString());
    FileWriter w = new FileWriter(file, false);
    w.write(sb.toString());
    w.close();
  }

}