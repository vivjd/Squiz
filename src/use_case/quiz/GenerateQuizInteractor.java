package use_case.quiz;

import data_access.QuizDataAccessObject;
import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Quiz;
import entity.Question;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateQuizInteractor implements GenerateQuizInputBoundary {
    final GenerateQuizOutputBoundary quizPresenter;

    public GenerateQuizInteractor(GenerateQuizOutputBoundary quizPresenter) {
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void execute(GenerateQuizInputData generateQuizInputData) throws Exception {
        try {

            // User's input, note, is obtained through controller and passed in as a part of tailored ChatGPT prompt to
            // generate the raw string format of quiz.

            String userInput = "create 5 multiple choice questions with 4 options and answer indicated followed by 5 Open-ended questions with answers to each question, each about this note: "
                    + generateQuizInputData.getNote()
                    + "; for the multiple choice, it should follow the format of question, followed by a hashmap of answer options, which are followed by the index of the correct answer in that hashmap." +
                    "Format the answer choices for multiple choice questions into a hashmap encapsulated in curly braces in one line. Show the correct answer choice in the next line.";
            String response = Chatbot.getChatGPTResponse(userInput);
            System.out.println(response);

            // To format the raw string appropriately to facilitate converting to various entities, tje raw string is
            // splitted into an array of String, splitted at every new line escape character. Then the array is converted
            // into a list for more built-in methods to facilitate formatting.

            String[] entireArray = response.split("\n");
            List<String> entirelist = Arrays.asList(entireArray);
            System.out.println(entirelist);

            // The int variable mcqStart marks the start of the mcq question in the list. the very next element stored after
            // this index stores the question of the first mcq question. Same for the open-ended questions.

            int mcqStart = 0;
            int openStart = 0;

            for (String x : entireArray){
                if (x.toUpperCase().contains("HOICE QUESTION")){
                    mcqStart = entirelist.indexOf(x);
                    System.out.println(mcqStart);
                }
                else if (x.toUpperCase().contains("NDED QUESTION")){
                    openStart = entirelist.indexOf(x);
                    System.out.println(openStart);
                }
            }

            // The formatted list at this point is as following:
            // [question_1, answerChoices, correctAnswer,
            //  question_2, answerChoices, correctAnswer,
            //  question_3, answerChoices, correctAnswer, ...]

            // This design of list allows the following lines...:

            int mcq1q = mcqStart + 1;
            int mcq2q = mcq1q + 3;
            int mcq3q = mcq2q + 3;
            int mcq4q = mcq3q + 3;
            int mcq5q = mcq4q + 3;
            int opq1q = openStart + 1;
            int opq2q = opq1q + 2;
            int opq3q = opq2q + 2;
            int opq4q = opq3q + 2;
            int opq5q = opq4q + 2;

            // Generating Question entities accordingly

            MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion(entirelist.get(mcq1q),
                    entirelist.get(mcq1q+1),
                    entirelist.get(mcq1q+2));
            MultipleChoiceQuestion mcq2 = new MultipleChoiceQuestion(entirelist.get(mcq2q),
                    entirelist.get(mcq2q+1),
                    entirelist.get(mcq1q+2));
            MultipleChoiceQuestion mcq3 = new MultipleChoiceQuestion(entirelist.get(mcq3q),
                    entirelist.get(mcq3q+1),
                    entirelist.get(mcq1q+2));
            MultipleChoiceQuestion mcq4 = new MultipleChoiceQuestion(entirelist.get(mcq4q),
                    entirelist.get(mcq4q+1),
                    entirelist.get(mcq1q+2));
            MultipleChoiceQuestion mcq5 = new MultipleChoiceQuestion(entirelist.get(mcq5q),
                    entirelist.get(mcq5q+1),
                    entirelist.get(mcq1q+2));

            OpenEndedQuestion opq1 = new OpenEndedQuestion(entirelist.get(opq1q), entirelist.get(opq1q+1));
            OpenEndedQuestion opq2 = new OpenEndedQuestion(entirelist.get(opq2q), entirelist.get(opq2q+1));
            OpenEndedQuestion opq3 = new OpenEndedQuestion(entirelist.get(opq3q), entirelist.get(opq3q+1));
            OpenEndedQuestion opq4 = new OpenEndedQuestion(entirelist.get(opq4q), entirelist.get(opq4q+1));
            OpenEndedQuestion opq5 = new OpenEndedQuestion(entirelist.get(opq5q), entirelist.get(opq5q+1));
            List<Question<?>> qList = new ArrayList<>();

            // Stores all of the questions generated into a list since the Quiz entity takes an a list attribute to store
            // all the questions (10 of them in total).

            qList.add(mcq1);
            qList.add(mcq2);
            qList.add(mcq3);
            qList.add(mcq4);
            qList.add(mcq5);

            qList.add(opq1);
            qList.add(opq2);
            qList.add(opq3);
            qList.add(opq4);
            qList.add(opq5);

            // Quiz entity generated

            Quiz quiz = new Quiz(generateQuizInputData.getTitle(), LocalDateTime.now());
            quiz.setQuestions(qList);
            if (quiz.getQuizLength() != 10){
                quizPresenter.prepareFailView("Quiz not Generated. Please try again.");
            }
            else{
                QuizDataAccessObject quizDAO = new QuizDataAccessObject();
                quizDAO.saveQuiz(quiz);
                quizPresenter.prepareSuccessView("Quiz Generated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private static int convert(String c){
//        if (c.equalsIgnoreCase("A")){
//            return 0;
//        } else if(c.equalsIgnoreCase("B")){
//            return 1;
//        } else if(c.equalsIgnoreCase("C")){
//            return 2;
//        }else if(c.equalsIgnoreCase("D")){
//            return 3;
//        }
//        else{
//            return -1;
//        }
//    }
}