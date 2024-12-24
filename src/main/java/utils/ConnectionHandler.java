package utils;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionHandler {
    private static ConnectionHandler instance = null;
    Connection connection;
    private ConnectionHandler() {
        try{
            String connection_url = "jdbc:mysql://localhost:3306/adopt_your_dog";
            String user = "ispw";
            String pass = "damettere";

            connection =  DriverManager.getConnection(connection_url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionHandler getInstance() {
        if (instance == null) {
            instance = new ConnectionHandler();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
