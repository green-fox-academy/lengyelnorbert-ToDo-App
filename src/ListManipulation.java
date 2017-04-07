import java.util.List;

public class ListManipulation {

  public static void addItemToList(String[] addItem) {
    try {
      if (addItem.length == 1) {
        System.out.println("Unable to add: no task provided");
      } else {
        String elementToAdd = addItem[1];
        List<String> allItems = Handler.fileRead();
        allItems.add("[ ] " + elementToAdd);
        Handler.fileWrite(allItems);
        System.out.println("The element is added to the list.");
      }
    } catch (Exception e) {
      System.out.println("Something went wrong... Please try again, here is some help for You:");
      PrintMethods.noArgsGivenStandardInfo();
    }
  }

  public static void removeItemFromList(String[] removeItem) {
    try {
      List<String> allItems = Handler.fileRead();
      if (removeItem.length == 1) {
        System.out.println("Unable to remove: no index provided");
      } else if (allItems.size() < Integer.parseInt(removeItem[1])) {
        System.out.println("Unable to remove: index is out of bound");
      } else {
        int itemToRemove = Integer.parseInt(removeItem[1]) - 1;
        allItems.remove(itemToRemove);
        Handler.fileWrite(allItems);
        System.out.println("List item number " + (itemToRemove + 1) + " is removed.");
      }
    } catch (Exception e) {
      System.out.println("Unable to remove: index is not a number. Here is some help for You:");
      PrintMethods.noArgsGivenStandardInfo();
    }
  }

  public static void checkTaskIsDone(String[] checkMarkItem) {
    try {
      List<String> allItems = Handler.fileRead();
      if (checkMarkItem.length == 1) {
        System.out.println("Unable to mark task done/ undone: no index provided");
      } else if (allItems.size() < Integer.parseInt(checkMarkItem[1])) {
        System.out.println("Unable to mark task done/ undone: index is out of bound");
      } else {
        allItems = markTheItem(checkMarkItem, allItems);
        Handler.fileWrite(allItems);
      }
    } catch (Exception e) {
      System.out.println(
              "Unable to mark task done/ undone: index is not a number. Here is some help for You:");
      PrintMethods.noArgsGivenStandardInfo();
    }
  }
  public static List<String> markTheItem (String[] checkMarkItem, List<String> allItems){
    int itemToMarkDone = Integer.parseInt(checkMarkItem[1]) - 1;
    String marked = "[X]";
    String unmarked = "[ ]";
    String temp = allItems.get(itemToMarkDone).substring(0, 2);
    String textTemp = (allItems.get(itemToMarkDone)).substring(3);
    if (temp.contains("X")) {
      textTemp = unmarked.concat(textTemp);
      System.out.println("List item number " + (itemToMarkDone + 1) + " marked as undone.");
    } else {
      textTemp = marked.concat(textTemp);
      System.out.println("List item number " + (itemToMarkDone + 1) + " marked as done.");
    }
    allItems.remove(itemToMarkDone);
    allItems.add(itemToMarkDone, textTemp);
    return allItems;
  }
}
