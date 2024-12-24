package view.kennel.addadogview;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.kennel.windowmanager.KennelWindowManager;
import view.user.windowmanager.UserWindowManager;

import java.util.ArrayList;
import java.util.List;

public class GUIAddDogPageController extends AddDogPageController {
    private TextField dogNameField = new TextField();
    private TextField dogAgeField = new TextField();
    private TextField dogBreedField = new TextField();

    public void createAddForm(){
        String textFieldStyle = "-fx-font-size: 20px; -fx-max-width: 250px";
        dogNameField.setStyle(textFieldStyle);
        dogAgeField.setStyle(textFieldStyle);
        dogBreedField.setStyle(textFieldStyle);

        Label title = new Label("Add a dog");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30px");

        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);
        dogNameField.setPromptText("Nome del cane");
        dogAgeField.setPromptText("Età del cane");
        dogBreedField.setPromptText("Razza del cane");

        Button addButton = new Button();
        addButton.setText("AGGIUNGI");
        addButton.setStyle("-fx-background-color: #2cc61e; -fx-font-size: 20px; -fx-min-width: 250px");
        addButton.setOnAction(actionEvent -> {
            KennelWindowManager.getSingletonInstance().submitAdd();
        });

        vbox.getChildren().addAll(title, dogNameField,dogAgeField,dogBreedField, addButton);

        KennelWindowManager.getSingletonInstance().getKennelMenuController().setCentralView(vbox);
    }

    public List<String> getDogInfo(){
        List<String> dogInfo = new ArrayList<>();
        dogInfo.add(dogNameField.getText());
        dogInfo.add(dogAgeField.getText());
        dogInfo.add(dogBreedField.getText());
        return dogInfo;
    }

    public void createMessage(String message){
        VBox messageContainer = new VBox();
        messageContainer.setSpacing(30);
        messageContainer.setAlignment(Pos.CENTER);
        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 30px");

        Button okButton = new Button("OK");
        okButton.setStyle("-fx-background-color:  #2cc61e; -fx-font-size: 16px;");
        okButton.setOnAction(actionEvent -> {
            KennelWindowManager.getSingletonInstance().getKennelMenuController().addDog();
        });

        messageContainer.getChildren().addAll(messageLabel, okButton);
        KennelWindowManager.getSingletonInstance().getKennelMenuController().setCentralView(messageContainer);
    }
}
