package use_case.note;

public interface NoteOutputBoundary {
    void prepareSuccessView(SaveNoteOutputData user);
    void prepareFailView(String error);
}
