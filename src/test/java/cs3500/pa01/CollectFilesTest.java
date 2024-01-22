package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;



/**
 *  tests the collection of files from path
 */
class CollectFilesTest {
  static final String SAMPLE_INPUTS_DIRECTORY = "src/test/resources/samplePath/";

  /**
   * tests building a list of all valid Markdown paths in a directory
   *
   * @throws IOException when method returns error
   */
  @Test
  public void testGetFoundFiles() {
    try {
      CollectFiles cf = new CollectFiles();


      // build list of expected file paths
      ArrayList<Path> expectedFiles = new ArrayList<>();
      expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/arrays.md"));
      expectedFiles.add(Path.of(SAMPLE_INPUTS_DIRECTORY + "/vectors.md"));


      // get list of traversed Markdown file paths
      ArrayList<Path> actualFiles =
          new ArrayList<Path>(cf.getFoundFiles(Path.of(SAMPLE_INPUTS_DIRECTORY)));


      // compare both lists
      assertEquals(2, actualFiles.size());
    } catch (IOException e) {
      throw new IllegalArgumentException(e.getMessage());
    }


  }



}
