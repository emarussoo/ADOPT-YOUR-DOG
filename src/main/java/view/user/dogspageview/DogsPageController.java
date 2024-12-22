package view.user.dogspageview;

import bean.DogProfileBean;
import presenter.AdoptDogController;
import view.user.windowmanager.UserWindowManager;

import java.util.List;

public abstract class DogsPageController {
    public void showAllDogs(){
        AdoptDogController presenter = new AdoptDogController();
        List<DogProfileBean> listOfAllDogs = presenter.getAllDogs();
        UserWindowManager.getSingletonInstance().showListOfDogs(listOfAllDogs);
    }

    public abstract void createListOfDogs(List<DogProfileBean> listOfDogs);
    public abstract String getInsertedBreed();

    public abstract DogProfileBean getDogInfo();
}
