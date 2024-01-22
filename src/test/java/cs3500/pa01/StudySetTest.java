package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests that all methods in StudySet class work as intended
 */
class StudySetTest {

  StudyCard c1 = new StudyCard("What color is the sky?", "blue");
  StudyCard c2 = new StudyCard("What color is the grass?", "green");
  StudyCard c3 = new StudyCard("What color is the ocean?", "dark blue", false);
  StudyCard c4 = new StudyCard("What color is the sun?", "yellow", false);

  ArrayList<StudyCard> hardCards;
  ArrayList<StudyCard> easyCards;
  StudySet ss;

  @BeforeEach
  public void setUpStudySet() {
    hardCards = new ArrayList<StudyCard>();
    hardCards.add(c3);
    hardCards.add(c4);
    easyCards = new ArrayList<StudyCard>();
    easyCards.add(c1);
    easyCards.add(c2);
    ss = new StudySet(easyCards, hardCards);
  }

  @Test
  public void testGetEasyCards() {
    assertEquals(easyCards, ss.getEasyCards());
  }

  @Test
  public void testRemoveEasyCard() {
    ss.removeEasyCard(0);
    ArrayList<StudyCard> expectedCards = new ArrayList<StudyCard>();
    expectedCards.add(c2);
    assertEquals(expectedCards, ss.getEasyCards());
    ss.removeEasyCard(0);
    assertEquals(new ArrayList<StudyCard>(), ss.getEasyCards());
  }


  @Test
  public void testGetHardCards() {
    assertEquals(hardCards, ss.getHardCards());
  }

  @Test
  public void testRemoveHardCard() {
    ss.removeHardCard(0);
    ArrayList<StudyCard> expectedCards = new ArrayList<StudyCard>();
    expectedCards.add(c4);
    assertEquals(expectedCards, ss.getHardCards());
    ss.removeHardCard(0);
    assertEquals(new ArrayList<StudyCard>(), ss.getHardCards());
  }

  @Test
  public void testVisitedCards() {
    assertEquals(new ArrayList<StudyCard>(), ss.getVisitedCards());
    ss.addVisitedCard(c1);
    ArrayList<StudyCard> updatedVisitedCards = new ArrayList<StudyCard>();
    updatedVisitedCards.add(c1);
    assertEquals(updatedVisitedCards, ss.getVisitedCards());
    ss.addVisitedCard(c3);
    updatedVisitedCards.add(c3);
    assertEquals(updatedVisitedCards, ss.getVisitedCards());
  }

  @Test
  public void testAddVisitedCards() {
    ss.addVisitedCard(c1);
    ArrayList<StudyCard> updatedVisitedCards = new ArrayList<StudyCard>();
    updatedVisitedCards.add(c1);
    assertEquals(updatedVisitedCards, ss.getVisitedCards());
    ss.addVisitedCard(c3);
    updatedVisitedCards.add(c3);
    assertEquals(updatedVisitedCards, ss.getVisitedCards());
  }

}