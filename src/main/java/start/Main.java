package start;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.StageHandler;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserWindowManager;


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
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/logo.png")));
        StageHandler.getSingletonInstance().setStage(stage);
        StageHandler.getSingletonInstance().loadPage(GUIUserMenuController.getSingletonInstance(), "/user-view.fxml");
    }
}

