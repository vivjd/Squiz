package use_case.note.save;

/**
 * The `NoteOutputData` class represents the output data from the Save Notes use case.
 * It contains information about the note's title and associated input text, as well as a flag
 * indicating whether the save notes operation failed.
 */
public class SaveNoteOutputData {
    private final String title;
    private String inputText;

    private boolean useCaseFailed;

    /**
     * Constructs a `NoteOutputData` object with the provided title, input text, and use case failure status.
     *
     * @param title The title of the note.
     * @param inputText The input text associated with the note.
     * @param useCaseFailed A boolean indicating whether the save notes use case failed.
     */
    public SaveNoteOutputData(String title, String inputText, boolean useCaseFailed) {
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

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
