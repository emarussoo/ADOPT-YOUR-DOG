package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StageHandler {
    private static StageHandler instance;
    private Stage stage;

    protected StageHandler(){}

    public static StageHandler getSingletonInstance(){
        if(instance == null){
            instance = new StageHandler();
        }
        return instance;
    }

    public void loadPage(GraphicalController graphicalController, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        fxmlLoader.setController(graphicalController);
        Scene scene = new Scene(fxmlLoader.load(), 925, 745);
        Stage currentStage = this.stage;
        currentStage.resizableProperty().setValue(Boolean.FALSE);
        currentStage.setTitle("LOGIN");
        currentStage.setScene(scene);
        currentStage.show();
    }

    public Stage getStage(){
        return stage;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

}
