package use_case.quiz.take_quiz;

import org.bson.types.ObjectId;

import java.util.List;

public class TakeQuizInputData {

    private final String title;
    private final ObjectId objectId;
    private final List<?> responses;

    public String getTitle() {
        return title;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public TakeQuizInputData(String title, ObjectId objectId, List<?> responses) {
        this.title = title;
        this.objectId = objectId;
        this.responses = responses;
    }

    public List<?> getResponses() {
        return this.responses;
    }
}
