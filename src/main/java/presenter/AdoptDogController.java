package presenter;

import bean.*;
import model.breed.Breed;
import model.breed.dao.BreedDao;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.windowmanager.UserMenuController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

public class AdoptDogController {
    private static final Logger debugLogger = LogManager.getLogger("debugLogger");

    UserMenuController view;
    public List<DogProfileBean> getAllDogs(){
        List<Dog> listOfAllDogs;
        listOfAllDogs = DaoFactory.getDaoSingletonFactory().createDogDao().getAllDogs();

        List<DogProfileBean> listOfAllDogsBean = new ArrayList<>();
        for(Dog dog : listOfAllDogs){
            String dogIdBean = String.valueOf(dog.getDogId());
            String dogNameBean = dog.getDogName();
            String dogAgeBean = String.valueOf(dog.getDogAge());
            String dogBreedBean = dog.getDogBreed();
            //String dogkKennelNameBean = "prova";
            String dogkKennelNameBean = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(dog.getKennelId()).getKennelName();
            String dogKennelIdBean = String.valueOf(dog.getKennelId());

            listOfAllDogsBean.add(new DogProfileBean(dogIdBean, dogNameBean, dogAgeBean, dogBreedBean, dogkKennelNameBean, dogKennelIdBean));
        }
        return listOfAllDogsBean;
    }

    public List<DogProfileBean> getDogsByBreed(List<DogProfileBean> beforeDogs, DogBreedSearchBean dogBreedSearchBean){
        if(dogBreedSearchBean.getName().equals("")){
            return getAllDogs();
        }
        List<DogProfileBean> filteredDogsList = new ArrayList<>();
        for(DogProfileBean dog : beforeDogs){
            if(dog.getDogBreed().equals(dogBreedSearchBean.getName())){
                filteredDogsList.add(dog);
            }
        }
        return filteredDogsList;
    }

    public AdoptDogController() {
        //controllore
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

        return new BreedBean(resultBreedImage, resultBreedName, resultBreedCoatLength, resultBreedPlayfulness, resultBreedProtectiveness, resultBreedEnergy, resultBreedBarking);
    }

    public DogProfileBean getDogById(int dogId){
        Dog dog = DaoFactory.getDaoSingletonFactory().createDogDao().getDogById(dogId);
        String dogIdBean = String.valueOf(dog.getDogId());
        String dogNameBean = dog.getDogName();
        String dogAgeBean = String.valueOf(dog.getDogAge());
        String dogBreedBean = dog.getDogBreed();
        String dogkKennelNameBean = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(dog.getKennelId()).getKennelName();
        String dogKennelIdBean = String.valueOf(dog.getKennelId());

        return new DogProfileBean(dogIdBean, dogNameBean, dogAgeBean, dogBreedBean, dogkKennelNameBean, dogKennelIdBean);
    }

    public void sendDogAdoptionRequest(DogAdoptionRequestBean dogAdoptionRequestBean){
        //int darId = Integer.parseInt(dogAdoptionRequestBean.getDarId());
        String userName = dogAdoptionRequestBean.getUserFirstname();
        String lastName = dogAdoptionRequestBean.getUserLastname();
        String email = dogAdoptionRequestBean.getUserEmail();
        String phone = dogAdoptionRequestBean.getUserPhone();
        int dogId = Integer.parseInt(dogAdoptionRequestBean.getDogId());
        int kennelId = Integer.parseInt(dogAdoptionRequestBean.getKennelId());
        DogAdoptionRequest dogAdoptionRequest = new DogAdoptionRequest(userName, lastName, email, phone, dogId, kennelId);
        DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().add(dogAdoptionRequest);
        //this will be called by view.getDogAdoptionRequestData
    }
}
