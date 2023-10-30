package interface_adapter.note;

import entity.Note;

public class NoteState {
    private String title = "";
    private String note = "";
    private String emptyNoteError = null;

    public NoteState(){}

    public NoteState(NoteState copy) {
       title = copy.title;
       note = copy.note;
       emptyNoteError = copy.emptyNoteError;
    }

    public String getTitle(){return title;}

    public void setTitle(String title) {this.title = title;}

    public String getNote(){return note;}

    public void setNote(String note) {this.note = note;}

    public String getEmptyNoteError(){return emptyNoteError;}

    public void setEmptyNoteError(String emptyNoteError) {this.emptyNoteError = emptyNoteError;}

}
