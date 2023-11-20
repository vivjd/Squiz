package use_case.quiz;

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
//    private List<String> quizTitles;

    /**
     * A flag indicating whether the use case for displaying quizzes has failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new {@code DisplayQuizzesOutputData} with the specified (most likely the ones in the databse) quizzes.
     *
     * @param quizzes The 2D array representing the quizzes.
     */
    public DisplayQuizzesOutputData(String[][] quizzes) {this.quizzes = quizzes;}

//    public List<String> getQuizTitles(){
//        return this.quizTitles;
//    }

    public String[][] getQuizzes() {
        return quizzes;
    }

}
