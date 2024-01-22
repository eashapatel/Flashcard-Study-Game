package cs3500.pa01;

import static cs3500.pa01.SrReader.createCard;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * tests that all methods in SrReader class work as intended
 */
class SrReaderTest {


  @Test
  public void testCreateCard() {
    StudyCard c = new StudyCard("What color is the sky?", "blue");
    String line = "[[What color is the sky?:::blue]] -hard";
    assertTrue(c.sameCard(createCard(line)));

    StudyCard c2 = new StudyCard("", "");
    String line2 = "banana";
    assertTrue(c2.sameCard(createCard(line2)));
  }

  @Test
  public void testImportStudySet() throws IOException {
    SrReader sr = new SrReader("qaOutput.sr");
    StudySet ss = sr.importStudySet(5, true);
    assertEquals(5, ss.getEasyCards().size() + ss.getHardCards().size());
    assertEquals(0, ss.getVisitedCards().size());
    StudySet ss2 = sr.importStudySet(0, true);
    assertEquals(0, ss2.getEasyCards().size() + ss2.getHardCards().size());
    assertEquals(new ArrayList<StudyCard>(), ss2.getEasyCards());
  }

  @Test
  public void testCreateCardList() throws IOException {
    SrReader sr = new SrReader("qaOutput.sr");
    ArrayList<StudyCard> sc = sr.createCardList();
    assertEquals(20, sc.size());
  }

}