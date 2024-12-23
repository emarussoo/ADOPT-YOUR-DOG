package view.kennel.managedogadoptionrequestview;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.kennel.windowmanager.KennelWindowManager;
import view.user.windowmanager.UserWindowManager;

import java.util.List;

public class GUIManageDarPageController extends ManageDarPageController {
    ListView listView = new ListView<>();
    public void createDarList(List<DogAdoptionRequestBean> listOfDarsBean) {

        GridPane header = new GridPane();
        header.setHgap(90); // Spaziatura orizzontale tra le colonne
        header.add(new Label("ID"), 0, 0);
        header.add(new Label(" Name"), 1, 0);
        header.add(new Label("Surname"), 2, 0);
        header.add(new Label("Email"), 3, 0);
        header.add(new Label("Phone"), 4, 0);
        header.add(new Label("dog id"), 5, 0);
        header.setStyle("-fx-font-weight: bold; -fx-padding: 5px;");
        listView.setStyle("-fx-alignment: center; -fx-font-size: 15px");


        VBox dogContainer = new VBox(10);
        dogContainer.setSpacing(30);
        dogContainer.setStyle("-fx-padding: 30px");
        dogContainer.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(header, new Insets(0, 0, -15, 0)); // Ridotto il margine inferiore per l'header
        VBox.setMargin(listView, new Insets(-15, 0, 0, 0));

        listView.getItems().clear();
        listView.getItems().addAll(listOfDarsBean);

        Button rejectButton = new Button("REJECT");
        rejectButton.setStyle("-fx-background-color: red; -fx-font-size: 20px; -fx-min-width: 250px");
        rejectButton.setOnAction(actionEvent -> {
            KennelWindowManager.getSingletonInstance().rejectDar();
        });
        Button acceptButton = new Button("ACCEPT");
        acceptButton.setStyle("-fx-background-color: #2cc61e; -fx-font-size: 20px; -fx-min-width: 250px");
        acceptButton.setOnAction(actionEvent -> {
            KennelWindowManager.getSingletonInstance().acceptDar();
        });


        dogContainer.getChildren().addAll(header, listView, rejectButton, acceptButton);
        KennelWindowManager.getSingletonInstance().getKennelMenuController().setCentralView(dogContainer);

    }

    public DogAdoptionRequestBean getDarInfo(){
        return (DogAdoptionRequestBean) listView.getSelectionModel().getSelectedItem();
    }
}
