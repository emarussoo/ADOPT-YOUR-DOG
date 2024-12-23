package view.user.windowmanager;


import javafx.scene.Node;
import view.GraphicalController;


public abstract class UserMenuController implements GraphicalController {
    public abstract void show();
    public abstract void showTest();
    public abstract void showDogs();
    public abstract void login();

    //private static UserMenuController instance;

    /*public UserMenuController() {
        // Inizializzazione se necessaria
    }


    /*public static UserMenuController getSingletonInstance() {
        if (instance == null) {
            GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
            instance = factory.createUserMenuController(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }*/

    public void setCentralView(Node component){

    }
}
