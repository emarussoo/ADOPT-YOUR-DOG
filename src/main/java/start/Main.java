package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.user.factory.GraphicalFactory;
import view.user.windowmanager.GUIStarterWindow;
import view.user.windowmanager.StarterWindow;
import view.user.windowmanager.WindowManager;

import java.io.File;
import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) throws IOException {
        //ciao
        Initialize initializer = new Initialize();
        initializer.init();
        WindowManager.getSingletonInstance().show();
    }

    public static void startGui(){
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/user-view.fxml").toURI().toURL());
        fxmlLoader.setController(GUIStarterWindow.getSingletonInstance());
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("ADOPTYOURDOG");
        stage.setScene(scene);
        stage.show();
    }
}

