package view.user.windowmanager;

import bean.BreedBean;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import view.user.factory.GraphicalFactory;

import javax.swing.text.ComponentView;

public abstract class StarterWindow {
    public abstract void show();
    public abstract void showTest();
    //public abstract void getBreedToSearch();
    public abstract void showDogs();
    //public abstract void showTestResult(BreedBean breedBean);
    //public abstract void loadPage(String string, BorderPane bp);

    private static StarterWindow instance;

    protected StarterWindow() {
        // Inizializzazione se necessaria
    }
    //////????rivedi///////
    public static StarterWindow getSingletonInstance() {
        if (instance == null) {
            GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
            instance = factory.createStarterWindow(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }

    public void setCentralView(Node component){

    };
}
