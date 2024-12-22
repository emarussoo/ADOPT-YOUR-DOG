package view.user.dogspageview;

import bean.DogProfileBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.windowmanager.WindowManager;
import java.util.List;


public class GUIDogsPageController extends DogsPageController{

    private TextField breedSearchField = new TextField();
    ListView listView = new ListView<>();

    public void createListOfDogs(List<DogProfileBean> listOfDogs) {

        HBox searchBar = new HBox(10);
        breedSearchField.setPromptText("Inserisci la razza");
        breedSearchField.setStyle("-fx-min-height: 38px; -fx-font-size: 16px;");
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color:  #2cc61e; -fx-font-size: 16px;");
        searchButton.setOnAction(event -> {
            WindowManager.getSingletonInstance().submitSearch(listOfDogs);
        });


        searchBar.getChildren().addAll(breedSearchField, searchButton);
        HBox.setHgrow(breedSearchField, Priority.ALWAYS);

        GridPane header = new GridPane();
        header.setHgap(110); // Spaziatura orizzontale tra le colonne
        header.add(new Label(" ID"), 0, 0);
        header.add(new Label("Name"), 1, 0);
        header.add(new Label("Age"), 2, 0);
        header.add(new Label("Breed"), 3, 0);
        header.add(new Label("Kennel"), 4, 0);
        header.setStyle("-fx-font-weight: bold; -fx-padding: 5px;");
        listView.setStyle("-fx-alignment: center; -fx-font-size: 15px");


        VBox dogContainer = new VBox(10);
        dogContainer.setSpacing(30);
        dogContainer.setStyle("-fx-padding: 30px");
        dogContainer.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(header, new Insets(0, 0, -15, 0)); // Ridotto il margine inferiore per l'header
        VBox.setMargin(listView, new Insets(-15, 0, 0, 0));

        listView.getItems().clear();
        listView.getItems().addAll(listOfDogs);

        Button createDogAdoptionRequest = new Button("SUBMIT");
        createDogAdoptionRequest.setStyle("-fx-min-height: 40px; -fx-min-width: 400px; -fx-background-color:  #2cc61e; -fx-font-size: 20px;");
        createDogAdoptionRequest.setOnAction(actionEvent -> {
            WindowManager.getSingletonInstance().showDogAdoptionRequestForm();
        });

        dogContainer.getChildren().addAll(searchBar, header, listView, createDogAdoptionRequest);
        WindowManager.getSingletonInstance().getStarterWindow().setCentralView(dogContainer);
    }

    public String getInsertedBreed(){
        return breedSearchField.getText();
    }

    public DogProfileBean getDogInfo(){
        return (DogProfileBean) listView.getSelectionModel().getSelectedItem();
    }
}
