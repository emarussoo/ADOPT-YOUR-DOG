package view.kennel.addadogview;
import view.GraphicalController;

import java.util.List;

public abstract class AddDogPageController implements GraphicalController {
    public abstract void createAddForm();
    public abstract List<String> getDogInfo();
    public abstract void createMessage(String message);
}
