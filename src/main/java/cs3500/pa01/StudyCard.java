package cs3500.pa01;

import java.util.ArrayList;

/**
 * represents a study card with a question, answer, and difficulty level
 */
public class StudyCard {

  private String ans;
  private String ques;
  private boolean hard;

  /** constructor
   *
   * @param ques string representing the study card's question
   * @param ans string representing the study card's answer
   */
  StudyCard(String ques, String ans) {
    this.ques = ques;
    this.ans = ans;
    this.hard = true;
  }

  StudyCard(String ques, String ans, boolean hard) {
    this.ques = ques;
    this.ans = ans;
    this.hard = hard;
  }

  /**
   * sets the card's difficulty to easy
   */
  public void setToEasy() {
    this.hard = false;
  }

  /**
   * sets the card's difficulty to hard
   */
  public void setToHard() {
    this.hard = true;
  }

  /** gets card's difficulty
   *
   * @return boolean true if difficulty is hard, else boolean false
   */
  public boolean getDifficulty() {
    return this.hard;
  }

  /** gets card's answer
   *
   * @return string representing card's answer
   */
  public String getAns() {
    return this.ans;
  }

  /** gets card's question
   *
   * @return string representing card's question
   */
  public String getQues() {
    return this.ques;
  }

  /**
   * checks if the card is the same as another card
   *
   * @param sc study card
   * @return boolean true if the cards are the same, else boolean false
   */
  public boolean sameCard(StudyCard sc) {
    return this.ques.equals(sc.getQues())
        && this.ans.equals(sc.getAns())
        && this.hard == sc.getDifficulty();
  }


  /**
   * checks if the card is in the list
   *
   * @param cardList list of cards
   * @return boolean true if the card is in the list, else boolean false
   */
  public boolean containsCard(ArrayList<StudyCard> cardList) {
    boolean returnVal = false;
    for (int i = 0; i < cardList.size(); i++) {
      if (this.sameCard(cardList.get(i))) {
        returnVal = true;
      }
    }
    return returnVal;
  }

}
