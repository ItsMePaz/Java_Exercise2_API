import org.json.JSONObject;

public class ConstructResult implements ReusScanner {

  static String titleResult;
  static int yearResult;
  static String mediaResult;
  static String actorResult;
  static int rankResult;

  public static void setDetails(JSONObject retrievedDetails) {
    String titleResult = retrievedDetails.getString("l"); //title
    int yearResult = (int) retrievedDetails.get("y"); //year
    String mediaResult = retrievedDetails.getString("q"); //mediaType
    String actorResult = retrievedDetails.getString("s"); //actors
    int rankResult = (int) retrievedDetails.get("rank"); //rank

    System.out.println("\n" + "Title: " + " | " + titleResult + " |");
    System.out.println("Year Released: " + " | " + yearResult + " |");
    System.out.println("Media Type: " + " | " + mediaResult + " |");
    System.out.println("Starring Actors: " + " | " + actorResult + " |");
    System.out.println("Ranking number: " + " | " + rankResult + " |");
    System.out.println();
    System.out.println();
    System.out.println(divider);
  }

  public static boolean UseAgain() {
    System.out.print("\nWould you like to make another search? (y/n): ");
    String qAgain = scanner.nextLine();

    if (!qAgain.equalsIgnoreCase("y")) {
      return false;
    } else {
      return true;
    }
  }
}
