package interface_adapter.quiz.take_quiz;

import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInputData;

public class TakeQuizController {

    final TakeQuizInputBoundary takeQuizInteractor;
    public TakeQuizController(TakeQuizInputBoundary takeQuizInteractor) {
        this.takeQuizInteractor = takeQuizInteractor;
    }

    public void execute(String title){
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(title);
        takeQuizInteractor.execute(takeQuizInputData);
    }

    public void start(String title) {
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(title);
        takeQuizInteractor.start(takeQuizInputData);
    }

    public void nextQuestion() {
        takeQuizInteractor.next();
    }
}
