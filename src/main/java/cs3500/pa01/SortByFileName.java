package cs3500.pa01;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * represents a comparator for sorting by filename
 */
public class SortByFileName implements Comparator<Path> {


  /**
   * Compares the filenames of two paths
   *
   * @param o1 the first object (Path) to be compared based on filename.
   * @param o2 the second object (Path) to be compared based on filename.
   * @return an integer representing the lexiographic order of filenames.
   */
  public int compare(Path o1, Path o2) {
    String file1 = o1.getFileName().toString();
    String file2 = o2.getFileName().toString();

    return file1.compareTo(file2);
  }
}
