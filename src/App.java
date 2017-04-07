import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    Handler.isFileExist();
    appInput(args);
  }

  public static void appInput(String[] args) {
    if (args.length == 0) {
      PrintMethods.noArgsGivenStandardInfo();
    } else if (args.length == 1 && Arrays.toString(args).contains("-l")) {
      PrintMethods.listAllTheItems();
    } else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-a")) {
      ListManipulation.addItemToList(args);
    } else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-r")) {
      ListManipulation.removeItemFromList(args);
    } else if (args.length > 0 && args.length < 3 && Arrays.toString(args).contains("-c")) {
      ListManipulation.checkTaskIsDone(args);
    } else {
      System.out.println("Unsupported argument");
      PrintMethods.noArgsGivenStandardInfo();
    }
  }
}
