package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.StageHandler;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserWindowManager;

import java.io.File;


public class Main extends Application {

    public static void main(String[] args){
        Initialize initializer = new Initialize();
        initializer.init();
        UserWindowManager.getSingletonInstance().show();
    }

    public static void startGui(){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageHandler.getSingletonInstance().setStage(stage);
        StageHandler.getSingletonInstance().loadPage(GUIUserMenuController.getSingletonInstance(), "/user-view.fxml");
    }
}

