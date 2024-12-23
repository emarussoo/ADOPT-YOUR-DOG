module start.adoptyourdog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires org.apache.logging.log4j;
    requires java.logging;
    requires jdk.jfr;


    opens start to javafx.fxml;
    exports start;
    exports baseclasses to com.fasterxml.jackson.databind;
    exports view.user.windowmanager;
    opens view.user.windowmanager to javafx.fxml;

    exports utils;
    opens utils to javafx.fxml;
    opens view.login to javafx.fxml;
}