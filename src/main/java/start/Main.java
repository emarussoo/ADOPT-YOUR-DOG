package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserWindowManager;

import java.io.File;


public class Main extends Application {
    //a
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
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/user-view.fxml").toURI().toURL());
        fxmlLoader.setController(GUIUserMenuController.getSingletonInstance());
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("ADOPTYOURDOG");
        stage.setScene(scene);
        stage.show();
    }
}

