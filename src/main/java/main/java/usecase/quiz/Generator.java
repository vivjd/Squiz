package main.java.usecase.quiz;

import main.java.entity.Quiz;

public interface Generator {

    Quiz createQuiz(String userPrompt);

}
