import java.util.ArrayList;

public class ArraySearch { //This class includes the method to search through every single element of an array, then returns a value "true" if there is a matching element

  public static boolean searchThrough(ArrayList<String> arr, String item) {
    int a = 0;

    for (String title : arr) {
      if (title.equalsIgnoreCase(item)) {} else {
        a++;
        continue;
      }
    }

    if (a == arr.size()) {
      return false;
    } else {
      return true;
    }
  }
}
