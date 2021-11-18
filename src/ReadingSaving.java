import java.io.File;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingSaving {



    public static void readFiles() {
        ObjectMapper om = new ObjectMapper();
        try {
            QuizCreationMode.questionArrayList = om.readValue(new File("questionList.json"), new TypeReference<ArrayList<Question>>() {
            });
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        // reads JSON
//    ArrayList<Question> questionList = om.readValue(new File("questions.json"), new TypeReference<ArrayList<Question>>(){});
    }

    public static void writeFiles() {
        ObjectMapper om = new ObjectMapper();

        try {
            om.writeValue(new File("questionList.json"), QuizCreationMode.questionArrayList);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        // reads JSON
//    ArrayList<Question> questionList = om.readValue(new File("questions.json"), new TypeReference<ArrayList<Question>>(){});
    }


}
