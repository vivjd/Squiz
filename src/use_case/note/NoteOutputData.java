package use_case.note;

public class NoteOutputData {

    private final String title;
    private String inputText;

    private boolean useCaseFailed;

    public NoteOutputData(String title, String inputText, boolean useCaseFailed) {
        this.title = title;
        this.inputText = inputText;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return this.title;
    }

    public String getInputText() {
        return this.inputText;
    }
    public void setInputText(String inputText){this.inputText = inputText;}
}
