package use_case.quiz;

public class GenerateQuizInputData {
    private String note;
    private String title;
    public GenerateQuizInputData(String note, String title){
        this.note = note;
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public String getNote() {
        return this.note;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
