package use_case.note;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {

    final NoteDataAccessInterface noteDataAccessObject;
    final SaveNoteOutputBoundary saveNoteOutputBoundary;

    public DeleteNoteInteractor(NoteDataAccessInterface noteDataAccessObject,
                                SaveNoteOutputBoundary saveNoteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.saveNoteOutputBoundary = saveNoteOutputBoundary;
    }


    @Override
    public void execute(DeleteNoteInputData deleteNoteInputData) {
        noteDataAccessObject.deleteNote(deleteNoteInputData.getObjectId());
    }
}
