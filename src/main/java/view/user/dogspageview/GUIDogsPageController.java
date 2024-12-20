package view.user.dogspageview;

import bean.DogProfileBean;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import presenter.AdoptDogController;
import view.user.factory.GUIFactory;
import view.user.windowmanager.WindowManager;


import java.awt.*;
import java.util.List;

public class GUIDogsPageController extends DogsPageController{
    public void getAllDogs() {
        AdoptDogController presenter = new AdoptDogController();
        List<DogProfileBean> listOfAllDogs = presenter.getDogsByBreed("");
        WindowManager.getSingletonInstance().showListOfDogs(listOfAllDogs);
    }

    public void createListOfDogs(List<DogProfileBean> listOfDogs) {

        /*VBox dogContainer = new VBox(10);
        for (DogProfileBean dog : listOfDogs) {
            HBox dogBox = new HBox(15);             // Spaziatura di 15px tra i dettagli
            Label idLabel = new Label(dog.getDogId());
            Label nameLabel = new Label(dog.getDogName());
            Label ageLabel = new Label(dog.getDogAge());
            Label breedLabel = new Label(dog.getDogBreed());

            // Aggiungi i dettagli del cane all'HBox
            dogBox.getChildren().addAll(idLabel, nameLabel, ageLabel, breedLabel);

            // Aggiungi l'HBox al contenitore principale
            dogContainer.getChildren().add(dogBox);
        }

        // Aggiungi il contenitore a uno ScrollPane
        ScrollPane scrollPane = new ScrollPane(dogContainer);
        GUIFactory.getGraphicalSingletonFactory().createStarterWindow().setCentralView(dogContainer);


*/
    }
}
