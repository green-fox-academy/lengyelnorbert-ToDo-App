import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileHandling {

  public void isFileExist() {
    File f = new File("./tododatas.txt");
    try {
      if (!f.exists()) {
        f.createNewFile();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


