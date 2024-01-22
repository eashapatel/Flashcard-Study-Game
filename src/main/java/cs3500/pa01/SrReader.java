package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * reads in a file and creates a study set
 */
public class SrReader implements StudySetImporter {

  Scanner sc;
  Random rand;

  /**
   * constructor
   */
  public SrReader(String path) throws IOException {
    this.sc = new Scanner(Path.of(path));
    rand = new Random();
  }

  /**
   * imports a study set
   *
   * @return the study set
   */
  public StudySet importStudySet(int numCards, boolean random) {
    ArrayList<StudyCard> sc = createCardList();
    ArrayList<StudyCard> easyCards = new ArrayList<StudyCard>();
    ArrayList<StudyCard> hardCards = new ArrayList<StudyCard>();
    if (random) {
      ArrayList<Integer> cardIndices = new ArrayList<Integer>();
      for (int i = 0; i < numCards; i++) {
        int randInt = rand.nextInt(sc.size());
        if (!cardIndices.contains(randInt)) {
          if (sc.get(randInt).getDifficulty()) {
            hardCards.add(sc.get(randInt));
          } else {
            easyCards.add(sc.get(randInt));
          }
          cardIndices.add(randInt);
        } else {
          i--;
        }
      }
    } else {
      for (int i = 0; i < numCards; i++) {
        if (sc.get(i).getDifficulty()) {
          hardCards.add(sc.get(i));
        } else {
          easyCards.add(sc.get(i));
        }
      }
    }
    return new StudySet(easyCards, hardCards);
  }



  /**
   * creates a study card list from a file
   *
   * @return the study card list
   */
  public ArrayList<StudyCard> createCardList() {
    ArrayList<StudyCard> cardList = new ArrayList<StudyCard>();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      StudyCard card = createCard(line);
      if (!card.getQues().equals("")) {
        cardList.add(card);
      }
    }
    return cardList;
  }


  /**
   * creates a study card from a line
   *
   * @param line the line to create the card from
   * @return the study card
   */
  public static StudyCard createCard(String line) {
    if (line.length() > 6 && line.contains("[[")
        && line.contains(":::") && line.contains("]]")) {
      String question = line.substring(line.indexOf("[[") + 2, line.indexOf(":::"));
      String answer = line.substring(line.indexOf(":::") + 3, line.indexOf("]]"));
      StudyCard card = new StudyCard(question, answer);
      if (!line.contains(" -hard")) {
        card.setToEasy();
      }
      return card;
    } else {
      return new StudyCard("", "");
    }

  }
}
