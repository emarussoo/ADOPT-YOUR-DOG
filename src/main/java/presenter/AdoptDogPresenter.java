package presenter;

import bean.BreedBean;
import bean.TestBean;
import model.breed.Breed;
import model.breed.dao.BreedDao;
import view.UserView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class AdoptDogPresenter {

    UserView view;
    public void getDogsByBreed(){
        //this will be called by view.getBreedToSearch e view.getAllDogs

    }

    public AdoptDogPresenter(UserView view) {
        this.view = view;
    }

    public void processTestAnswers(TestBean userAnswer) throws URISyntaxException, IOException, InterruptedException {
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

        BreedBean breedBean = new BreedBean(resultBreedImage, resultBreedName, resultBreedCoatLength, resultBreedPlayfulness, resultBreedProtectiveness, resultBreedEnergy, resultBreedBarking);
        view.showTestResult(breedBean);

        Logger.getLogger(resultBreed.getName());

        //this will be called by view.getTestAnswers
    }

    public void sendDogAdoptionRequest(){
        //this will be called by view.getDogAdoptionRequestData
    }

    public void setView(UserView view) {
        this.view = view;
    }
}
