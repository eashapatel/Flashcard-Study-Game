package cs3500.pa01;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Comparator;




/**
 * represents a comparator for sorting by time created
 */
public class SortByTimeCreated implements Comparator<Path> {


  /**
   * Compares the order of two Paths based on their times created
   *
   * @param o1 the first object (Path) to be compared based on time created.
   * @param o2 the second object (Path) to be compared based on time created.
   * @return integer representing which Path should be before the other in a sorted list.
   */
  public int compare(Path o1, Path o2) {
    try {
      BasicFileAttributes attr1 = Files.readAttributes(o1, BasicFileAttributes.class);
      FileTime file1Time = attr1.creationTime();
      System.out.println(file1Time.toString());
      BasicFileAttributes attr2 = Files.readAttributes(o2, BasicFileAttributes.class);
      FileTime file2Time = attr2.creationTime();
      System.out.println(file2Time.toString());

      return file1Time.compareTo(file2Time);

    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
