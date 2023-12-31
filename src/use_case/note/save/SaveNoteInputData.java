package use_case.note.save;

/**
 * This extracts the inputted data by the user.
 */
public class SaveNoteInputData {
    private String title;
    private String inputText;

    /**
     * The constructor for a NoteInputData object.
     * @param title the title of the note as inputted by the user
     * @param inputText the body of the note
     */
    public SaveNoteInputData(String title, String inputText) {
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
