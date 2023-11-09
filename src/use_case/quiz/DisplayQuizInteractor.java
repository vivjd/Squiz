package use_case.quiz;

import entity.Quiz;

public class DisplayQuizInteractor implements DisplayQuizInputBoundary{
    final QuizDataAccessInterface quizDataAccessObject;

    final DisplayQuizOutputBoundary quizPresenter;

    public DisplayQuizInteractor(QuizDataAccessInterface quizDataAccessObject, DisplayQuizOutputBoundary quizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void execute(DisplayQuizInputData displayQuizInputData) {
        String title = displayQuizInputData.getTitle();
        if (title.isEmpty()){
            quizPresenter.prepareFailView("Please enter the quiz title you wish to display.");
        } else {
            Quiz quiz = quizDataAccessObject.getQuiz(title);
            DisplayQuizOutputData displayQuizOutputData = new DisplayQuizOutputData(title, false);
            quizPresenter.prepareSuccessView(displayQuizOutputData);
        }
    }
}
