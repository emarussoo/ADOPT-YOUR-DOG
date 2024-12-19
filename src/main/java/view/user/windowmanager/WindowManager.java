package view.user.windowmanager;

import bean.BreedBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import view.user.dogspageview.DogsPageController;
import view.user.factory.GraphicalFactory;
import view.user.testview.TestViewController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowManager {
    private final TestViewController testView = GraphicalFactory.getGraphicalSingletonFactory().createTestViewController();
    private final DogsPageController dogsPage = GraphicalFactory.getGraphicalSingletonFactory().createDogsPageController();
    private final StarterWindow starterWindow = GraphicalFactory.getGraphicalSingletonFactory().createStarterWindow();


    private static WindowManager instance = null;

    protected WindowManager() {
        // Inizializzazione se necessaria
    }

    public void show(){
        starterWindow.show();
    };
    public void showTest(){
        testView.createTest();
    };

    public void submitTest(){
        try {
            testView.submitTest();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTestResult(BreedBean breedBean){
        testView.createTestResult(breedBean);
    };

    public void getBreedToSearch(){

    };

    public void getAllDogs(){
        //it will call presenter.getDogsByBreed with empty params
    }
    //public void setCentralView(Pane centralView){};

    //////????rivedi///////

    public TestViewController getTestView() {
        return testView;
    }

    public DogsPageController getDogsPage() {
        return dogsPage;
    }

    public StarterWindow getStarterWindow() {
        return starterWindow;
    }

    public static WindowManager getSingletonInstance() {
        if (instance == null) {
            instance = new WindowManager(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }
}