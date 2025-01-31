package view.user.windowmanager;


import javafx.scene.Node;
import utils.GraphicalController;


public abstract class UserMenuController implements GraphicalController {
    public abstract void show();
    public abstract void showTest();
    public abstract void showDogs();
    public abstract void login();
    public void setCentralView(Node component){
    }
}
