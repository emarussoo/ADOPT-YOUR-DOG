package view.login;

import bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenter.LogInController;
import view.GraphicalController;
import view.factory.GraphicalFactory;
import view.kennel.windowmanager.KennelWindowManager;
import view.user.windowmanager.UserWindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginManager {
    private UserWindowManager userWindowManager = UserWindowManager.getSingletonInstance();
    private KennelWindowManager kennelWindowManager = KennelWindowManager.getSingletonInstance();
    private LoginViewController loginViewController = GraphicalFactory.getGraphicalSingletonFactory().createLoginPageController();
    private LogInController logInController = new LogInController();

    private static LoginManager instance = null;

    public static LoginManager getSingletonInstance(){
        if(instance == null){
            instance = new LoginManager();
        }
        return instance;
    }

    public void authenticate() {
        boolean auth = false;
        List<String> credentials = loginViewController.getCredentials();
        LoginBean loginBean = new LoginBean(credentials.get(0), credentials.get(1));
        auth = logInController.auth(loginBean);
        if(auth){
            kennelWindowManager.setKennelId(96);
            kennelWindowManager.show();
        }else{
            loginViewController.showErrorMessage("Errore");
        }
    }

    public void logout(){
        loginViewController.backToUserPage();
    }
}
