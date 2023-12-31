package interface_adapter.quiz.display;

import org.bson.types.ObjectId;

/**
 * The {@code DisplayQuizzesState} class represents the state of the "Display Quizzes" view.
 * It holds information such as the table of quizzes and any error messages related to the
 * absence of quizzes.
 *
 * <p>Instances of this class are used to communicate the state of the view between the
 * {@link DisplayQuizzesViewModel} and the {@link DisplayQuizzesPresenter}.</p>
 *
 * @see DisplayQuizzesViewModel
 * @see DisplayQuizzesPresenter
 */

public class DisplayQuizzesState {
    private String[][] quizzesTable;

    private String emptyQuizzesError = null;

    private ObjectId[] ids;

    public DisplayQuizzesState(){

    }

    public ObjectId[] getIds() {
        return ids;
    }

    public void setIds(ObjectId[] ids) {
        this.ids = ids;
    }

    public void setQuizzesTable(String[][] quizzesTable){
        this.quizzesTable = quizzesTable;
    }

    public String[][] getQuizzesTable() {
        return quizzesTable;
    }

    public void setEmptyQuizError(String emptyQuizzesError) {
        this.emptyQuizzesError = emptyQuizzesError;
    }

    public String getEmptyQuizzesError(){return emptyQuizzesError;}
}
