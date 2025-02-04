package utils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//this class is used to manage the javafx stage and to switch between pages
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

    //it loads the page with the path specified and sets the graphical controller
    public void loadPage(GraphicalController graphicalController, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        fxmlLoader.setController(graphicalController);
        Scene scene = new Scene(fxmlLoader.load(), 1000, 745);
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
