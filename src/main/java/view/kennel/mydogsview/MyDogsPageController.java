package view.kennel.mydogsview;

import bean.DogProfileBean;
import view.GraphicalController;

import java.util.List;

public abstract class MyDogsPageController implements GraphicalController {
    public void createMyDogsList(List<DogProfileBean> listOfDogsBean) {}
}
