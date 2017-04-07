import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Handler {

  public static void isFileExist() {
    File f = new File("./tododatas.txt");
    try {
      if (!f.exists()) {
        f.createNewFile();
        System.out.println("ToDo file did not exist, but I've just created now.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<String> fileRead() {
    List<String> allItems = new ArrayList<>();
    try {
      Path todoDataFilePath = Paths.get("./tododatas.txt");
      allItems = Files.readAllLines(todoDataFilePath);

    } catch (IOException e) {
      System.out.println("Something went wrong with opening the data file. I'm sorry...");
      System.exit(0);
    }
    return allItems;
  }

  public static void fileWrite(List<String> toWrite) {
    try {
      Path todoDataFilePath = Paths.get("./tododatas.txt");
      Files.write(todoDataFilePath, toWrite);
    } catch (IOException e) {
      System.out.println("Something went wrong with writing the data file. I'm sorry...");
      System.exit(0);
    }
  }
}
