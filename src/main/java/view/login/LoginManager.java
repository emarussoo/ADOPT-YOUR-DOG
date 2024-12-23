package view.login;

import bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presenter.LogInController;
import start.GraphicalController;
import view.factory.GraphicalFactory;
import view.user.windowmanager.UserWindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginManager {
    private UserWindowManager userWindowManager = UserWindowManager.getSingletonInstance();
    private LoginViewController loginViewController = GraphicalFactory.getGraphicalSingletonFactory().createLoginPageController();
    private LogInController logInController = new LogInController();

    private static LoginManager instance = null;

    public static LoginManager getSingletonInstance(){
        if(instance == null){
            instance = new LoginManager();
        }
        return instance;
    }

    public void backToUserPage(){
        loginViewController.backToUserPage();
    }
    public void authenticate() {
        boolean auth = false;
        List<String> credentials = loginViewController.getCredentials();
        LoginBean loginBean = new LoginBean(credentials.get(0), credentials.get(1));
        auth = logInController.auth(loginBean);
        if(auth){
            loginViewController.showKennelPage();
            //System.out.println("Authentication successful");
        }
    }


    public void loadPage(ActionEvent event, GraphicalController graphicalController, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File(path).toURI().toURL());
        fxmlLoader.setController(graphicalController);
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }
}
