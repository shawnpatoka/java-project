import java.util.Scanner;

public class MenuHandler {
    static Scanner keyboard = new Scanner(System.in);

    // methods

    public static boolean isInt(String userInput) {
        boolean result;
        try {
            Integer.parseInt(userInput);
            return result = true;
        } catch (NumberFormatException e){
            return result = false;
        }
    }


    public static boolean isInRange(String userInput, int min, int max) {
        boolean result;
        result = (Integer.parseInt(userInput)) >= min && (Integer.parseInt(userInput)) <= max;
        return result;
    }


    public static void runMainMenu(){
        mainMenuOptions();
        String userInput = keyboard.nextLine();

        while (!MenuHandler.isInt(userInput) || !MenuHandler.isInRange(userInput, 1,3)) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            mainMenuOptions();
            userInput = keyboard.nextLine();
        }

        // Redirects based on selection 1-3.
        if ((Integer.parseInt(userInput))==1) {
            QuizCreationMode.quizCreationMode();
        } else if ((Integer.parseInt(userInput))==2) {
            TestMode.testMode();
        } else if ((Integer.parseInt(userInput))==3) {
            System.exit(0);
        }
    }


    public static void runQuizCreationMenu(){
        String modeSelection;

        quizCreationMenuOptions();
        modeSelection = keyboard.nextLine();

        // menu validation. checks to see if input is an in. checks to see if it's in range.
        while ((!isInt(modeSelection) || !isInRange(modeSelection, 1,4))) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *");
            quizCreationMenuOptions();
            modeSelection = keyboard.nextLine();
        }

        // Redirects based on selection 1-4.
        if ((Integer.parseInt(modeSelection))==1) {
            QuizCreationMode.addNewQuestion();
        } else if ((Integer.parseInt(modeSelection))==2) {
            QuizCreationMode.deleteQuestion();
        } else if ((Integer.parseInt(modeSelection))==3) {
            QuizCreationMode.listAllQuestions();
        } else if ((Integer.parseInt(modeSelection))==4) {
            MainProject.main(null);
        }
    }


    public static void mainMenuOptions(){
        System.out.println("Welcome to the Quiz Master. Choose from the selection below. Enter a 1-3");
        System.out.println("1. Manage Questions");
        System.out.println("2. Test Mode");
        System.out.println("3. Exit");
    }


    public static void quizCreationMenuOptions(){
        System.out.println("\nThis is The Manage Questions Menu");
        System.out.println("Please make a choice from the selections below. Enter 1-4.");
        System.out.println("1. Add a new question");
        System.out.println("2. Delete existing question");
        System.out.println("3. List all available questions");
        System.out.println("4. Go back to main menu");
    }
}
