module start.adoptyourdog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens start to javafx.fxml;
    exports start;

    opens view to javafx.fxml;
    exports view;
}