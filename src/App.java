import java.util.ArrayList;
import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    ListManipulation listman = new ListManipulation();
    FileHandling fileHandling = new FileHandling();
    fileHandling.isFileExist();

    if (args.length == 0) {
      PrintMethods.noArgsGivenStandardInfo();
    }
    else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-l")) {
      PrintMethods.listAllTheItems();
    }
    else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-a")) {
      listman.addItemToList(args);
    }
    else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-r")) {
      listman.removeItemFromList(args);
    }
    else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-c")) {
      listman.checkTaskIsDone(args);
    }
    else {
      System.out.println("Unsupported argument");
      PrintMethods.noArgsGivenStandardInfo();
    }
  }
}

