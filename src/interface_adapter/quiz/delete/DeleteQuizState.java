package interface_adapter.quiz.delete;

public class DeleteQuizState {
    private String deletedQuizName;

    public DeleteQuizState(){}

    public String getDeletedQuizName() {
        return deletedQuizName;
    }

    public void setDeletedQuizName(String deletedQuizName) {
        this.deletedQuizName = deletedQuizName;
    }
}
