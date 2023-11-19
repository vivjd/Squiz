package use_case.note.save;

public interface SaveNoteOutputBoundary {
    void prepareSuccessView(SaveNoteOutputData user);
    void prepareFailView(String error);
}
