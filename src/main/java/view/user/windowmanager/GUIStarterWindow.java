package view.user.windowmanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import start.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIStarterWindow extends StarterWindow {

    @FXML
    private BorderPane bp;

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
        WindowManager.getSingletonInstance().showTest();
    }

    public void submitTest(){
        WindowManager.getSingletonInstance().submitTest();
    }

    public void getAllDogs(){
        WindowManager.getSingletonInstance().getAllDogs();
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

    public void setCentralView(Pane centralView) {
        if(this.bp == null){
            throw new IllegalStateException("BorderPane not initialized");
        }
        bp.setCenter(centralView);
    }
}
