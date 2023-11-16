package use_case.quiz;

import entity.Quiz;

import java.util.List;

public class DisplayQuizzesInteractor implements DisplayQuizzesInputBoundary {
//    public static final int COLUMN_NUM = 3;
    final QuizDataAccessInterface quizDataAccessObject;

    final DisplayQuizzesOutputBoundary quizPresenter;

    public DisplayQuizzesInteractor(QuizDataAccessInterface quizDataAccessObject, DisplayQuizzesOutputBoundary quizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void execute() {
//        if (title.isEmpty()){
//            quizPresenter.prepareFailView("Please enter the quiz title you wish to display.");
//        } else {
//            Quiz quiz = quizDataAccessObject.getQuiz(title);
//            DisplayQuizzesOutputData displayQuizOutputData = new DisplayQuizzesOutputData(title, false);
//            quizPresenter.prepareSuccessView(displayQuizOutputData);
//        }
        List<Quiz> quizzes = quizDataAccessObject.getAllQuizzes();
        if (quizzes.isEmpty()){
            quizPresenter.prepareFailView("There are no saved quizzes to display.");
        } else {
//            String[][] outputTableData = new String[quizzes.size()][COLUMN_NUM];
//            for (int i = 0; i < quizzes.size(); i++) {
//                Quiz currentQuiz = quizzes.get(i);
//                outputTableData[i][0] = currentQuiz.getTitle();
//                outputTableData[i][1] = Integer.toString(currentQuiz.getQuizLength());
//                outputTableData[i][2] = currentQuiz.getCreationTime().toString();
//            }
            String[][] outputTableData = quizDataAccessObject.getAllQuizzesTable();
            DisplayQuizzesOutputData displayQuizzesOutputData = new DisplayQuizzesOutputData(outputTableData);
            quizPresenter.prepareSuccessView(displayQuizzesOutputData);
        }
    }
}
