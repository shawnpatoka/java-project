import java.util.Scanner;

public class QuizCreationMode {
    public static void quizCreationMode() {
        Scanner keyboard = new Scanner(System.in);
        String modeSelection;

        System.out.println("\nThis is The Manage Questions Menu");
        System.out.println("Please make a choice from the selections below. Enter 1-4.");
        System.out.println("1. Add a new question");
        System.out.println("2. Delete existing question");
        System.out.println("3. List all available questions");
        System.out.println("4. Go back to main menu");
        modeSelection = keyboard.nextLine();

        while ((!MenuHandler.isInt(modeSelection) || !MenuHandler.isInRange(modeSelection, 1,4))) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *");
            System.out.println("\nThis is The Manage Questions Menu");
            System.out.println("Please make a choice from the selections below. Enter 1-4.");
            System.out.println("1. Add a new question");
            System.out.println("2. Delete existing question");
            System.out.println("3. List all available questions");
            System.out.println("4. Go back to main menu");
            modeSelection = keyboard.nextLine();
        }

        // Redirects based on selection 1-4.
        if ((Integer.parseInt(modeSelection))==1) {
            addNewQuestion();
        } else if ((Integer.parseInt(modeSelection))==2) {
            deleteQuestion();
        } else if ((Integer.parseInt(modeSelection))==3) {
            listAllQuestions();
        } else if ((Integer.parseInt(modeSelection))==4) {
            MainProject.main(null);
        }

    } // end quizCreationMode()

    public static void addNewQuestion() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nThis is the Add a New Question screen.");
        System.out.println("Enter a question ID.");
        String questionID = keyboard.nextLine();
        System.out.println("Enter the question.");
        String questionText = keyboard.nextLine();
        System.out.println("Enter number of possible answers.");
        String possibleAnswers = keyboard.nextLine();

        while ((!MenuHandler.isInt(possibleAnswers))) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Enter number of possible answers.");
            possibleAnswers = keyboard.nextLine();
        }

        for (int i = 0; i<(Integer.parseInt(possibleAnswers)); i++) {
            System.out.println("Choice #"+ (i+1) + ": Possible Answer: ");
            keyboard.nextLine();
        }

        System.out.println("Enter which choice was the correct answer: ");
        String correctAnswer = keyboard.nextLine();

        while ((!MenuHandler.isInt(correctAnswer)) || !MenuHandler.isInRange(correctAnswer, 1,(Integer.parseInt(possibleAnswers)))) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Enter which choice was the correct answer:");
            correctAnswer = keyboard.nextLine();
        }

        System.out.println("\nQuestion Created.");
        System.out.println("Press Return to continue to the Manage Questions menu.");
        keyboard.nextLine();
        quizCreationMode();
    }


    public static void deleteQuestion() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nThis is the Delete Question screen.");
        System.out.println("Enter the question code of the question you'd like to delete.");
        String userInput = keyboard.nextLine();
        System.out.println("\nThe question has been deleted.");
        System.out.println("Press Return to continue to the Manage Questions menu.");
        keyboard.nextLine();
        quizCreationMode();
    }


    public static void listAllQuestions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nThis is the List All Questions screen.");
        System.out.println("Printing Questions...\n");
        System.out.println("Press Return to continue to the Manage Questions menu.");
        keyboard.nextLine();
        quizCreationMode();
    }


} // end QuizCreationMode
