import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (!SecretWord.getIsSafe()){
            SecretWord.runSecretWord();
        }
        MenuHandler.runMainMenu();

    } // end of main method
}
