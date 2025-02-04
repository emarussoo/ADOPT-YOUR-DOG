package view.kennel.managedogadoptionrequestview;
import bean.DogAdoptionRequestBean;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import view.kennel.windowmanager.KennelWindowManager;
import java.util.List;

public class GUIManageDarPageController extends ManageDarPageController {
    ListView listView = new ListView<>();
    public void createDarList(List<DogAdoptionRequestBean> listOfDarsBean) {

        Label title = new Label("Manage dog adoption requests");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 30px");

        listView.setStyle("-fx-alignment: center; -fx-font-size: 15px");


        VBox dogContainer = new VBox(10);
        dogContainer.setSpacing(30);
        dogContainer.setStyle("-fx-padding: 30px");
        dogContainer.setAlignment(Pos.TOP_CENTER);
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


        dogContainer.getChildren().addAll(title, listView, rejectButton, acceptButton);
        KennelWindowManager.getSingletonInstance().getKennelMenuController().setCentralView(dogContainer);

    }

    public DogAdoptionRequestBean getDarInfo(){
        return (DogAdoptionRequestBean) listView.getSelectionModel().getSelectedItem();
    }
}
