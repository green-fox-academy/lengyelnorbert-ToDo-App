import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.sound.sampled.Line;

public class PrintMethods {

  public void NoArgsGivenStandardInfo() {
    Path standardInfoFilePath = Paths.get("./standardinfo.txt");
    try {
      List<String> standardInfo = Files.readAllLines(standardInfoFilePath);
      for (int i = 0; i < standardInfo.size(); i++) {
        System.out.println(standardInfo.get(i));
      }
    } catch (IOException ex) {
      System.out.println("Something went wrong");
    }
  }
}