package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests that all methods in StudyCard class work as intended
 */
class StudyCardTest {

  StudyCard card1;
  StudyCard card2;

  @BeforeEach
  public void setUp() {
    card1 = new StudyCard("What color is the sky?", "blue");
    card2 = new StudyCard("How many days are there in a year?", "365 days");
  }

  @Test
  public void testSetToEasy() {

    assertEquals(true, card1.getDifficulty());
    card1.setToEasy();
    assertEquals(false, card1.getDifficulty());
  }

  @Test
  public void testSetToHard() {

    assertEquals(true, card1.getDifficulty());
    card1.setToHard();
    assertEquals(true, card1.getDifficulty());

    assertEquals(true, card2.getDifficulty());
    card2.setToEasy();
    assertEquals(false, card2.getDifficulty());
    card2.setToHard();
    assertEquals(true, card2.getDifficulty());
  }

  @Test
  public void testGetDifficulty() {

    assertEquals(true, card1.getDifficulty());
    assertEquals(true, card2.getDifficulty());
    card2.setToEasy();
    assertEquals(false, card2.getDifficulty());
  }

  @Test
  public void testGetAns() {
    assertEquals("blue", card1.getAns());
    assertEquals("365 days", card2.getAns());
  }

  @Test
  public void testGetQues() {
    assertEquals("What color is the sky?", card1.getQues());
    assertEquals("How many days are there in a year?", card2.getQues());
  }

}