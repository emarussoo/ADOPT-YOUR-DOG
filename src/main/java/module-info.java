module start.adoptyourdog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.net.http;


    opens start to javafx.fxml;
    exports start;

    opens view to javafx.fxml;
    exports view;
    exports utils;
    opens utils to javafx.fxml;
}