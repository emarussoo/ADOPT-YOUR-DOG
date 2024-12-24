package view.kennel.mydogsview;

import bean.DogProfileBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import view.kennel.windowmanager.KennelWindowManager;
import view.user.windowmanager.UserWindowManager;

import java.util.List;


public class GUIMyDogsPageController extends MyDogsPageController {

    @Override
    public void createMyDogsList(List<DogProfileBean> listOfDogsBean) {

        Label title = new Label("My dogs");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30px");

        ListView listView = new ListView<>();

        GridPane header = new GridPane();
        header.setHgap(140); // Spaziatura orizzontale tra le colonne
        header.add(new Label(" ID"), 0, 0);
        header.add(new Label("Name"), 1, 0);
        header.add(new Label("Age"), 2, 0);
        header.add(new Label("Breed"), 3, 0);
        header.setStyle("-fx-font-weight: bold; -fx-padding: 5px;");
        listView.setStyle("-fx-alignment: center; -fx-font-size: 15px");


        VBox dogContainer = new VBox(10);
        dogContainer.setSpacing(30);
        dogContainer.setStyle("-fx-padding: 30px");
        dogContainer.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(header, new Insets(0, 0, -15, 0)); // Ridotto il margine inferiore per l'header
        VBox.setMargin(listView, new Insets(-15, 0, 0, 0));

        listView.getItems().clear();
        for(DogProfileBean dog: listOfDogsBean){
            listView.getItems().add(dog.kennelString());
        }


        dogContainer.getChildren().addAll(title, header, listView);
        KennelWindowManager.getSingletonInstance().getKennelMenuController().setCentralView(dogContainer);
    }
}
