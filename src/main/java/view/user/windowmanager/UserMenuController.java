package view.user.windowmanager;


import javafx.scene.Node;
import start.GraphicalController;
import view.kennel.windowmanager.KennelMenuController;


public abstract class UserMenuController extends GraphicalController {
    public abstract void show();
    public abstract void showTest();
    public abstract void showDogs();

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
