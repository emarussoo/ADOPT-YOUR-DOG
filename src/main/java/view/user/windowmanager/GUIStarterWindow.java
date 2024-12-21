package view.user.windowmanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import start.Main;

import javax.swing.text.ComponentView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIStarterWindow extends StarterWindow {

    @FXML
    private BorderPane bp;
    @FXML
    private Button testButton;
    @FXML
    private Button dogsButton;

    static GUIStarterWindow instance = null;

    protected GUIStarterWindow() {

    }

    public static GUIStarterWindow getSingletonInstance() {
        if(instance == null){
            instance = new GUIStarterWindow();
        }
        return instance;
    }


    public void show(){
        System.out.println("gui mode");
        Main.startGui();
    }

    public void showTest(){
        dogsButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        testButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        WindowManager.getSingletonInstance().showTest();
    }


    public void showDogs(){
        testButton.setStyle("-fx-background-color: white; -fx-border-color:  #2cc61e");
        dogsButton.setStyle("-fx-background-color: #d4ffd4; -fx-border-color:  #2cc61e");
        WindowManager.getSingletonInstance().showAllDogs();
        //loadPage("dogs-user-page");
        //it will call presenter.getDogsByBreed with empty params
    }

    public void loadPage(String page){
        Parent root = null;

        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource(page+".fxml"));

        }catch(IOException ex) {
            Logger.getLogger(StarterWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setCenter(root);
    }

    public void setCentralView(Node component) {
        if(this.bp == null){
            throw new IllegalStateException("BorderPane not initialized");
        }
        bp.setCenter(component);
    }
}
