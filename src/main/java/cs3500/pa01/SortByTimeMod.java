package cs3500.pa01;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * represents a comparator for sorting by time modified
 */
public class SortByTimeMod implements Comparator<Path> {



  /**
   * Compares two Paths to see which one is first in an order list - from oldest to newest files
   *
   * @param o1 the first object (Path) to be compared based on its time modified.
   * @param o2 the second object (Path) to be compared based on its time modified.
   * @return integer representing which Path should be before the other in a sorted list
   */
  public int compare(Path o1, Path o2) {
    try {
      BasicFileAttributes attr1 = Files.readAttributes(o1, BasicFileAttributes.class);
      FileTime file1mod = attr1.lastModifiedTime();

      BasicFileAttributes attr2 = Files.readAttributes(o2, BasicFileAttributes.class);
      FileTime file2mod = attr2.lastModifiedTime();

      return file1mod.compareTo(file2mod);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
