package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import start.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdoptDogGraphicalController {

    @FXML
    private BorderPane bp;
    private Pane p;

    public void showTest(){
        ScrollPane sp = createTestScrollPane();
        bp.setCenter(sp);
    }

    public void getTestAnswers(){
        //it will call presenter.processTestAnswers
    }

    public void getBreedToSearch(){
        //it will call presenter.getDogsByBreed

    }

    public void getAllDogs(){
        loadPage("dogs-user-page");
        //it will call presenter.getDogsByBreed with empty params

    }

    public void showTestResult(){
        //this will be called by presenter to show the breed
    }

    public void showDogs(){
        //this will be called by presenter to show retrieves dogs

    }

    public void showDogAdoptionRequestForm(){
        //this will be used to show DAR form

    }

    public void getDogAdoptionRequestData(){
        //it will call presenter.sendDAR

    }

    public void loadPage(String page){
        Parent root = null;

        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource(page+".fxml"));

        }catch(IOException ex) {
            Logger.getLogger(AdoptDogGraphicalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setCenter(root);
    }

    private ScrollPane createTestScrollPane() {
        // Layout per contenere tutte le domande
        VBox questionContainer = new VBox(30);
        questionContainer.setStyle("-fx-padding: 20px 20px 20px 20px;");

        // Creazione delle domande e risposte
        for (int i = 1; i < TestQuestions.values().length; i++) {
            VBox singleQuestionBox = new VBox(10);

            Label questionLabel = new Label("Domanda " + i + ": "+TestQuestions.values()[i].getTesto());
            questionLabel.setStyle("-fx-font-size: 16px");

            ToggleGroup group = new ToggleGroup();
            RadioButton option1 = new RadioButton("1");
            option1.setToggleGroup(group);
            RadioButton option2 = new RadioButton("2");
            option2.setToggleGroup(group);
            RadioButton option3 = new RadioButton("3");
            option3.setToggleGroup(group);
            RadioButton option4 = new RadioButton("4");
            option4.setToggleGroup(group);
            RadioButton option5 = new RadioButton("5");
            option5.setToggleGroup(group);

            HBox optionsBox = new HBox(10, option1, option2, option3, option4, option5);
            optionsBox.setAlignment(Pos.CENTER);
            optionsBox.setSpacing(20);
            singleQuestionBox.getChildren().addAll(questionLabel, optionsBox);

            questionContainer.getChildren().add(singleQuestionBox);
        }

        // ScrollPane per rendere il contenitore scrollabile
        ScrollPane scrollPane = new ScrollPane(questionContainer);
        scrollPane.setFitToWidth(true);

        // Creazione della scena con il questionario
        return scrollPane;
    }
}




