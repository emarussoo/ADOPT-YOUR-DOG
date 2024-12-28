package view.login;

import bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.daofactory.DaoFactory;
import model.kennel.Kennel;
import model.login.KennelUser;
import presenter.LogInController;
import view.GraphicalController;
import view.StageHandler;
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
    private RegisterViewController registerViewController = GraphicalFactory.getGraphicalSingletonFactory().createRegisterPageController();
    private LogInController logInController = new LogInController();

    private static LoginManager instance = null;

    protected LoginManager() {

    }

    public static LoginManager getSingletonInstance(){
        if(instance == null){
            instance = new LoginManager();
        }
        return instance;
    }

    public void authenticate() {
        boolean auth = false;
        List<String> credentials = loginViewController.getLoginCredentials();
        LoginBean loginBean = new LoginBean(credentials.get(0), credentials.get(1));
        auth = logInController.auth(loginBean);
        if(auth){
            kennelWindowManager.show();
        }else{
            loginViewController.showErrorMessage("Errore");
        }
    }

    public void register(){
        List<String> credentials = registerViewController.getRegisterCredentials();
        //controllo pw
        String kennelName = credentials.get(0);
        Kennel kennel = new Kennel(kennelName);

        String username = credentials.get(1);
        String password = credentials.get(2);
        /////////////
        KennelUser newUser = new KennelUser(username, password);
        logInController.ultimateRegistration(kennel, newUser);
        System.out.println("Utente registrato");
        try {
            StageHandler.getSingletonInstance().loadPage(loginViewController, "/login.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logout(){
        loginViewController.backToUserPage();
    }

    public RegisterViewController getRegisterViewController() {
        return registerViewController;
    }
}
