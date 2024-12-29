package view.kennel.addadogview;
import exceptions.EmptyFieldsException;
import utils.GraphicalController;

import java.util.List;

public abstract class AddDogPageController implements GraphicalController {
    public abstract void createAddForm();
    public abstract List<String> getDogInfo() throws EmptyFieldsException;
    public abstract void createMessage(String message);
}
