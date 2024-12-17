package presenter;

import view.UserView;

public class AdoptDogPresenter {

    UserView view;
    public void getDogsByBreed(){
        //this will be called by view.getBreedToSearch e view.getAllDogs

    }

    public AdoptDogPresenter(UserView view) {
        this.view = view;
    }

    public void processTestAnswers(){
        System.out.println("Procedo a processare le risposte");
        view.loadPage("dogs-user-page");
        //this will be called by view.getTestAnswers
    }

    public void sendDogAdoptionRequest(){
        //this will be called by view.getDogAdoptionRequestData
    }

    public void setView(UserView view) {
        this.view = view;
    }
}
