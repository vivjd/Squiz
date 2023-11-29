//package interface_adapter.quiz.take_quiz;
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.quiz.QuizViewModel;
//import interface_adapter.quiz.display_quiz.DisplayQuizState;
//import use_case.quiz.display_quiz.DisplayQuizOutputData;
//import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
//import use_case.quiz.take_quiz.TakeQuizOutputData;
//
//public class TakeQuizPresenter implements TakeQuizOutputBoundary {
//
//    private final QuizViewModel quizViewModel;
//    private final ViewManagerModel viewManagerModel;
//
//    public TakeQuizPresenter(QuizViewModel quizViewModel, ViewManagerModel viewManagerModel) {
//        this.quizViewModel = quizViewModel;
//        this.viewManagerModel = viewManagerModel;
//    }
//
//
//    @Override
//    public void prepareSuccessView(TakeQuizOutputData takeQuizOutputData) {
//
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//
//    }
//}
