package use_case.note;

public interface NoteOutputBoundary {
    void prepareSuccessView(NoteOutputData user);
    void prepareFailView(String error);
}
