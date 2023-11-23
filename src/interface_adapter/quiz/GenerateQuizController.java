package interface_adapter.quiz;
import use_case.quiz.GenerateQuizInputBoundary;
import use_case.quiz.GenerateQuizInputData;

public class GenerateQuizController {
    final GenerateQuizInputBoundary generateQuizUseCaseInteractor;

    public GenerateQuizController(GenerateQuizInputBoundary generateQuizUseCaseInteractor) {
        this.generateQuizUseCaseInteractor = generateQuizUseCaseInteractor;
    }

    public void execute(String note, String title) throws Exception{
        GenerateQuizInputData generateQuizInputData= new GenerateQuizInputData(note, title);
        this.generateQuizUseCaseInteractor.execute(generateQuizInputData);
    }
}