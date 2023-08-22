import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    do {
      HandleQueryTypeInput.handleOptionsInput();
    } while (ConstructResult.UseAgain());
    if (ConstructResult.UseAgain() == false) {
      System.out.println(
        "\nThank you for using my java program!\n\n :^) \n\n (c) Michael Andrew Paz\n"
      );
      return;
    }
  }
}
