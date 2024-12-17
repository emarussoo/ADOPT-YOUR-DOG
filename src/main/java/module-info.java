module start.adoptyourdog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires java.logging;


    opens start to javafx.fxml;
    exports start;
    exports baseclasses to com.fasterxml.jackson.databind;

    opens view to javafx.fxml;
    exports view;
    exports utils;
    opens utils to javafx.fxml;
}