package interface_adapter.note.display_notes;

import interface_adapter.quiz.DisplayQuizzesState;

/**
 * The {@code DisplayNotesState} class represents the state of the "Display Notes" view.
 * It holds information such as the table of notes and any error messages related to the
 * absence of notes.
 *
 * <p>Instances of this class are used to communicate the state of the view between the
 * {@link DisplayNotesViewModel} and the {@link DisplayNotesPresenter}.</p>
 *
 * @see DisplayNotesViewModel
 * @see DisplayNotesPresenter
 */
public class DisplayNotesState {
    private String[][] table;
    private String emptyNotesError = null;

    public DisplayNotesState(){}
    public void setTable(String[][] table) {this.table = table;}
    public String[][] getTable(){return table;}
    public void setEmptyNotesError(String emptyNotesError){this.emptyNotesError = emptyNotesError;}
    public String getEmptyNotesError(){return emptyNotesError;}

}
