package cs3500.pa01;

import java.util.ArrayList;

/**
 * represents a study set with easy and hard cards
 */
public class StudySet {

  private ArrayList<StudyCard> easyCards;
  private ArrayList<StudyCard> hardCards;
  private ArrayList<StudyCard> visitedCards;

  /**
   * constructor for a study set
   *
   * @param easy easy cards
   * @param hard hard cards
   */
  StudySet(ArrayList<StudyCard> easy, ArrayList<StudyCard> hard) {
    easyCards = easy;
    hardCards = hard;
    visitedCards = new ArrayList<StudyCard>();
  }

  /**
   * constructor for a study set
   *
   * @param easy    easy cards
   * @param hard    hard cards
   * @param visited visited cards
   */
  StudySet(ArrayList<StudyCard> easy, ArrayList<StudyCard> hard, ArrayList<StudyCard> visited) {
    easyCards = easy;
    hardCards = hard;
    visitedCards = visited;
  }


  /**
   * gets the next card
   *
   * @return StudyCard representing the next card
   */
  public ArrayList<StudyCard> getEasyCards() {
    return this.easyCards;
  }

  /**
   * removes an easy card
   *
   * @param cardIndex int representing the index of the card to be removed
   */
  public void removeEasyCard(int cardIndex) {
    this.easyCards.remove(cardIndex);
  }


  /**
   * gets the hard cards
   *
   * @return ArrayList representing the hard cards
   */
  public ArrayList<StudyCard> getHardCards() {
    return this.hardCards;
  }

  /**
   * removes a hard card
   *
   * @param cardIndex int representing the index of the card to be removed
   */
  public void removeHardCard(int cardIndex) {
    this.hardCards.remove(cardIndex);
  }


  /**
   * gets the visited cards
   *
   * @return ArrayList representing the visited cards
   */
  public ArrayList<StudyCard> getVisitedCards() {
    return this.visitedCards;
  }

  /**
   * adds a visited card
   *
   * @param sc StudyCard representing the visited card
   */
  public void addVisitedCard(StudyCard sc) {
    this.visitedCards.add(sc);
  }
}

