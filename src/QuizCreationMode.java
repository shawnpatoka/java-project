import java.util.ArrayList;
import java.util.Scanner;

public class QuizCreationMode {

    static ArrayList<Question> questionArrayList = new ArrayList<Question>();

    public static void quizCreationMode() {

        // Quiz Creation Menu
        MenuHandler.runQuizCreationMenu();

    }


    public static void addNewQuestion() {
        String questionID;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nThis is the Add a New Question screen.");
        System.out.println("Enter a question ID.");
        questionID = keyboard.nextLine();

        // questionID validation. check if existing and check if blank
        while( questionIDCheck(questionID) || questionID.isBlank() ) {
            if (questionIDCheck(questionID)) {
                System.out.println("\nQuestion ID is already in use. Please try a new ID.");
            } else if (questionID.isBlank()) {
                System.out.println("\nQuestion ID cannot be blank. Please try a new ID.");
            }
            System.out.println("Enter a question ID.");
            questionID = keyboard.nextLine();
        }

        System.out.println("Enter the question.");
        String questionText = keyboard.nextLine();
        System.out.println("Enter number of possible answers.");
        String possibleAnswers = keyboard.nextLine();
        ArrayList<String> answerChoices = new ArrayList<>();

        // number of possible answers validation
        while ((!MenuHandler.isInt(possibleAnswers)) || (Integer.parseInt(possibleAnswers) <= 1)) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Number of possible answers must be a number, and be more than 1.");
            System.out.println("Enter number of possible answers.");
            possibleAnswers = keyboard.nextLine();
        }

        // loop through count of possible answers, add to arraylist
        for (int i = 0; i<(Integer.parseInt(possibleAnswers)); i++) {
            System.out.println("Choice #"+ (i+1) + ": Possible Answer: ");
            String choice = keyboard.nextLine();
            answerChoices.add(choice);
        }

        System.out.println("Enter which choice was the correct answer: ");
        String correctAnswer = keyboard.nextLine();

        // correct answer validation. Checks if it's an in. checks to see if it's in range of given amt of possible answers.
        while ((!MenuHandler.isInt(correctAnswer)) || !MenuHandler.isInRange(correctAnswer, 1,(Integer.parseInt(possibleAnswers)))) {
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Enter which choice was the correct answer:");
            correctAnswer = keyboard.nextLine();
        }

        // save question information in new object
        Question q = new Question();
        q.setQuestionID(questionID);
        q.setQuestionText(questionText);
        q.setAnswerChoices(answerChoices);
        q.setCorrectChoice(correctAnswer);
        questionArrayList.add(q);
        System.out.println("\n\nQuestion Created.");
        System.out.println("Returning to Manage Questions Menu.");
        quizCreationMode();
    }


    public static void deleteQuestion() {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> questionIDList = new ArrayList<>();

        System.out.println("\nThis is the Delete Question screen.");
        System.out.println("Enter the question code of the question you'd like to delete.");
        String userInput = keyboard.nextLine();

        for (Question q : questionArrayList) {
            questionIDList.add(q.getQuestionID());
        }
        boolean inQuestionIDList = questionIDList.contains(userInput);

        if (inQuestionIDList) {
            questionArrayList.removeIf(q -> userInput.equals(q.getQuestionID()));
            System.out.printf("\n%s has been deleted.\n", userInput);
        } else {
            System.out.println("\nQuestion ID not found.");
        }

        System.out.println("Returning to Manage Questions menu.");
        quizCreationMode();
    }


    public static void listAllQuestions() {
        System.out.println("\nThis is the List All Questions screen.");
        if (questionArrayList.size()>0) {
            System.out.println("Printing Questions...\n");
            System.out.println("-------------------------");
            for (Question question : questionArrayList) {
                int choiceNum = 1;
                System.out.printf("Question %s: %s\n",question.getQuestionID(), question.getQuestionText());
                System.out.println("Possible Answers: ");
                for (String choice : question.getAnswerChoices()) {
                    System.out.println(choiceNum + ": " + choice);
                    choiceNum++;
                }
                System.out.println("Correct answer is choice #" + (question.getCorrectChoice()+1));
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("There are no questions saved.");
            System.out.println("Returning to Manage Questions menu.");
        }
        quizCreationMode();
    }


    // I don't think this is the most efficient way to do this.
    // This builds a new ArrayList every time this method is run.
    public static boolean questionIDCheck(String qID) {
        boolean result;
        ArrayList<String> questionIDList = new ArrayList<>();
        for (Question q : questionArrayList) {
            questionIDList.add(q.getQuestionID());
        }
        result = questionIDList.contains(qID);
        return result;
    }


} // end QuizCreationMode
