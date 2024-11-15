package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/pages/register.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        stage.setTitle("ADOPTYOURDOG");
        stage.setScene(scene);
        stage.show();
    }
}
