package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;

public class ConnectionHandler {
    private static ConnectionHandler instance = null;
    Properties prop = new Properties();
    Connection connection;
    private ConnectionHandler() {
        try(FileInputStream dbInfoFile = new FileInputStream("src/main/resources/database.properties")){
            prop.load(dbInfoFile);
            String connectionUrl = prop.getProperty("url");
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

            connection =  DriverManager.getConnection(connectionUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
