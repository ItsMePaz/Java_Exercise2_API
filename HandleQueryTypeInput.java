import java.util.Scanner;

interface ReusScanner {
  Scanner scanner = new Scanner(System.in);
  String divider =
    "_________________________________________________________________________________________________________";
}

public class HandleQueryTypeInput extends HandleQueryInput {

  public static int inputTitle;
  public static boolean optionPickTerminant;

  public static void handleOptionsInput() { //This method lets the user input a query type then will repeat if it is invalid
    do { //This method is covered in a do while loop to be able to repeat itself incase of invalid inputs or incase of re-usage
      try {
        System.out.println(divider);
        System.out.println("\nFind your movie by the following: \n");
        System.out.println(
          "| [1] TITLE | [2] MEDIA TYPE | [3] YEAR RELEASED | [4] RANK NUMBER | \n"
        );
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input filter type (1-4): ");

        int inputTitle = scanner.nextInt();
        System.out.println(divider);
        boolean optionPickTerminant = inputTitle >= 1 && inputTitle <= 7; //This expression results a boolean value than depicts if the the user input is between 1 and 7

        switch (inputTitle) {
          case 1:
            HandleQueryInput.handleTitleSearch(); //working
            break;
          case 2:
            HandleQueryInput.handleMediaTypeSearch(); //working with errors
            break;
          case 3:
            HandleQueryInput.handleYearSearch(); //working
            break;
          case 4:
            HandleQueryInput.handleRankSearch(); //working with slight time errors
            break;
          default:
            System.out.println(
              "\nInvalid input! Please try again and input a corresponding filter method."
            );
        }

        if (optionPickTerminant == false) {
          System.out.println(
            "\nInvalid input! Please try again and input a corresponding filter method."
          );
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println(divider);
        // TODO: handle exception
      }
    } while (optionPickTerminant == false);
  }
}
