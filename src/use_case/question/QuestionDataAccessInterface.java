package use_case.question;

import entity.Question;

public interface QuestionDataAccessInterface {
    void saveQuestion(Question question);

    Question getQuestion();

    Question getQuestionByName(String questionName);
}
