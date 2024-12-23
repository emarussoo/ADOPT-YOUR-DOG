package view.user.dogspageview;

import bean.DogProfileBean;
import presenter.AdoptDogController;
import start.GraphicalController;
import view.user.windowmanager.UserWindowManager;

import java.util.List;

public abstract class DogsPageController extends GraphicalController {

    public abstract void createListOfDogs(List<DogProfileBean> listOfDogs);
    public abstract String getInsertedBreed();
    public abstract DogProfileBean getDogInfo();
}
