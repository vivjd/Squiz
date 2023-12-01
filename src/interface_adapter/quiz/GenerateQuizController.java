package interface_adapter.quiz;
import use_case.quiz.GenerateQuizInputBoundary;
import use_case.quiz.GenerateQuizInputData;

/**
 * Controller responsible for handling the generation of quizzes.
 */
public class GenerateQuizController {
    final GenerateQuizInputBoundary generateQuizUseCaseInteractor;

    /**
     * Constructs a GenerateQuizController with the specified generate quiz use case interactor.
     *
     * @param generateQuizUseCaseInteractor The input boundary for the generate quiz use case.
     */
    public GenerateQuizController(GenerateQuizInputBoundary generateQuizUseCaseInteractor) {
        this.generateQuizUseCaseInteractor = generateQuizUseCaseInteractor;
    }

    /**
     * Executes the generation of a quiz with the provided note and title.
     *
     * @param note  The note associated with the quiz.
     * @param title The title of the quiz.
     * @throws Exception If an error occurs during quiz generation.
     */
    public void execute(String note, String title) throws Exception{
        GenerateQuizInputData generateQuizInputData= new GenerateQuizInputData(note, title);
        this.generateQuizUseCaseInteractor.execute(generateQuizInputData);
    }
}