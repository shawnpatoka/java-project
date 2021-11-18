import java.util.ArrayList;

public class Question {
    private String questionID;
    private String questionText;
    private ArrayList<String> answerChoices = new ArrayList<String>();
    private int correctChoice;

    public Question () {

    }


    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(ArrayList<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public int getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = (Integer.parseInt(correctChoice));
    }
}
