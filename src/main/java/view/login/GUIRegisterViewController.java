package view.login;

import exceptions.EmptyFieldsException;
import exceptions.PasswordConfirmationException;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.kennel.windowmanager.KennelWindowManager;

import java.util.ArrayList;
import java.util.List;

public class GUIRegisterViewController extends RegisterViewController {

    @FXML
    TextField kennelName;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField confirmPassword;
    @FXML
    Text errorMessageField;

    private static GUIRegisterViewController instance = null;
    private GUIRegisterViewController() {}

    public static GUIRegisterViewController getInstance() {
        if(instance == null){
            instance = new GUIRegisterViewController();
        }
        return instance;
    }

    public void register(){
        LoginManager.getSingletonInstance().register();
    }

    public List<String> getRegisterCredentials(){
        List<String> registerCredentials = new ArrayList<>();
        if(!confirmPassword.getText().equals(password.getText())){
            throw new PasswordConfirmationException("The fields password and confirm password do not match");
        }
        if(kennelName.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() || confirmPassword.getText().isEmpty()){
            throw new EmptyFieldsException("One or more fields are empty");
        }
        registerCredentials.add(kennelName.getText());
        registerCredentials.add(username.getText());
        registerCredentials.add(password.getText());
        registerCredentials.add(confirmPassword.getText());
        return registerCredentials;
    }

    public void backToUserPage(){
        GUILoginViewController.getSingletonInstance().backToUserPage();
    }

    public void showErrorMessage(String message){
        errorMessageField.setText(message);
    }

}
