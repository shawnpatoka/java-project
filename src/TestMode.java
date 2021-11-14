import java.util.Scanner;

public class TestMode {

    public static void testMode() {
        Scanner keyboard = new Scanner(System.in);
        String firstName;
        String lastName;
        String inputNumberOfQuestions;
        int currentQuestion = 0;
        int questionCount;
        int answersCorrect = 0;
        int answersIncorrect = 0;
        String inputAnswer;
        double gradePercentage;


        if (QuizCreationMode.questionArrayList.size() > 0) {
            System.out.println("\nThis is The Test Mode");
            System.out.printf("There are %d question(s) in the file.\n\n", QuizCreationMode.questionArrayList.size());

            System.out.println("Enter your first name.");
            firstName = keyboard.nextLine();
            System.out.println("Enter your last name.");
            lastName = keyboard.nextLine();
            System.out.println("Enter number of questions.");
            inputNumberOfQuestions = keyboard.nextLine();

            while (!MenuHandler.isInt(inputNumberOfQuestions) || (Integer.parseInt(inputNumberOfQuestions) > QuizCreationMode.questionArrayList.size())){
                System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
                System.out.println("Enter number of questions.");
                inputNumberOfQuestions = keyboard.nextLine();
            }

            questionCount = Integer.parseInt(inputNumberOfQuestions);

            for (int i = 0 ; i<QuizCreationMode.questionArrayList.size(); i++) {
                while (currentQuestion<questionCount) {
                    int choiceNumber = 1;
                    System.out.println("\nQuestion #" + (currentQuestion+1));
                    System.out.println(QuizCreationMode.questionArrayList.get(currentQuestion).getQuestionText());
                    for (String choice : QuizCreationMode.questionArrayList.get(currentQuestion).getAnswerChoices()) {
                        System.out.println(choiceNumber+": " + choice);
                        choiceNumber++;
                    }
                    System.out.println("Enter your choice: ");
                    inputAnswer = keyboard.nextLine();
                    while (!MenuHandler.isInt(inputAnswer)) {
                        System.out.println("Not a valid input. Try again.");
                        System.out.println("Enter your choice: ");
                        inputAnswer = keyboard.nextLine();
                    }
                    if ((Integer.parseInt(inputAnswer)-1)==QuizCreationMode.questionArrayList.get(currentQuestion).getCorrectChoice()) {
                        answersCorrect++;
                    } else {
                        answersIncorrect++;
                    }
                    currentQuestion++;
                }
            }

            // quiz results
            gradePercentage = ((double)answersCorrect/(double)Integer.parseInt(inputNumberOfQuestions))*100;
            System.out.println("\nQuiz Results...\n");
            System.out.printf("Name: %s %s\n", firstName, lastName);
            System.out.println("Total Questions: " + inputNumberOfQuestions);
            System.out.println("Correct Answers: " + answersCorrect);
            System.out.println("Incorrect Answers: " + answersIncorrect);
            System.out.printf("%% of Correct Answers: %%%.2f", gradePercentage);
            System.out.println("\nYour Grade is: " + findLetterGrade(gradePercentage));

            System.out.println("\nPress Return to continue back to main menu.\n");
            keyboard.nextLine();
            MainProject.main(null);
        } else {
            System.out.println("\nThere aren't any questions in the file to take.");
            System.out.println("Returning to the Main Menu.\n");
            MainProject.main(null);
        }

    }

    public static String findLetterGrade(double gradePercentage) {
        String result;
        switch((int)gradePercentage/10) {
            case 10: case 9:
                result = "A";
                break;
            case 8:
                result = "B";
                break;
            case 7:
                result = "C";
                break;
            case 6:
                result = "D";
                break;
            default:
                result = "F";
                break;
        }
        return result;
    }
}