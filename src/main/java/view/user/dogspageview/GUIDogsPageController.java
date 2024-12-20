package view.user.dogspageview;

import bean.DogProfileBean;
import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import presenter.AdoptDogController;
import view.user.factory.GUIFactory;
import view.user.windowmanager.WindowManager;


import java.util.Collection;
import java.util.List;


public class GUIDogsPageController extends DogsPageController{

    private TextField breedSearchField = new TextField();

    public void createListOfDogs(List<DogProfileBean> listOfDogs) {
        System.out.println("creando la lista");

        HBox searchBar = new HBox(10);
        breedSearchField.setPromptText("Inserisci la razza");
        breedSearchField.setStyle("-fx-min-height: 38px; -fx-font-size: 16px;");
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color:  #2cc61e; -fx-font-size: 16px;");
        searchButton.setOnAction(event -> {
            submitSearch(listOfDogs);
        });


        searchBar.getChildren().addAll(breedSearchField, searchButton);
        HBox.setHgrow(breedSearchField, Priority.ALWAYS);

        ListView listView = new ListView<>();
        listView.setStyle("-fx-alignment: center; -fx-font-size: 15px");


        VBox dogContainer = new VBox(10);
        dogContainer.setSpacing(10);
        dogContainer.setStyle("-fx-padding: 30px");
        dogContainer.setAlignment(Pos.TOP_CENTER);


        for (DogProfileBean dog : listOfDogs) {
            HBox dogBox = new HBox(15);
            Text idField = new Text(dog.getDogId());
            Text nameField = new Text(dog.getDogName());
            Text ageField = new Text(dog.getDogAge());
            Text breedField = new Text(dog.getDogBreed());// Spaziatura di 15px tra i dettagli

            listView.getItems().add(idField.getText() + "       " + nameField.getText() + "       " + ageField.getText() + "       " + breedField.getText());
        }

        dogContainer.getChildren().addAll(searchBar, listView);
        GUIFactory.getGraphicalSingletonFactory().createStarterWindow().setCentralView(dogContainer);
    }

    public void submitSearch(List<DogProfileBean> listOfDogs){
        WindowManager.getSingletonInstance().submitSearch(listOfDogs);
    }

    public String getInsertedBreed(){
        return breedSearchField.getText();
    }
}
