package interface_adapter.note.back;


import use_case.back.BackOutputBoundary;

public class BackController {
    BackOutputBoundary backPresenter;

    public BackController(BackPresenter backPresenter) {this.backPresenter = backPresenter;}

    public void execute(){
        backPresenter.prepareSuccessView();
    }
}
