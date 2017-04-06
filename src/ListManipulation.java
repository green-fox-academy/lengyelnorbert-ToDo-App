import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListManipulation {

  public void addItemToList(String[] addItem) {
    try {
      if (addItem.length == 1) {
        System.out.println("Unable to add: no task provided");
      } else {
        String elementToAdd;
        Path todoDataFilePath = Paths.get("./tododatas.txt");
        elementToAdd = addItem[1];

        List<String> allItems = Files.readAllLines(todoDataFilePath);
        allItems.add(elementToAdd);
        Files.write(todoDataFilePath, allItems);
      }
    } catch (IOException e) {
      System.out.println("Something went wrong with opening the data txt.");
    }
  }


  public void removeItemFromList(String[] removeItem) {
    Path todoDataFilePath = Paths.get("./tododatas.txt");
    List<String> allItems = new ArrayList<>();
    try {
      allItems = Files.readAllLines(todoDataFilePath);

      if (removeItem.length == 1) {
        System.out.println("Unable to remove: no index provided");
      } else if (allItems.size() < Integer.parseInt(removeItem[1])) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        int itemToRemove = Integer.parseInt(removeItem[1])-1;
        allItems.remove(itemToRemove);
        Files.write(todoDataFilePath, allItems);
      }

    } catch (IOException ex) {
      System.out.println("Something went wrong with opening the data txt.");
    } catch (Exception e) {
      System.out.println("Unable to remove: index is not a number");
    }
  }
}

