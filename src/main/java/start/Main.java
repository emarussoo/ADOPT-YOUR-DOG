package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import view.StageHandler;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserWindowManager;

import java.io.File;


public class Main extends Application {

    public static void main(String[] args){
        Initialize initializer = new Initialize();
        initializer.init();
        //System.out.println(DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(1).getKennelName());
        UserWindowManager.getSingletonInstance().show();
        //System.out.println(DaoFactory.getDaoSingletonFactory().createDogDao().getDogById(4).getDogName());

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

