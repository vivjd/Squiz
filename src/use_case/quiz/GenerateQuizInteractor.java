package use_case.quiz;

import entity.MultipleChoiceQuestion;

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
            String userInput = "create 5 multiple choice questions with 4 options and answer indicated followed by 5 Open-ended questions with answers to each question, each about this note: "
                    + generateQuizInputData.getNote()
                    + "; for the multiple choice, it should follow the format of question, followed by a hashmap of answer options, which are followed by the index of the correct answer in that hashmap." +
                    "Format the answer choices fro multiple choice questions into a hashmap encapsulated in curly braces in one line. Show the correct answer in the next line.";
            String response = Chatbot.getChatGPTResponse(userInput);
            System.out.println(response);
            GenerateQuizOutputData generateQuizOutputData = new GenerateQuizOutputData(generateQuizInputData.getTitle());
            String[] entireArray = response.split("\n");
            List<String> entirelist = Arrays.asList(entireArray);
            System.out.println(entirelist);
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



        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}