package view.kennel.windowmanager;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import utils.StageHandler;
import view.login.LoginManager;

import java.io.IOException;

public class GUIKennelMenuController extends KennelMenuController{
    @FXML
    Button addDogButton;

    @FXML
    Button darButton;

    @FXML
    Button myDogsButton;

    @FXML
    BorderPane bp;

    private String unselectedButtonStyle = "-fx-background-color: white; -fx-border-color:  #2cc61e";
    private String selectedButtonStyle = "-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e";

    private static GUIKennelMenuController instance = null;

    private GUIKennelMenuController() {}
    public void show() {

        try {
            StageHandler.getSingletonInstance().loadPage(GUIKennelMenuController.getSingletonInstance(), "/kennel-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    @Override
    public void addDog() {
        darButton.setStyle(unselectedButtonStyle);
        myDogsButton.setStyle(unselectedButtonStyle);
        addDogButton.setStyle(selectedButtonStyle);
        KennelWindowManager.getSingletonInstance().showAddDog();
    }


    @FXML
    public void showDogAdoptionRequest(){
        addDogButton.setStyle(unselectedButtonStyle);
        myDogsButton.setStyle(unselectedButtonStyle);
        darButton.setStyle(selectedButtonStyle);
        KennelWindowManager.getSingletonInstance().showMyDars();
    }

    @FXML
    public void showMyDogs(){
        addDogButton.setStyle(unselectedButtonStyle);
        darButton.setStyle(unselectedButtonStyle);
        myDogsButton.setStyle(selectedButtonStyle);
        KennelWindowManager.getSingletonInstance().showMyDogs();
    }

    @FXML
    public void logout(){
        LoginManager.getSingletonInstance().logout();
    }

    public void setCentralView(Node component) {
        if(bp == null){
            throw new IllegalStateException("BorderPane not initialized");
        }
        bp.setCenter(component);
    }

    public static GUIKennelMenuController getSingletonInstance() {
        if (instance == null) {
            instance = new GUIKennelMenuController();
        }
        return instance;
    }
}
