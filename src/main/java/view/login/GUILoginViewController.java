package view.login;

import bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presenter.LogInController;
import view.StageHandler;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserMenuController;
import view.user.windowmanager.UserWindowManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUILoginViewController extends LoginViewController{
    private static GUILoginViewController instance = null;
    @FXML
    TextField username;
    @FXML
    TextField password;

    private GUILoginViewController() {
        //costruttore

    }

    public static GUILoginViewController getSingletonInstance(){
        if(instance == null){
            instance = new GUILoginViewController();
        }
        return instance;
    }

    @FXML
    public void backToUserPage(){
        UserMenuController controller = GUIUserMenuController.getSingletonInstance();
        try {
            StageHandler.getSingletonInstance().loadPage(controller, "/user-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void authentication(){
        LoginManager.getSingletonInstance().authenticate();
    }


    @Override
    public List<String> getCredentials(){
        List<String> credentials = new ArrayList<>();
        String insertedUsername = this.username.getText();
        String insertedPassword = this.password.getText();
        credentials.add(insertedUsername);
        credentials.add(insertedPassword);
        return credentials;
    }

    public void showErrorMessage(String message){
        //ci dovrà essere l'errore
    }
}
