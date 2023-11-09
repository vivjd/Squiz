package use_case.quiz;

public class DisplayQuizOutputData {
    private final String title;

    private boolean useCaseFailed;

    public DisplayQuizOutputData(String title, boolean useCaseFailed){
        this.title = title;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return title;
    }

}
