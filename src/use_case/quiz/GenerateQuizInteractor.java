package use_case.quiz;

public class GenerateQuizInteractor implements GenerateQuizInputBoundary {
    final GenerateQuizOutputBoundary quizPresenter;

    public GenerateQuizInteractor(GenerateQuizOutputBoundary quizPresenter) {
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void execute(GenerateQuizInputData generateQuizInputData) throws Exception {
        try {
            String userInput = "create 5 multiple choice questions with 4 options and answer indicated followed by 5 Open-ended questions with answers to each question, each about this note: " + generateQuizInputData.getNote();
            String response = Chatbot.getChatGPTResponse(userInput);
            System.out.println(response);
            GenerateQuizOutputData generateQuizOutputData = new GenerateQuizOutputData(generateQuizInputData.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}