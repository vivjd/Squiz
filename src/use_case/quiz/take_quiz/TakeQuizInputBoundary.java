package use_case.quiz.take_quiz;

public interface TakeQuizInputBoundary {

    void start(TakeQuizInputData takeQuizInputData);
    void execute(TakeQuizInputData takeQuizInputData);

    void next();


}
