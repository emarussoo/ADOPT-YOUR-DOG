package presenter;

import bean.BreedBean;
import bean.TestBean;
import model.breed.Breed;
import model.breed.dao.BreedDao;
//import view.UserView;
//import view.user.TestViewGraphicalController;
import view.user.windowmanager.StarterWindow;

import java.io.IOException;
import java.net.URISyntaxException;

public class AdoptDogController {

    StarterWindow view;
    public void getDogsByBreed(){
        //this will be called by view.getBreedToSearch e view.getAllDogs

    }

    public AdoptDogController() {
    }

    public BreedBean processTestAnswers(TestBean userAnswer) throws URISyntaxException, IOException, InterruptedException {
        BreedDao breedDao = new BreedDao();
        Breed resultBreed = breedDao.getBreedByAnswers(userAnswer.getUserAnswers());

        String resultBreedImage = resultBreed.getImageLink();
        String resultBreedName = resultBreed.getName();
        String resultBreedCoatLength = resultBreed.getCoatLength();
        String resultBreedPlayfulness = resultBreed.getPlayfulness();
        String resultBreedProtectiveness = resultBreed.getProtectiveness();
        String resultBreedEnergy = resultBreed.getEnergy();
        String resultBreedBarking = resultBreed.getBarking();
        //String resultBreedMaxHeightMale = resultBreed.getMaxHeightMale();

        return new BreedBean(resultBreedImage, resultBreedName, resultBreedCoatLength, resultBreedPlayfulness, resultBreedProtectiveness, resultBreedEnergy, resultBreedBarking);
        //this will be called by view.getTestAnswers
    }

    public void sendDogAdoptionRequest(){
        //this will be called by view.getDogAdoptionRequestData
    }

    /*public void setView(UserView view) {
        this.view = view;
    }*/
}
