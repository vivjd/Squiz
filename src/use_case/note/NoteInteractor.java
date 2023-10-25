package use_case.note;

import data_access.NoteDataAccessObject;
import entity.Note;

public class NoteInteractor implements NoteInputBoundary {
    final NoteDataAccessObject noteDataAccessObject;
    final NoteOutputBoundary notePresenter;

    public NoteInteractor(NoteDataAccessObject noteDataAccessObject, NoteOutputBoundary noteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.notePresenter = noteOutputBoundary;
    }

    public void execute(NoteInputData noteInputData) {
        // Assume that the user always enters a valid input or the input is empty?
        Note inputNote = noteInputData.getInputText();
        if (inputNote.getTitle().isEmpty()) {
            // Display a message telling the user to input a title
            notePresenter.prepareFailView("Please enter a title for your note.");
        } else if (inputNote.getUserPrompt().isEmpty()) {
            // Display a message telling the user to input contents for their note
            notePresenter.prepareFailView("Please enter a minimum of 40 words for your " + inputNote.getTitle() + " note.")
        } else {
            Note note = noteDataAccessObject.getNote(inputNote.getTitle());
//            The two lines below will be implemented after the Presenter and OutputData are implemented.
            NoteOutputData noteOutputData = new NoteOutputData();
            notePresenter.prepareSuccessView(noteOutputData);
        }

    }
}
