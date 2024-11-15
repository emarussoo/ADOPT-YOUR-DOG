module start.adoptyourdog {
    requires javafx.controls;
    requires javafx.fxml;


    opens start to javafx.fxml;
    exports start;
}