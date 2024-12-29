package view.user.windowmanager;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import start.Main;
import utils.StageHandler;
import view.login.GUILoginViewController;
import view.login.LoginViewController;


import java.io.IOException;

public class GUIUserMenuController extends UserMenuController {

    @FXML
    private BorderPane bp;
    @FXML
    private Button testButton;
    @FXML
    private Button dogsButton;

    static GUIUserMenuController instance = null;

    private GUIUserMenuController() {
        //costruttore
    }

    public static GUIUserMenuController getSingletonInstance() {
        if(instance == null){
            instance = new GUIUserMenuController();
        }
        return instance;
    }


    public void show(){
        Main.startGui();
    }


    public void showTest(){
        dogsButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        testButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        UserWindowManager.getSingletonInstance().showTest();
    }


    public void showDogs(){
        testButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        dogsButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        UserWindowManager.getSingletonInstance().showAllDogs();
        //it will call presenter.getDogsByBreed with empty params
    }

    public void setCentralView(Node component) {
        if(bp == null){
            throw new IllegalStateException("BorderPane not initialized");
        }
        bp.setCenter(component);
    }

    @FXML
    public void login(){
        LoginViewController loginViewController = GUILoginViewController.getSingletonInstance();
        try {
            StageHandler.getSingletonInstance().loadPage(loginViewController, "/login.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
