package view.user.windowmanager;


import javafx.scene.Node;
import view.user.factory.GraphicalFactory;


public abstract class UserMenuController {
    public abstract void show();
    public abstract void showTest();
    public abstract void showDogs();

    private static UserMenuController instance;

    protected UserMenuController() {
        // Inizializzazione se necessaria
    }


    public static UserMenuController getSingletonInstance() {
        if (instance == null) {
            GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
            instance = factory.createUserMenuController(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }

    public void setCentralView(Node component){

    }
}
