package start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SidebarController{
    @FXML
    private BorderPane bp;
    private AnchorPane ap;

    public void testPage(MouseEvent event) {
        load_page("test-page");
    }

    public void dogsUserPage(MouseEvent event) {
        load_page("dogs-user-page");
    }

    public void load_page(String page){
        Parent root = null;

        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource(page+".fxml"));

        }catch(IOException ex) {
            Logger.getLogger(SidebarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setCenter(root);
    }
}
