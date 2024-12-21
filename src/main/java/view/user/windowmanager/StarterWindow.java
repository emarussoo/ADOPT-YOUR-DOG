package view.user.windowmanager;


import javafx.scene.Node;
import view.user.factory.GraphicalFactory;


public abstract class StarterWindow {
    public abstract void show();
    public abstract void showTest();
    public abstract void showDogs();

    private static StarterWindow instance;

    protected StarterWindow() {
        // Inizializzazione se necessaria
    }


    public static StarterWindow getSingletonInstance() {
        if (instance == null) {
            GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
            instance = factory.createStarterWindow(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }

    public void setCentralView(Node component){

    }
}
