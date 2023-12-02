package use_case.quiz.generate;

import entity.Quiz;

public interface QuizGenerator {

    Quiz createQuiz(String userPrompt);

}
