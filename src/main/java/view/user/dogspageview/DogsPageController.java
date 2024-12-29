package view.user.dogspageview;

import bean.DogProfileBean;
import utils.GraphicalController;

import java.util.List;

public abstract class DogsPageController implements GraphicalController {

    public abstract void createListOfDogs(List<DogProfileBean> listOfDogs);
    public abstract String getInsertedBreed();
    public abstract DogProfileBean getDogInfo();
}
