package view.login;

import exceptions.EmptyFieldsException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import utils.StageHandler;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserMenuController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUILoginViewController extends LoginViewController{
    private static GUILoginViewController instance = null;
    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    Text errorMessageField;
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
        errorMessageField.setText("");
        LoginManager.getSingletonInstance().authenticate();
    }


    @Override
    public List<String> getLoginCredentials() throws EmptyFieldsException {
        List<String> credentials = new ArrayList<>();
        String insertedUsername = this.username.getText();
        String insertedPassword = this.password.getText();
        if(insertedUsername.isEmpty() || insertedPassword.isEmpty()){
            throw new EmptyFieldsException("Assicurati di aver riempito tutti i campi");
        }
        credentials.add(insertedUsername);
        credentials.add(insertedPassword);
        return credentials;
    }

    @FXML
    public void goToRegister(){
        GUIRegisterViewController controller = GUIRegisterViewController.getInstance();
        try {
            StageHandler.getSingletonInstance().loadPage(controller, "/register.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showErrorMessage(String message){
        errorMessageField.setText(message);
    }

}
