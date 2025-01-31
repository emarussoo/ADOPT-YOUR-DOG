package view.kennel.windowmanager;

import javafx.scene.Node;
import utils.GraphicalController;

public abstract class KennelMenuController implements GraphicalController {
    public abstract void show();
    public void setCentralView(Node component){}
    public abstract void addDog();
    public abstract void showDogAdoptionRequest();
    public abstract void showMyDogs();
    public abstract void logout();
}
