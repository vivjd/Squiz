package use_case.note;

public class NoteOutputData {

    private final String title;
    private Note note;

    private boolean useCaseFailed;

    public SignupOutputData(String title, Note note, boolean useCaseFailed) {
        this.title = title;
        this.note = note;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTitle() {
        return this.title;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(Note newNote) {
        this.note = newNote;
    }
}
