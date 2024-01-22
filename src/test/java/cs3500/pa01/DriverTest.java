package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * runs the main method
 */
class DriverTest {

  @Test
  public void testNullInputPath() throws IOException {
    String[] args = new String[3];
    args[0] = null;
    args[1] = "filename";
    args[2] = "output.md";
    assertThrows(IllegalArgumentException.class, () -> Driver.main(args));
  }

  @Test
  public void testNullOutputPath() throws IOException {
    String[] args = new String[3];
    args[0] = "src/";
    args[1] = "filename";
    args[2] = null;
    try {
      Driver.main(args);
    } catch (IllegalArgumentException e) {
      assertEquals("Program requires an input and output path", e.getMessage());
    }
  }

  @Test
  public void testNullSorter() {
    String[] args = new String[3];
    args[0] = "src/";
    args[1] = null;
    args[2] = "output.md";
    assertThrows(IllegalArgumentException.class, () -> Driver.main(args));
  }

  @Test
  public void testValidArgs() throws IOException {
    String[] args = new String[3];
    args[0] = "src/";
    args[1] = "created";
    args[2] = "vectors.md";
    Driver.main(args);
  }

  @Test
  public void testValidArgs2() throws IOException {
    String[] args = new String[3];
    args[0] = "src/";
    args[1] = "modified";
    args[2] = "output.md";

    Driver.main(args);
  }


}
