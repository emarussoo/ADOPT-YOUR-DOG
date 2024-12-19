package view.user.windowmanager;

import bean.BreedBean;
import javafx.scene.layout.Pane;
import view.user.factory.GraphicalFactory;

public abstract class UserWindowManager {
    public abstract void showTest();
    public abstract void getBreedToSearch();
    public abstract void getAllDogs();
    public abstract void showTestResult(BreedBean breedBean);
    public abstract void setCentralView(Pane centralView);

    private static UserWindowManager instance;

    protected UserWindowManager() {
        // Inizializzazione se necessaria
    }
    //////????rivedi///////
    public static UserWindowManager getSingletonInstance() {
        if (instance == null) {
            GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
            instance = factory.createUserWindowManager(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }
}
