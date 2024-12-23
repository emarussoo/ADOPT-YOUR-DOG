package view.kennel.windowmanager;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import view.StageHandler;
import view.login.LoginManager;
import view.user.windowmanager.UserWindowManager;

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
    public void addDog() {
        darButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        myDogsButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        addDogButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        KennelWindowManager.getSingletonInstance().showAddDog();
    }


    @FXML
    public void showDogAdoptionRequest(){
        addDogButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        myDogsButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        darButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        KennelWindowManager.getSingletonInstance().showMyDars();
    }

    @FXML
    public void showMyDogs(){
        addDogButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        darButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        myDogsButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
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
