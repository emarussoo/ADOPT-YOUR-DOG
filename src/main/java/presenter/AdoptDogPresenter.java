package presenter;

import bean.TestBean;
import model.breed.Breed;
import model.breed.dao.BreedDao;
import view.UserView;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdoptDogPresenter {

    UserView view;
    public void getDogsByBreed(){
        //this will be called by view.getBreedToSearch e view.getAllDogs

    }

    public AdoptDogPresenter(UserView view) {
        this.view = view;
    }

    public void processTestAnswers(TestBean userAnswer) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Procedo a processare le risposte");
        BreedDao breedDao = new BreedDao();
        Breed resultBreed = breedDao.getBreedByAnswers(userAnswer.getUserAnswers());

        System.out.println(resultBreed.getName());
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
