package cs3500.pa01;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * Runs the file to study guide converter
 */
public class Driver {

  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) throws IOException {
    if (args.length == 3) {
      if (args[0] != null && args[1] != null && args[2] != null) {
        CollectFiles cf = new CollectFiles();

        FileConverter fc = new FileConverter();
        ArrayList<Path> fileList = new ArrayList<Path>();
        fileList.addAll(cf.getFoundFiles(Path.of(args[0])));


        Comparator<Path> fileSorter = switch (args[1]) {
          case "created" -> new SortByTimeCreated();
          case "modified" -> new SortByTimeMod();
          default -> new SortByFileName();
        };

        // sorts the list of md files using the correct comparator
        fileList.sort(fileSorter);

        // inserts converted Markdown language text into instantiated file
        String studyGuideText = fc.compileOutputFile(fileList);

        FileWriter writer = new FileWriter(args[2]);
        writer.write(studyGuideText);
        writer.close();

        String qaText = fc.compileSrFile(fileList);
        FileWriter srWriter = new FileWriter("qaOutput.sr");
        srWriter.write(qaText);
        srWriter.close();
      } else {
        throw new IllegalArgumentException("Program requires an input and output path");
      }
    } else if (args.length == 0) {
      StudySession ss = new StudySession();
      ss.run(true);
    } else {
      throw new IllegalArgumentException("Program requires an input and output path");
    }
  }
}
