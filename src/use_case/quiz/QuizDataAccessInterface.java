package use_case.quiz;

import entity.Quiz;
import org.bson.types.ObjectId;

import java.util.List;
/**
 * The {@code QuizDataAccessInterface} interface defines the contract for data access
 * operations related to quizzes. Implementations of this interface are responsible
 * for interacting with a data source to perform the defined methods.
 *
 * @see entity.Quiz
 */
public interface QuizDataAccessInterface {
    /**
     * Saves the given quiz to the data source.
     *
     * @param quiz The quiz to be saved.
     */
    void saveQuiz(Quiz quiz);

    /**
     * Retrieves a quiz from the database based on its title.
     *
     * @param title The title of the quiz to retrieve.
     * @return The retrieved quiz, or {@code null} if not found.
     */
    Quiz getQuiz(String title);


    List<Quiz> getAllQuizzes();

    /**
     * Retrieves information about all quizzes in a 2D array to be used for displaying the quizzes.
     *
     * @return A 2D array representing quiz information in a tabular format.
     */
    String[][] getAllQuizzesTable();

    /**
     * Retrieves a quiz from the data source based on its unique identifier (ID).
     *
     * @param quizId The unique identifier of the quiz to retrieve.
     * @return The retrieved quiz.
     */
    Quiz getQuizById(ObjectId quizId);

    void deleteQuizById(ObjectId quizId);
}
