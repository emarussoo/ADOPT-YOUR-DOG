package view.kennel.managedogadoptionrequestview;
import bean.DogAdoptionRequestBean;
import utils.GraphicalController;
import java.util.List;

public abstract class ManageDarPageController implements GraphicalController {
    public abstract void createDarList(List<DogAdoptionRequestBean> listOfDarsBean);
    public abstract DogAdoptionRequestBean getDarInfo();
}
