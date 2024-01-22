package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests methods in SortByFileName
 */
class SortByFileNameTest {

  private ArrayList<Path> fileList;


  SortByFileName sorter;
  Driver driver;


  /**
   * sets up fields before running test methods - instaniates empty path list and sorter
   */
  @BeforeEach
  public void setup() {
    fileList = new ArrayList<Path>();
    sorter = new SortByFileName();
    driver = new Driver();
  }


  /**
   * tests compare method in the sortByFileName class
   */


  @Test
  public void testCompare() throws IOException {


    Path arrays = Path.of("src/test/resources/samplePath/arrays.md");




    Path vectors = Path.of("src/test/resources/samplePath/vectors.md");




    assertEquals(-21, sorter.compare(arrays, vectors));


    assertEquals(21, sorter.compare(vectors, arrays));


    assertEquals(0, sorter.compare(arrays,
        arrays));


    assertEquals(0, sorter.compare(vectors, vectors));


  }
}
