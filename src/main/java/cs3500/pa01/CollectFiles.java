package cs3500.pa01;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


/**
 *  collects files from path
 */
public class CollectFiles implements FileVisitor<Path> {
  private ArrayList<Path> fileList;


  CollectFiles() {
    fileList = new ArrayList<Path>();
  }


  /**
   * Descends through a path and collects a list of paths representing md files
   *
   * @param p represents a Path being descended through
   *
   * @return List of collected md files from path
   *
   * @throws IOException if the method cannot walk through file tree
   */


  public List<Path> getFoundFiles(Path p) throws IOException {
    try {
      Files.walkFileTree(p, this);
      return List.copyOf(fileList);
    } catch (IOException e) {
      throw new IOException(e.getMessage());
    }
  }

  /** Invoked before a file is visited, and tells file visitor to continue
   *
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return FileVisitResult directs what the file visitor should do next
   * @throws IOException when method doesn't work as intended
   */
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  /** Adds files to fileList and terminates file read if they end in ".md", else continues
   file read.
   *
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   *
   * @return FileVisitResult on the given path directs whether the file visit should terminate
   *          or continue
   * @throws IOException when method doesn't work as intended
   */
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    if (file.toString().substring(file.toString().length() - 3).equals(".md")
        && attrs.isRegularFile()) {
      fileList.add(file);
    }
    return FileVisitResult.CONTINUE;
  }


  /** Determines what the file visit result will be given that visitFile fails
   *
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return FileVisitResult directs what the file visitor should do next
   * @throws IOException when method doesn't work as expected
   */
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    return FileVisitResult.CONTINUE;
  }




  /** Determines what happens after files have been visited
   *
   * @param dir
   *          a reference to the directory
   * @param exc
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return FileVisitResult directs what the file visitor should do next
   * @throws IOException when method doesn't work as intended
   */
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    return FileVisitResult.CONTINUE;
  }
}
