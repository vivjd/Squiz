package use_case.quiz.take_quiz;

import org.bson.types.ObjectId;

import java.util.List;

public class TakeQuizInputData {

    private final String title;

    public String getTitle() {
        return title;
    }


    public TakeQuizInputData(String title) {
        this.title = title;
    }

}
