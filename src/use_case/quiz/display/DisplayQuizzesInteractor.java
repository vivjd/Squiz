package use_case.quiz.display;

import entity.Quiz;
import use_case.quiz.QuizDataAccessInterface;

import java.util.List;
/**
 * The {@code DisplayQuizzesInteractor} class is responsible for executing the display of quizzes
 * in the database by interacting with the provided data access object and presenting the
 * results through the {@link DisplayQuizzesOutputBoundary} output boundary.
 *
 * <p>This class implements the {@link DisplayQuizzesInputBoundary} interface.</p>
 *
 */
public class DisplayQuizzesInteractor implements DisplayQuizzesInputBoundary {
    final QuizDataAccessInterface quizDataAccessObject;

    final DisplayQuizzesOutputBoundary quizPresenter;

    /**
     * Constructs a new {@code DisplayQuizzesInteractor} with the specified dependencies.
     *
     * @param quizDataAccessObject The data access object providing access to quiz information.
     * @param quizPresenter        The presenter for displaying all the quiz in the database.
     */
    public DisplayQuizzesInteractor(QuizDataAccessInterface quizDataAccessObject, DisplayQuizzesOutputBoundary quizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.quizPresenter = quizPresenter;
    }

    /**
     * Executes the display of quizzes. Retrieves all quizzes from the data access object and
     * prepares the data for presentation through the output boundary.
     */
    @Override
    public void execute() {
        List<Quiz> quizzes = quizDataAccessObject.getAllQuizzes();
        if (quizzes.isEmpty()){
            quizPresenter.prepareFailView("There are no saved quizzes to display. Please create a quiz first.");
        } else {
            String[][] outputTableData = quizDataAccessObject.getAllQuizzesTable();
            DisplayQuizzesOutputData displayQuizzesOutputData = new DisplayQuizzesOutputData(outputTableData, quizDataAccessObject.getAllIds());
            quizPresenter.prepareSuccessView(displayQuizzesOutputData);
        }
    }
}
