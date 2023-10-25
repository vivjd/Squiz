package use_case.note;

import entity.Note;

public class NoteInputData {
    private String title;
    private Note inputText;

    public NoteInputData(String title, Note inputText) {
        this.title = title;
        this.inputText = inputText;
    }

    public void setInputText(Note inputText) {
        this.inputText = inputText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public Note getInputText() {
        return this.inputText;
    }
}
