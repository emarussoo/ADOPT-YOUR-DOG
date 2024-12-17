package view;

import bean.TestBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presenter.AdoptDogPresenter;
import utils.TestQuestions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserView {

    private List<ToggleGroup> toggleList = new ArrayList<>();

    @FXML
    private BorderPane bp;
    private Pane p;

    public void showTest(){
        ScrollPane sp = createTestScrollPane();
        bp.setCenter(sp);
    }

    public void getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> listOfAnswers = new ArrayList<>();
        for(ToggleGroup a: toggleList){

            RadioButton rb = (RadioButton) a.getSelectedToggle();
            listOfAnswers.add(rb.getText());
        }
        TestBean testAnswers = new TestBean(listOfAnswers);
        toggleList.clear();

        System.out.println(testAnswers.getUserAnswers());
        AdoptDogPresenter presenter = new AdoptDogPresenter(this);
        presenter.processTestAnswers(testAnswers);
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
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setCenter(root);
    }

    private ScrollPane createTestScrollPane() {
        // Layout per contenere tutte le domande
        VBox questionContainer = new VBox(30);
        questionContainer.setStyle("-fx-padding: 20px 20px 20px 20px;");
        questionContainer.setAlignment(Pos.CENTER);

        // Creazione delle domande e risposte
        for (int i = 0; i < TestQuestions.values().length; i++) {
            VBox singleQuestionBox = new VBox(10);

            Label questionLabel = new Label("Domanda " + i + ": "+TestQuestions.values()[i].getTesto());
            questionLabel.setStyle("-fx-font-size: 16px");

            ToggleGroup group = new ToggleGroup();
            toggleList.add(group);
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

        Button submitButton = new Button("SUBMIT");
        submitButton.setStyle("-fx-min-height: 40px; -fx-min-width: 400px; -fx-background-color:  #2cc61e; -fx-font-size: 20px;");
        submitButton.setOnAction(actionEvent -> {
            try {
                getTestAnswers();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        questionContainer.getChildren().add(submitButton);

        // ScrollPane per rendere il contenitore scrollabile
        ScrollPane scrollPane = new ScrollPane(questionContainer);
        scrollPane.setFitToWidth(true);

        // Creazione della scena con il questionario
        return scrollPane;
    }
}




