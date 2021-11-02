public class MenuHandler {
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
}
