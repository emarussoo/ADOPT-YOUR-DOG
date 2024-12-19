package view.user.testview;

import bean.BreedBean;
import bean.TestBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presenter.AdoptDogController;
import utils.TestQuestions;
//import view.UserView;
import view.user.factory.GUIFactory;
import view.user.factory.GraphicalFactory;
import view.user.windowmanager.UserWindowManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GUITestViewController extends TestViewController{
    private List<ToggleGroup> toggleList = new ArrayList<>();

    @Override
    public void createTest(){
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
                submitTest();
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

        Pane pane = new Pane(scrollPane);

        UserWindowManager.getSingletonInstance().setCentralView(pane);
        //GUIFactory.getGraphicalSingletonFactory().createUserWindowManager().setCentralView(pane);

    }


    public void submitTest() throws URISyntaxException, IOException, InterruptedException {
        List<String> listOfAnswers = getTestAnswers();
        TestBean testAnswers = new TestBean(listOfAnswers);
        toggleList.clear();

        AdoptDogController presenter = new AdoptDogController();
        BreedBean resultbreed = presenter.processTestAnswers(testAnswers);
        UserWindowManager.getSingletonInstance().showTestResult(resultbreed);

    }
    @Override
    public List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> listOfAnswers = new ArrayList<>();
        for(ToggleGroup a: toggleList){

            RadioButton rb = (RadioButton) a.getSelectedToggle();
            listOfAnswers.add(rb.getText());
        }

        System.out.println(listOfAnswers);
        return listOfAnswers;
    }

    @Override
    public void createTestResult(BreedBean breedBean){
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

        Label protectivenessLabel = new Label("Protectiveness:");
        protectivenessLabel.setStyle(textSetting);
        Label protectivenessValue = new Label(breedBean.getBarking());
        protectivenessValue.setStyle(textSetting);
        infoGrid.add(protectivenessLabel, 0, 5);
        infoGrid.add(protectivenessValue, 1, 5);

        // Aggiunta dell'immagine e del GridPane al VBox
        vbox.getChildren().addAll(imageView, infoGrid);

        UserWindowManager.getSingletonInstance().setCentralView(vbox);
    }
}