import java.util.Scanner;

public class SecretWord {

    private static boolean isSafe;
    private static Scanner keyboard = new Scanner(System.in);
    private static final String SECRET_WORD = "abide";


    // methods

    public static boolean getIsSafe() {
        return isSafe;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }

    public static void runSecretWord(){
        System.out.println("Enter secret word. Or enter '-1' to exit.");
        String userInput = keyboard.nextLine();

        if (userInput.equals("-1")) {
            System.out.println("Exiting Program");
            System.exit(0);
        }

        isSafe = SECRET_WORD.equals(userInput);
    }







}
