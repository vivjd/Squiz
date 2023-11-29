//package use_case.quiz.take_quiz;
//
//import entity.Question;
//import entity.Quiz;
//import use_case.quiz.QuizDataAccessInterface;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class TakeQuizInteractor implements TakeQuizInputBoundary {
//
//    final QuizDataAccessInterface quizDataAccessObject;
//    final TakeQuizOutputBoundary takeQuizPresenter;
//
//    public TakeQuizInteractor(QuizDataAccessInterface quizDataAccessObject, TakeQuizOutputBoundary takeQuizPresenter) {
//        this.quizDataAccessObject = quizDataAccessObject;
//        this.takeQuizPresenter = takeQuizPresenter;
//    }
//
//    @Override
//    public void execute(TakeQuizInputData takeQuizInputData) {
//
//        int score;
//
//        Quiz quiz = quizDataAccessObject.getQuiz(takeQuizInputData.getTitle());
//        Iterator<Question<?>> questionIterator= quiz.getQuestions().iterator();
//        Iterator<?> responses = takeQuizInputData.getResponses().iterator();
//
//        score = gradeQuiz(questionIterator, responses);
//
//        TakeQuizOutputData outputData = new TakeQuizOutputData(score);
//
//        takeQuizPresenter.prepareSuccessView(outputData);
//    }
//
//    private int gradeQuiz(Iterator<Question<?>> questionIterator, Iterator<? extends Object> responseIterator) {
//        int score = 0;
//        while (questionIterator.hasNext() && responseIterator.hasNext()) {
//            Question<?> question = questionIterator.next();
//            Object response = responseIterator.next();
//
//            score += question.checkAnswer(response);
//        }
//
//        return score;
//    }
//}
