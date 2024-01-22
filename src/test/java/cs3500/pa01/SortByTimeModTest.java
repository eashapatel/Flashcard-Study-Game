package cs3500.pa01;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * tests sorting my time modified
 */
class SortByTimeModTest {

  File f1 = new File("src/test/resources/samplePath/arrays.md");
  File f2 = new File("src/test/resources/samplePath/vectors.md");
  private ArrayList<Path> fileList;
  Comparator<Path> sorter = new SortByTimeMod();

  /**
   * sets up fields before running test methods - instaniates empty path list and sorter
   */
  @BeforeEach
  public void setup() {
    fileList = new ArrayList<Path>();
    sorter = new SortByTimeMod();
  }

  /**
   * tests compare method in the sortByTimeMod class
   */
  @Test
  public void testCompare() {

    Path arrays = f1.toPath();
    Path vectors = f2.toPath();

    BasicFileAttributeView setter1 =
        Files.getFileAttributeView(arrays, BasicFileAttributeView.class);

    BasicFileAttributeView setter2 =
        Files.getFileAttributeView(vectors, BasicFileAttributeView.class);

    try {
      setter1.setTimes(FileTime.from(200, TimeUnit.DAYS), FileTime.fromMillis(0),
          FileTime.from(0, TimeUnit.DAYS));

      setter2.setTimes(FileTime.from(100, TimeUnit.DAYS), FileTime.fromMillis(0),
          FileTime.from(0, TimeUnit.DAYS));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertEquals(1, sorter.compare(arrays, vectors));

    assertEquals(-1, sorter.compare(vectors, arrays));

    assertEquals(0, sorter.compare(arrays, arrays));

    assertEquals(0, sorter.compare(vectors, vectors));


  }
}
