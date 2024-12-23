package view.kennel.managedogadoptionrequestview;

import bean.DogAdoptionRequestBean;
import view.GraphicalController;

import java.util.List;

public abstract class ManageDarPageController implements GraphicalController {
    public abstract void createDarList(List<DogAdoptionRequestBean> listOfDarsBean);
    public abstract DogAdoptionRequestBean getDarInfo();
    //public abstract void acceptDar();
    //public abstract void rejectDar();
   // public abstract void removeDarFromList(List<DogAdoptionRequestBean> listOfDarsBean, int toRemoveDarIndex);
    //public abstract int getToRemoveDarIndex();
}
