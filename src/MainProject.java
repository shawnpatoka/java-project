public class MainProject {
    public static void main(String[] args) {

        while (!SecretWord.getIsSafe()){
            SecretWord.runSecretWord();
        }
        MenuHandler.runMainMenu();

    } // end of main method
}
