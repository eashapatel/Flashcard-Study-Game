package cs3500.pa01;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * tests that files can be converted
 */
class FileConverterTest {



  FileConverter converter = new FileConverter();


  /**
   * tests the method that compiles all the text from files in correct format
   *
   * @throws IOException when markdown text can't be converted
   */

  @Test
  public void testCompileOutputFile() throws IOException {

    ArrayList<Path> fileList = new ArrayList<>();
    fileList.add(Path.of("src/test/resources/samplePath/arrays.md"));
    fileList.add(Path.of("src/test/resources/samplePath/vectors.md"));
    StringBuilder expectedText = new StringBuilder();
    expectedText.append("\n");
    expectedText.append("# Java Arrays \n");
    expectedText.append("- An **array** is a collection of variables of the same type\n");
    expectedText.append("\n");
    expectedText.append("## Declaring an Array \n");
    expectedText.append("- General Form: type[] arrayName;\n");
    expectedText.append("- only creates a reference\n");
    expectedText.append("- no array has  actually been created yet\n");
    expectedText.append("\n");
    expectedText.append("## Creating an Array (Instantiation) \n");
    expectedText.append("- General form:  arrayName = new type[numberOfElements];\n");
    expectedText.append("- numberOfElements must be a positive Integer.\n");
    expectedText.append("- Gotcha: Array size is not  modifiable once instantiated.\n");
    expectedText.append("\n");
    expectedText.append("# Vectors \n");
    expectedText.append("- Vectors act like resizable arrays\n");
    expectedText.append("\n");
    expectedText.append("## Declaring a vector \n");
    expectedText.append("- General Form: Vector<type> v = new Vector();\n");
    expectedText.append("- type needs to be a valid reference type\n");
    expectedText.append("\n");
    expectedText.append("## Adding an element to a vector \n");
    expectedText.append("- v.add(object of type);\n");

    assertEquals(expectedText.toString(), converter.compileOutputFile(fileList));
  }


  @Test
  public void testCompileSrFile() throws IOException {
    ArrayList<Path> fileList = new ArrayList<Path>();
    fileList.add(Path.of("src/test/resources/samplePath/arrays.md"));
    fileList.add(Path.of("src/test/resources/samplePath/vectors.md"));

    StringBuilder expectedText = new StringBuilder();
    expectedText.append("[[What is the capital of Canada?:::The capital is Ottawa.]] -hard\n");
    expectedText.append("[[Which country is known as the Land of the Rising Sun?"
        + ":::Japan.]] -hard\n");
    expectedText.append("[[What is the largest river in Africa?"
        + ":::The largest river is the Nile River.]] -hard\n");
    expectedText.append("[[What is the tallest mountain in North America?"
        + ":::The tallest mountain is Denali (also known as Mount McKinley).]] -hard\n");
    expectedText.append("[[Which continent is the driest inhabited continent on Earth?"
        + ":::Australia.]] -hard\n");
    expectedText.append("[[What is the longest river in South America?"
        + ":::The longest river is the Amazon River.]] -hard\n");
    expectedText.append("[[Which country is known as the Land Down Under?"
        + ":::Australia.]] -hard\n");
    expectedText.append("[[What is the highest waterfall in the world?"
        + ":::The highest waterfall is Angel Falls in Venezuela.]] -hard\n");
    expectedText.append("[[Which country is the largest in terms of land area?"
        + ":::The largest country is Russia.]] -hard\n");
    expectedText.append("[[Which continent is known as the \"Roof of the World\"?"
        + ":::Asia.]] -hard\n");
    expectedText.append("[[What is the largest desert in Asia?"
        + ":::The largest desert is the Gobi Desert.]] -hard\n");
    expectedText.append("[[Which country is the smallest in terms of land area?"
        + ":::The smallest country is Vatican City.]] -hard\n");
    expectedText.append("[[What is the official language of Brazil?"
        + ":::The official language is Portuguese.]] -hard\n");
    expectedText.append("[[Which city is located on two continents?"
        + ":::Istanbul, Turkey. It is located on both Europe and Asia.]] -hard\n");
    expectedText.append("[[What is the largest island in the world?"
        + ":::The largest island is Greenland.]] -hard\n");
    expectedText.append("[[Which country is famous for its tulips and windmills?"
        + ":::The Netherlands.]] -hard\n");
    expectedText.append("[[What is the capital of Argentina?"
        + ":::The capital is Buenos Aires.]] -hard\n");
    expectedText.append("[[Which country is known as the Land of a Thousand Lakes? "
        + "::: Finland.]] -hard\n");
    expectedText.append("[[What is the largest lake in Africa?"
        + "::: The largest lake is Lake Victoria.]] -hard\n");
    expectedText.append("[[Which country is located in both Europe and Asia?"
        + ":::Russia.]] -hard\n");

    assertEquals(expectedText.toString(), converter.compileSrFile(fileList));
  }



}
