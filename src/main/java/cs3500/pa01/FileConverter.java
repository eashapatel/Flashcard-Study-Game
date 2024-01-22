package cs3500.pa01;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Converts files into study guide text
 */
public class FileConverter {

  /**
   * Writes the text from a file into an output file in study guide format
   *
   * @param file the file whose text is being converted and placed into outputFile
   * @throws IOException throws this when the scanner does not compile
   */
  private StringBuilder readFile(Path file) throws IOException {
    Scanner sc = new Scanner(file);
    StringBuilder returnText = new StringBuilder();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      if (!(line.length() == 0) && line.substring(0, 1).equals("#")) {
        returnText.append("\n" + line + " \n");
      } else if (!(line.length() == 0) && line.contains("[[") && line.contains("]]")) {
        int start = line.indexOf("[[") + 2;
        int end = line.indexOf("]]");
        if (!line.substring(start, end).contains(":::")) {
          returnText.append("- " + line.substring(start, end) + "\n");
        }
        line = line.substring(end + 2);
        if (!(line.length() == 0) && line.contains("[[") && !line.contains("]]")) {
          String str1 = line.substring(line.indexOf("[[") + 2);
          String next = sc.nextLine();
          while (!next.contains("]]")) {
            str1 = str1.concat(next);
            next = sc.nextLine();
          }
          str1 = str1.concat(next.substring(0, next.indexOf("]]")));
          if (!str1.contains(":::")) {
            returnText.append("- " + str1 + "\n");
          }
        }
      } else if (!(line.length() == 0) && line.contains("[[") && !line.contains("]]")) {
        String str1 = line.substring(line.indexOf("[[") + 2);
        String next = sc.nextLine();
        while (!next.contains("]]")) {
          str1 = str1.concat(next);
          next = sc.nextLine();
        }
        str1 = str1.concat(next.substring(0, next.indexOf("]]")));
        if (!str1.contains(":::")) {
          returnText.append("- " + str1 + "\n");
        }
      }
    }
    return returnText;
  }

  /**
   *
   * @param fileList a list of file paths
   * @return returns string from files that go in sr file
   * @throws IOException if files can't be scanned
   */
  public static String compileSrFile(ArrayList<Path> fileList) throws IOException {
    StringBuilder qaText = new StringBuilder();
    for (Path file : fileList) {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (!(line.length() == 0) && line.contains("[[") && line.contains("]]")) {
          int start = line.indexOf("[[");
          int end = line.indexOf("]]") + 2;
          if (line.substring(start, end).contains(":::")) {
            qaText.append(line.substring(start, end) + " -hard" + "\n");
          }
          line = line.substring(end);
          if (!(line.length() == 0) && line.contains("[[") && !line.contains("]]")) {
            String str1 = line.substring(line.indexOf("[["));
            String next = sc.nextLine();
            while (!next.contains("]]")) {
              str1 = str1.concat(next);
              next = sc.nextLine();
            }
            str1 = str1.concat(next.substring(0, next.indexOf("]]") + 2));
            if (str1.contains(":::")) {
              qaText.append(str1 + " -hard" + "\n");
            }
          }
        } else if (!(line.length() == 0) && line.contains("[[") && !line.contains("]]")) {
          String str1 = line.substring(line.indexOf("[["));
          String next = sc.nextLine();
          while (!next.contains("]]")) {
            str1 = str1.concat(next);
            next = sc.nextLine();
          }
          str1 = str1.concat(next.substring(0, next.indexOf("]]") + 2));
          if (str1.contains(":::")) {
            qaText.append(str1 + " -hard" + "\n");
          }
        }
      }
    }
    return qaText.toString();
  }



  /**
   * Converts the Markdown text from all files in list and places it in outputFile
   *
   * @param fileList the list of files being converted and ordered into output file
   * @throws IOException when the scanner is not able to compile
   */
  public String compileOutputFile(ArrayList<Path> fileList) throws IOException {
    StringBuilder studyGuideText = new StringBuilder();
    for (Path file : fileList) {
      studyGuideText.append(readFile(file));
    }
    return studyGuideText.toString();
  }
}
