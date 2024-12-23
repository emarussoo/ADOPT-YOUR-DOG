package view.user.windowmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jdk.jfr.Event;
import start.Main;
import view.login.GUILoginViewController;
import view.login.LoginManager;
import view.login.LoginViewController;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIUserMenuController extends UserMenuController {

    @FXML
    private BorderPane bp;
    @FXML
    private Button testButton;
    @FXML
    private Button dogsButton;

    static GUIUserMenuController instance = null;

    protected GUIUserMenuController() {

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
    public void Login(ActionEvent event) throws IOException {
        LoginViewController loginViewController = GUILoginViewController.getSingletonInstance();
        LoginManager.getSingletonInstance().loadPage(event, loginViewController, "src/main/resources/login.fxml");
    }
}
