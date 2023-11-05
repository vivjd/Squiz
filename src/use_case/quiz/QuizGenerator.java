package use_case.quiz;

import entity.Quiz;

public interface QuizGenerator {

    Quiz createQuiz(String userPrompt);

}
