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
 * tests methods in SortByTimeCreated class
 */
class SortByTimeCreatedTest {

  File f1 = new File("src/test/resources/samplePath/arrays.md");
  File f2 = new File("src/test/resources/samplePath/vectors.md");
  Comparator<Path> sorter;

  /**
   * sets up fields before running test methods - instaniates empty path list and sorter
   */
  @BeforeEach
  public void setup() {
    sorter = new SortByTimeCreated();
  }

  /**
   * tests compare method in the sortByTimeCreated class
   * NOTE: my file system does not support file creation time (for some reason), so I can
   * really only test that the files are all stored with the same, default, creation time,
   * no matter their ACTUAL creation time.
   *
   */
  @Test
  public void testCompare() throws IOException {

    Path arrays = f1.toPath();
    Path vectors = f2.toPath();

    BasicFileAttributeView setter1 =
        Files.getFileAttributeView(arrays, BasicFileAttributeView.class);

    BasicFileAttributeView setter2 =
        Files.getFileAttributeView(vectors, BasicFileAttributeView.class);

    setter1.setTimes(FileTime.fromMillis(0), FileTime.fromMillis(0),
        FileTime.from(100, TimeUnit.DAYS));

    setter2.setTimes(FileTime.fromMillis(0), FileTime.fromMillis(0),
        FileTime.from(300, TimeUnit.DAYS));

    assertEquals(0, sorter.compare(arrays, vectors));

    assertEquals(0, sorter.compare(vectors, arrays));

  }
}
