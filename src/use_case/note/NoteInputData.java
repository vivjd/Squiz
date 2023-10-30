package use_case.note;

import entity.Note;

public class NoteInputData {
    private String title;
    private String inputText;

    public NoteInputData(String title, String inputText) {
        this.title = title;
        this.inputText = inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getInputText() {
        return this.inputText;
    }
}
