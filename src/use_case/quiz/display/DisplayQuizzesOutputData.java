package use_case.quiz.display;

import org.bson.types.ObjectId;

/**
 * The {@code DisplayQuizzesOutputData} class represents the output data for displaying quizzes.
 *
 * <p>It encapsulates information about quizzes, including the quiz data and a flag indicating
 * whether the use case for displaying quizzes has failed.</p>
 *
 */
public class DisplayQuizzesOutputData {
    /**
     * A 2D array representing the quizzes data, which contains all the quizzes stored in the database.
     * Each array contains relevant information pertaining to the quiz that will be displayed to the user.
     */
    private final String[][] quizzes;

    private final ObjectId[] ids;
//    private List<String> quizTitles;

    /**
     * A flag indicating whether the use case for displaying quizzes has failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new {@code DisplayQuizzesOutputData} with the specified (most likely the ones in the databse) quizzes.
     *
     * @param quizzes The 2D array representing the quizzes.
     * @param ids
     */
    public DisplayQuizzesOutputData(String[][] quizzes, ObjectId[] ids) {
        this.quizzes = quizzes;
        this.ids = ids;
    }

//    public List<String> getQuizTitles(){
//        return this.quizTitles;
//    }

    public String[][] getQuizzes() {
        return quizzes;
    }

    public ObjectId[] getIds() {
        return ids;
    }
}
