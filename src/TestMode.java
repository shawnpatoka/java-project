import java.util.Scanner;

public class TestMode {

    public static void testMode() {
        Scanner keyboard = new Scanner(System.in);
        String firstName;
        String lastName;
        String numberOfQuestion;

        System.out.println("\nThis is The Test Mode");
        System.out.println("Enter your first name.");
        firstName = keyboard.nextLine();
        System.out.println("Enter your last name.");
        lastName = keyboard.nextLine();
        System.out.println("Enter number of questions.");
        numberOfQuestion = keyboard.nextLine();
        while (!MenuHandler.isInt(numberOfQuestion)){
            System.out.println("\n* * * You made an invalid entry, please try again. * * *\n");
            System.out.println("Enter number of questions.");
            numberOfQuestion = keyboard.nextLine();
        }

        System.out.println("\nStarting Quiz...\n");
        System.out.println("Press Return to continue back to main menu.\n");
        keyboard.nextLine();
        MainProject.main(null);

    }
}