package view;

import bean.BreedBean;
import bean.TestBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import presenter.AdoptDogPresenter;
import utils.TestQuestions;

import java.awt.*;
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

        System.out.println(listOfAnswers);
        TestBean testAnswers = new TestBean(listOfAnswers);
        toggleList.clear();

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

    public void showTestResult(BreedBean breedBean){
        //this will be called by presenter to show the breed
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        // Immagine della razza del cane
        ImageView imageView = new ImageView(new Image(breedBean.getImageLink()));
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        // GridPane per mostrare le informazioni
        GridPane infoGrid = new GridPane();
        infoGrid.setAlignment(Pos.CENTER);
        infoGrid.setHgap(20);
        infoGrid.setVgap(20);

        String textSetting = "-fx-font-size: 20px";


        Label breedNameLabel = new Label("Name:");
        breedNameLabel.setStyle(textSetting);
        Label breedNameValue = new Label(breedBean.getName());
        breedNameValue.setStyle(textSetting);// Imposta il font e la dimensione
        infoGrid.add(breedNameLabel, 0, 0);
        infoGrid.add(breedNameValue, 1, 0);

        Label coatLengthLabel = new Label("Coat length:");
        coatLengthLabel.setStyle(textSetting);
        Label coatLengthValue = new Label(breedBean.getCoatLength());
        coatLengthValue.setStyle(textSetting);
        infoGrid.add(coatLengthLabel, 0, 1);
        infoGrid.add(coatLengthValue, 1, 1);

        Label playfulnessLabel = new Label("Playfulness:");
        playfulnessLabel.setStyle(textSetting);
        Label playfulnessValue = new Label(breedBean.getPlayfulness());
        playfulnessValue.setStyle(textSetting);
        infoGrid.add(playfulnessLabel, 0, 2);
        infoGrid.add(playfulnessValue, 1, 2);

        Label energyLabel = new Label("Energy:");
        energyLabel.setStyle(textSetting);
        Label energyValue = new Label(breedBean.getEnergy());
        energyValue.setStyle(textSetting);
        infoGrid.add(energyLabel, 0, 3);
        infoGrid.add(energyValue, 1, 3);

        Label barkingLabel = new Label("Barking:");
        barkingLabel.setStyle(textSetting);
        Label barkingValue = new Label(breedBean.getBarking());
        barkingValue.setStyle(textSetting);
        infoGrid.add(barkingLabel, 0, 4);
        infoGrid.add(barkingValue, 1, 4);

        Label heightLabel = new Label("Altezza Massima:");
        heightLabel.setStyle(textSetting);
        Label heightValue = new Label(breedBean.getMaxHeightMale());
        heightValue.setStyle(textSetting);
        infoGrid.add(heightLabel, 0, 5);
        infoGrid.add(heightValue, 1, 5);

        // Aggiunta dell'immagine e del GridPane al VBox
        vbox.getChildren().addAll(imageView, infoGrid);

        bp.setCenter(vbox);
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




