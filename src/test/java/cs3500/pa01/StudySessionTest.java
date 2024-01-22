package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests that all methods in StudySession class work as intended
 */
class StudySessionTest {

  StudySession session;


  @BeforeEach
  public void setToHard() {
    StringReader testInput = new StringReader("qaOutput.sr\n2\n2\n2\n");
    StringBuilder actualOutput = new StringBuilder();
    //StringBuilder expectedOutput = new StringBuilder();
    session = new StudySession(testInput, actualOutput);
    try {
      session.run(false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testRunEasyCards() {

    StringBuilder expectedOutput = new StringBuilder();
    // build the expected output in the test
    expectedOutput.append("Welcome to the study session!\n");
    expectedOutput.append("Provide a full path to the .sr file you wish to study:\n");
    expectedOutput.append("How many cards would you like to study?\n");
    expectedOutput.append("What is the capital of Canada?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("The capital is Ottawa.\n");
    expectedOutput.append("Which country is known as the Land of the Rising Sun?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("Japan.\n");
    expectedOutput.append("You've finished the study session! Here are your stats:\n");
    expectedOutput.append("Total cards studied: 2\n");
    expectedOutput.append("0 cards moved from easy to hard\n");
    expectedOutput.append("0 cards moved from hard to easy\n");
    expectedOutput.append("Current counts in question bank:\n");
    expectedOutput.append("Easy cards: 2\n");
    expectedOutput.append("Hard cards: 0\n");
    StringReader testInput = new StringReader("qaOutput.sr\n2\n1\n1\n");
    StringBuilder actualOutput = new StringBuilder();
    session = new StudySession(testInput, actualOutput);
    try {
      session.run(false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testRunHardCards() {

    StringBuilder expectedOutput = new StringBuilder();

    // build the expected output in the test
    expectedOutput.append("Welcome to the study session!\n");
    expectedOutput.append("Provide a full path to the .sr file you wish to study:\n");
    expectedOutput.append("How many cards would you like to study?\n");
    expectedOutput.append("What is the capital of Canada?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("The capital is Ottawa.\n");
    expectedOutput.append("Which country is known as the Land of the Rising Sun?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("Japan.\n");
    expectedOutput.append("You've finished the study session! Here are your stats:\n");
    expectedOutput.append("Total cards studied: 2\n");
    expectedOutput.append("2 cards moved from easy to hard\n");
    expectedOutput.append("0 cards moved from hard to easy\n");
    expectedOutput.append("Current counts in question bank:\n");
    expectedOutput.append("Easy cards: 0\n");
    expectedOutput.append("Hard cards: 2\n");
    StringReader testInput = new StringReader("qaOutput.sr\n2\n2\n2\n");
    StringBuilder actualOutput = new StringBuilder();
    session = new StudySession(testInput, actualOutput);
    try {
      session.run(false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testKeepHard() {
    StringReader testInput = new StringReader("qaOutput.sr\n2\n1\n1\n");
    StringBuilder actualOutput = new StringBuilder();
    //StringBuilder expectedOutput = new StringBuilder();
    session = new StudySession(testInput, actualOutput);
    try {
      session.run(false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    StringBuilder expectedOutput = new StringBuilder();
    // build the expected output in the test
    expectedOutput.append("Welcome to the study session!\n");
    expectedOutput.append("Provide a full path to the .sr file you wish to study:\n");
    expectedOutput.append("How many cards would you like to study?\n");
    expectedOutput.append("What is the capital of Canada?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("The capital is Ottawa.\n");
    expectedOutput.append("Which country is known as the Land of the Rising Sun?\n");
    expectedOutput.append("How would you like to proceed? (1) Show answer and mark as easy,"
        + " (2) Show answer and mark as hard, (3) quit session\n");
    expectedOutput.append("Japan.\n");
    expectedOutput.append("You've finished the study session! Here are your stats:\n");
    expectedOutput.append("Total cards studied: 2\n");
    expectedOutput.append("0 cards moved from easy to hard\n");
    expectedOutput.append("0 cards moved from hard to easy\n");
    expectedOutput.append("Current counts in question bank:\n");
    expectedOutput.append("Easy cards: 2\n");
    expectedOutput.append("Hard cards: 0\n");
    StringReader testInput1 = new StringReader("qaOutput.sr\n2\n1\n2\n");
    StringBuilder actualOutput1 = new StringBuilder();
    session = new StudySession(testInput1, actualOutput1);
    try {
      session.run(false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }


}