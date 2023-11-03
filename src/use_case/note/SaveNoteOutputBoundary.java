package use_case.note;

public interface SaveNoteOutputBoundary {
    void prepareSuccessView(SaveNoteOutputData user);
    void prepareFailView(String error);
}
