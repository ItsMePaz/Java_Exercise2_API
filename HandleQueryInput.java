import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class HandleQueryInput implements ReusScanner {

  static void handleTitleSearch()
    throws JSONException, InterruptedException, IOException { //This method handles the Title search query of the user
    System.out.print("\nInput Title: ");
    String titleInput = scanner.nextLine();
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " +
      titleInput +
      " and here are the result/s: \n\n Loading..."
    );
    System.out.println(divider);
    int a = 0; //This will increment each time the loop below does a cycle. It will have a max value of the max number of movie objects in the databse
    for (int i = 0; i < Service.movieService().length(); i++) { //This maps through each title in different existing movie object. If a matching title value is found, that title and its neighboring movie detail values are passed on to be constructed.
      JSONObject object = Service.movieService().getJSONObject(i);
      String movieTitle = (String) object.get("l");
      System.out.println(".");
      if (movieTitle.equalsIgnoreCase(titleInput)) { //This if-statement checkes if there are completely like elements
        ConstructResult.setDetails(object);
      } else {
        a++;
        if (a == Service.movieService().length()) { //If 'a' reaches the max value, it means there is no like elements found, therefore the user's queried movie is not in the database.
          System.out.println(divider);
          System.out.println("\nTitle not found in the database.");
        }
        continue;
      }
    }
  }

  static void handleMediaTypeSearch()
    throws JSONException, InterruptedException, IOException { //This method handles the MediaType search query of the user
    System.out.print("\nInput Media Type: ");
    String mediaInput = scanner.nextLine();
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " +
      mediaInput +
      " and here are the result/s: \n\n Loading..."
    );
    System.out.println(divider);
    int a = 0;
    for (int i = 0; i < Service.movieService().length(); i++) {
      JSONObject object = Service.movieService().getJSONObject(i);
      String movieMediaType = (String) object.optString("q");
      System.out.println(".");
      if (movieMediaType.equalsIgnoreCase(mediaInput)) {
        ConstructResult.setDetails(object);
      } else {
        a++;
        if (a == Service.movieService().length()) {
          System.out.println(divider);
          System.out.println("\nMedia Type not found in the database.");
        }
        continue;
      }
    }
  }

  static void handleYearSearch()
    throws JSONException, InterruptedException, IOException { //This method handles the Year search query of the user
    System.out.print("\nInput Year: ");
    String yearInputString = scanner.nextLine();
    Integer yearInput = Integer.parseInt(yearInputString); //This parses the user's input to an integer, using Integer and nextInt on the previous line results in an exception
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " +
      yearInput +
      " and here are the result/s: \n\n Loading..."
    );
    System.out.println(divider);
    int a = 0;
    for (int i = 0; i < Service.movieService().length(); i++) {
      JSONObject object = Service.movieService().getJSONObject(i);
      int movieYear = (int) object.optInt("y");
      System.out.println(".");
      if (movieYear == yearInput) {
        ConstructResult.setDetails(object);
      } else {
        a++;
        if (a == Service.movieService().length()) {
          System.out.println(divider);
          System.out.println("\nYear not found in the database.");
        }
        continue;
      }
    }
  }

  static void handleRankSearch()
    throws JSONException, IOException, InterruptedException { //This method handles the Rank Number search query of the user
    System.out.print("\nInput Rank Number: ");
    String rankInputString = scanner.nextLine();
    Integer rankInput = Integer.parseInt(rankInputString);
    System.out.println(divider);
    System.out.println(
      "\nYou searched for " +
      rankInput +
      " and here are the result/s: \n\n Loading..."
    );
    System.out.println(divider);
    int a = 0;
    for (int i = 0; i < Service.movieService().length(); i++) {
      JSONObject object = Service.movieService().getJSONObject(i);
      int movieRank = (int) object.optInt("rank");
      System.out.println(".");
      if (movieRank == rankInput) {
        ConstructResult.setDetails(object);
      } else {
        a++;
        if (a == Service.movieService().length()) {
          System.out.println(divider);
          System.out.println("\nYear not found in the database.");
        }
        continue;
      }
    }
  }
}
