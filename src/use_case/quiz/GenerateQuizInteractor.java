package use_case.quiz;

import data_access.QuizDataAccessObject;
import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Quiz;
import entity.Question;
import java.time.LocalDateTime;

import java.util.*;

/**
 * The GenerateQuizInteractor class is responsible for generating a quiz based on user input.
 * It implements the GenerateQuizInputBoundary interface and utilizes a QuizPresenter to handle the output.
 *
 * This class takes user input, processes it using ChatGPT, and generates a quiz consisting of multiple-choice
 * and open-ended questions. The generated quiz is then stored in the data access layer.
 */
public class GenerateQuizInteractor implements GenerateQuizInputBoundary {
    /** The presenter for displaying quiz generation results. */
    final GenerateQuizOutputBoundary quizPresenter;

    /**
     * Constructs a GenerateQuizInteractor with the specified quizPresenter.
     *
     * @param quizPresenter The presenter for displaying quiz generation results.
     */
    public GenerateQuizInteractor(GenerateQuizOutputBoundary quizPresenter) {
        this.quizPresenter = quizPresenter;
    }


    /**
     * Executes the quiz generation process based on user input.
     *
     * @param generateQuizInputData The input data containing user-specific information.
     * @throws Exception If an error occurs during the quiz generation process.
     */
    @Override
    public void execute(GenerateQuizInputData generateQuizInputData) throws Exception {
        try {
            // User's input, note, is obtained through controller and passed in as a part of tailored ChatGPT prompt to
            // generate the raw string format of quiz.

            String userInput = "create 5 multiple choice questions with 4 options and answer indicated followed by 5 Open-ended questions with answers to each question, each about this note: "
                    + generateQuizInputData.getNote()
                    + "; for the multiple choice, it should follow the format of question, followed by a hashmap of answer options, which are followed by the index of the correct answer in that hashmap." +
                    "Format the answer choices for multiple choice questions into a hashmap encapsulated in curly braces in one line. Show the correct answer choice in the next line." +
                    "Follow this format for the answer choices: {Option A: ~~~, Option B: ~~~, Option C: ~~~}. No empty lines are allowed.";
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
                }
                else if (x.toUpperCase().contains("NDED QUESTION")){
                    openStart = entirelist.indexOf(x);
                }
            }


            // The formatted list at this point is as following:
            // [question_1, answerChoices, correctAnswer,
            //  question_2, answerChoices, correctAnswer,
            //  question_3, answerChoices, correctAnswer, ...]

            // This design of list allows the following lines...:

            int mcq1q = mcqStart + 2;
            int mcq2q = mcq1q + 4;
            int mcq3q = mcq2q + 4;
            int mcq4q = mcq3q + 4;
            int mcq5q = mcq4q + 4;
            int opq1q = openStart + 2;
            int opq2q = opq1q + 3;
            int opq3q = opq2q + 3;
            int opq4q = opq3q + 3;
            int opq5q = opq4q + 3;


//            System.out.println(entirelist.get(opq1q));
//            System.out.println(entirelist.get(opq1q + 1));
//            System.out.println(entirelist.get(opq2q));
//            System.out.println(entirelist.get(opq2q + 1));
//            System.out.println(entirelist.get(opq3q));
//            System.out.println(entirelist.get(opq3q + 1));
//            System.out.println(entirelist.get(opq4q));
//            System.out.println(entirelist.get(opq4q + 1));
//            System.out.println(entirelist.get(opq5q));
//            System.out.println(entirelist.get(opq5q + 1));

            // Generating Question entities accordingly
            // Before doing so, answer choices for each MCQ has to be converted into a HashMap of Stirng and String:

            MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion(entirelist.get(mcq1q),
                    helper(entirelist.get(mcq1q+1)),
                    entirelist.get(mcq1q+2));
            MultipleChoiceQuestion mcq2 = new MultipleChoiceQuestion(entirelist.get(mcq2q),
                    helper(entirelist.get(mcq2q+1)),
                    entirelist.get(mcq2q+2));
            MultipleChoiceQuestion mcq3 = new MultipleChoiceQuestion(entirelist.get(mcq3q),
                    helper(entirelist.get(mcq3q+1)),
                    entirelist.get(mcq3q+2));
            MultipleChoiceQuestion mcq4 = new MultipleChoiceQuestion(entirelist.get(mcq4q),
                    helper(entirelist.get(mcq4q+1)),
                    entirelist.get(mcq4q+2));
            MultipleChoiceQuestion mcq5 = new MultipleChoiceQuestion(entirelist.get(mcq5q),
                    helper(entirelist.get(mcq5q+1)),
                    entirelist.get(mcq5q+2));

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
                quizPresenter.prepareSuccessView("Quiz Generated");
                System.out.println("success!");
                QuizDataAccessObject quizDAO = new QuizDataAccessObject();
                quizDAO.saveQuiz(quiz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Helper method to convert a string representation of answer choices into a Map.
     *
     * @param input The string representation of answer choices in the format {Option A: ~~~, Option B: ~~~, Option C: ~~~}.
     * @return A Map containing the answer choices.
     */
    private static Map<String, String> helper(String input){
        String res = input.substring(1, input.length()-1);           //remove curly brackets
        String[] keyValuePairs = res.split(",");              //split the string to creat key-value pairs
        Map<String,String> acformated = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split(":");                   //split the pairs to get key and value
            acformated.put(entry[0], entry[1]);          //add them to the hashmap and trim whitespaces
        }
        return acformated;
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