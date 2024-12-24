package model.kennel.dao;

import model.dog.Dog;
import model.kennel.Kennel;
import utils.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbmsKennelDao extends KennelDao{
    public Kennel getKennelById(int kennelId) {
        Kennel kennel = new Kennel();
        String query = "SELECT * FROM kennels WHERE ID = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement kennelStatement = connection.prepareStatement(query)){
            kennelStatement.setString(1, Integer.toString(kennelId));
            try(ResultSet kennelResultSet = kennelStatement.executeQuery()){
                while(kennelResultSet.next()){
                    int kennelIdResult = kennelResultSet.getInt("id");
                    String kennelNameResult = kennelResultSet.getString("name");
                    kennel.setKennelId(kennelIdResult);
                    kennel.setKennelName(kennelNameResult);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //dbms implementation of load operation
        return kennel;
    }
}
