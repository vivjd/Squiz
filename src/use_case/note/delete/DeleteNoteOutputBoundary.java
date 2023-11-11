package use_case.note.delete;

public interface DeleteNoteOutputBoundary {

    void prepareSuccessView();

    void prepareFailView(String error);
}
