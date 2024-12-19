package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.user.factory.GraphicalChoice;
import view.user.factory.GraphicalFactory;
import view.user.windowmanager.UserWindowManager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class Main extends Application {

    public static void main(String[] args) throws IOException {
        Initialize initializer = new Initialize();
        initializer.init();
        GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
        factory.createUserWindowManager().show();
    }

    public static void startGui(){
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //ciao
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/resources/user-view.fxml").toURI().toURL());
        GraphicalFactory graphicalFactory = GraphicalFactory.getGraphicalSingletonFactory();
        UserWindowManager controller = graphicalFactory.createUserWindowManager().getSingletonInstance();
        if(controller == null){
            System.out.println("nullo");
        }
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("ADOPTYOURDOG");
        stage.setScene(scene);
        stage.show();
    }
}

