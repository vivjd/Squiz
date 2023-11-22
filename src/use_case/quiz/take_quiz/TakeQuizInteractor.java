package use_case.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import use_case.quiz.QuizDataAccessInterface;

import java.util.List;

public class TakeQuizInteractor implements TakeQuizInputBoundary {

    final QuizDataAccessInterface quizDataAccessObject;
    final TakeQuizOutputBoundary takeQuizPresenter;

    public TakeQuizInteractor(QuizDataAccessInterface quizDataAccessObject, TakeQuizOutputBoundary takeQuizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.takeQuizPresenter = takeQuizPresenter;
    }

    @Override
    public void execute(TakeQuizInputData takeQuizInputData) {

        int score;

        Quiz quiz = quizDataAccessObject.getQuiz(takeQuizInputData.getTitle());
        List<Question<?>> questionList = quiz.getQuestions();
        List<?> responses = takeQuizInputData.getResponses();

        score = gradeQuiz(questionList, responses);

        TakeQuizOutputData outputData = new TakeQuizOutputData(score);

        takeQuizPresenter.prepareSuccessView(outputData);
    }

    private int gradeQuiz(List<Question<?>> questionList, List<?> responses) {
        int score = 0;
        for (int i = 0; i < questionList.size(); i++) {
            Question question = questionList.get(i);
            Object response = responses.get(i);

            score += question.checkAnswer(response);
        }

        return score;
    }
}
