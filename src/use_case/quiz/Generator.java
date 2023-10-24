package use_case.quiz;

import entity.Quiz;

public interface Generator {

    Quiz createQuiz(String userPrompt);

}
