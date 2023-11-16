package use_case.note.delete;

import use_case.note.NoteDataAccessInterface;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {

    final NoteDataAccessInterface noteDataAccessObject;
    final DeleteNoteOutputBoundary deleteNoteOutputBoundary;

    public DeleteNoteInteractor(NoteDataAccessInterface noteDataAccessObject,
                                DeleteNoteOutputBoundary deleteNoteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.deleteNoteOutputBoundary = deleteNoteOutputBoundary;
    }


    @Override
    public void execute(DeleteNoteInputData deleteNoteInputData) {
        try {
            noteDataAccessObject.deleteNote(deleteNoteInputData.getObjectId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
