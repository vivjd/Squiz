package use_case.note;

public interface DeleteNoteOutputBoundary {

    void prepareSuccessView();

    void prepareFailView(String error);
}
