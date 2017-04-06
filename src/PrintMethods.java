import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.sound.sampled.Line;

public class PrintMethods {

  public void noArgsGivenStandardInfo() {
    Path standardInfoFilePath = Paths.get("./standardinfo.txt");
    try {
      List<String> standardInfo = Files.readAllLines(standardInfoFilePath);
      for (int i = 0; i < standardInfo.size(); i++) {
        System.out.println(standardInfo.get(i));
      }
    } catch (IOException ex) {
      System.out.println("Something went wrong with opening the info txt.");
    }
  }

  public void listAllTheItems() {
    Path todoDataFilePath = Paths.get("./tododatas.txt");
    try {
      List<String> allItems = Files.readAllLines(todoDataFilePath);
      if (allItems.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < allItems.size(); i++) {
          System.out.println(i + 1 + " " + allItems.get(i));
        }
      }
    } catch (IOException e) {
      System.out.println("Something went wrong with opening the data txt.");
    }
  }
}