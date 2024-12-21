package view.user.dogadoptionrequestview;

import bean.DogProfileBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.user.windowmanager.WindowManager;

public class GUIDogAdoptionRequestController extends DogAdoptionRequestController{
    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        VBox dogAdoptionRequestContainer = new VBox();
        dogAdoptionRequestContainer.setAlignment(Pos.TOP_CENTER);
        Label title = new Label("Dog Adoption Request");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30px");

        GridPane grid = new GridPane();
        String labelTextFormat = "-fx-font-size: 20px;";
        grid.setAlignment(Pos.CENTER);
        grid.setStyle(labelTextFormat);
        grid.setHgap(50);
        grid.setVgap(25);

        Label dogIdLabel = new Label("Dog id:");
        dogIdLabel.setStyle(labelTextFormat);
        Label dogIdValue = new Label(dogProfileBean.getDogId());
        dogIdValue.setStyle(labelTextFormat);
        Label dogNameLabel = new Label("Dog name:");
        dogNameLabel.setStyle(labelTextFormat);
        Label dogNameValue = new Label(dogProfileBean.getDogName());
        dogNameValue.setStyle(labelTextFormat);
        Label dogAgeLabel = new Label("Dog age:");
        dogAgeLabel.setStyle(labelTextFormat);
        Label dogAgeValue = new Label(dogProfileBean.getDogAge()+" anni");
        dogAgeValue.setStyle(labelTextFormat);
        Label dogBreedLabel = new Label("Dog breed:");
        dogBreedLabel.setStyle(labelTextFormat);
        Label dogBreedValue = new Label(dogProfileBean.getDogBreed());
        dogBreedValue.setStyle(labelTextFormat);
        Label dogKennelLabel = new Label("Kennel name:");
        dogKennelLabel.setStyle(labelTextFormat);
        Label dogKennelValue = new Label(dogProfileBean.getKennelName());
        dogKennelValue.setStyle(labelTextFormat);

        TextField userNameField = new TextField();
        userNameField.setPromptText("Inserisci nome");
        TextField userSurnameField = new TextField();
        userSurnameField.setPromptText("Inserisci cognome");
        TextField userEmailField = new TextField();
        userEmailField.setPromptText("Inserisci email");
        TextField userPhoneField = new TextField();
        userPhoneField.setPromptText("Inserisci numero di telefono");

        Button cancelButton = new Button("CANCEL");
        cancelButton.setStyle("-fx-background-color: red; -fx-font-size: 20px; -fx-min-width: 250px");
        cancelButton.setOnAction(actionEvent -> {
            WindowManager.getSingletonInstance().getStarterWindow().showDogs();
        });
        Button sendButton = new Button("SEND");
        sendButton.setStyle("-fx-background-color: #2cc61e; -fx-font-size: 20px; -fx-min-width: 250px");

        grid.add(dogIdLabel, 0, 0);
        grid.add(dogIdValue, 1, 0);
        grid.add(dogNameLabel, 0, 1);
        grid.add(dogNameValue, 1, 1);
        grid.add(dogAgeLabel, 0, 2);
        grid.add(dogAgeValue, 1, 2);
        grid.add(dogBreedLabel, 0, 3);
        grid.add(dogBreedValue, 1, 3);
        grid.add(dogKennelLabel, 0, 4);
        grid.add(dogKennelValue, 1, 4);

        grid.add(userNameField, 0, 5);
        grid.add(userSurnameField, 1, 5);
        grid.add(userEmailField, 0, 6);
        grid.add(userPhoneField, 1, 6);

        grid.add(cancelButton, 0, 7);
        grid.add(sendButton, 1, 7);


        VBox.setMargin(title, new Insets(30, 0, 30, 0));

        dogAdoptionRequestContainer.getChildren().addAll(title, grid);
        WindowManager.getSingletonInstance().getStarterWindow().setCentralView(dogAdoptionRequestContainer);
    }
}
