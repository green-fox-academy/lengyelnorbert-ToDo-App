import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintMethods {

  public static void noArgsGivenStandardInfo() {
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

  public static void listAllTheItems() {
    try {
      List<String> allItems = Handler.fileRead();
      if (allItems.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        System.out.println("Your todo list:");
        for (int i = 0; i < allItems.size(); i++) {
          System.out.println(i + 1 + " " + allItems.get(i));
        }
      }
    } catch (Exception e) {
      System.out.println("Something went wrong... Please try again, here is some help for You:");
    }
  }
}
