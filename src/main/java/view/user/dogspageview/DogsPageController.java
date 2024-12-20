package view.user.dogspageview;

import bean.DogProfileBean;

import java.util.List;

public abstract class DogsPageController {
    public abstract void getAllDogs();

    public abstract void createListOfDogs(List<DogProfileBean> listOfDogs);
}
