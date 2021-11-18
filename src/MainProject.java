

public class MainProject {
    public static void main(String[] args) {

        while (!SecretWord.getIsSafe()){
            SecretWord.runSecretWord();
        }
        ReadingSaving.readFiles();
        MenuHandler.runMainMenu();




    } // end of main method
}
