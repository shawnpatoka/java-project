import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String modeSelection;

        System.out.println("Welcome to the Quiz Master. ");

        // Prompts user to enter secret word.
        // Exits if entered wrong 3 times. Enters if correct.
//        secretWordMethod();


        // Start of program
        System.out.println("\nSecret Word Successful.\n");
        System.out.println("Welcome to the Quiz Master. Choose from the selection below. Enter a 1-3");
        System.out.println("1. Manage Questions");
        System.out.println("2. Test Mode");
        System.out.println("3. Exit");
        modeSelection = keyboard.nextLine();


        // Validation for choice selection.
        // Determines if selection is an integer, and if it's in range.
        while (!MenuHandler.isInt(modeSelection) || !MenuHandler.isInRange(modeSelection, 1,3)) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Welcome to the Quiz Master. Choose from the selection below. Enter a 1-3");
            System.out.println("1. Manage Questions");
            System.out.println("2. Test Mode");
            System.out.println("3. Exit");
            modeSelection = keyboard.nextLine();
        }


        // Redirects based on selection 1-3.
        if ((Integer.parseInt(modeSelection))==1) {
            QuizCreationMode.quizCreationMode();
        } else if ((Integer.parseInt(modeSelection))==2) {
            TestMode.testMode();
        } else if ((Integer.parseInt(modeSelection))==3) {
            System.exit(0);
        }
    }


    // Secret Word Method
    // Prompts user to enter secret word. Exits if entered wrong 3 times.
    public static void secretWordMethod() {
        Scanner keyboard = new Scanner(System.in);
        String secretWord;
        int totalTries = 1;

        // Secret Word Initial Input
        System.out.println("Enter Secret Word, or enter -1 to exit: ");
        secretWord = keyboard.nextLine();

        // Secret Word Check validation
        // Enters loop if initial secret word input is not correct
        // or if -1 is entered, it skips this loop and goes to the following if statement
        while (!secretWordCheck(secretWord) && !secretWord.equals("-1")) {
            System.out.println("\nIncorrect Secret Word. ");
            System.out.println("Please try again, or enter -1 to quit. ");
            System.out.println("You have " + (3-totalTries) + " remaining tries.");
            secretWord = keyboard.nextLine();
            totalTries++;
            if (totalTries == 3 && !secretWordCheck(secretWord)) {
                System.out.println("You've reached the maximum amount of attempts.");
                System.out.println("Exiting Program.");
                System.exit(0);
            } else if (secretWord.equals("-1")) {
                System.out.println("Exiting Program");
                System.exit(0);
            }
        }
        if (secretWord.equals("-1")) {
            System.out.println("\nExiting Program");
            System.exit(0);
        }
    }


    // Method for checking if the secret word matches. Takes in str, returns bool.
    public static boolean secretWordCheck(String word) {
        String secretWord = "abide";
        boolean result;
        result = secretWord.equals(word);
        return result;
    }
}
