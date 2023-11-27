package use_case.quiz;

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
                    "Format the answer choices fro multiple choice questions into a hashmap";
            String response = Chatbot.getChatGPTResponse(userInput);
            System.out.println(response);
            GenerateQuizOutputData generateQuizOutputData = new GenerateQuizOutputData(generateQuizInputData.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}