package view.login;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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
        registerCredentials.add(kennelName.getText());
        registerCredentials.add(username.getText());
        registerCredentials.add(password.getText());
        registerCredentials.add(confirmPassword.getText());
        return registerCredentials;
    }

}
