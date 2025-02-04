package model.kennel.dao;

import exceptions.GenericSystemException;
import model.kennel.Kennel;
import utils.ConnectionHandler;

import java.sql.*;

public class DbmsKennelDao extends KennelDao{
    public Kennel getKennelById(int kennelId) throws GenericSystemException {
        Kennel kennel = new Kennel();
        String query = "SELECT id,name FROM kennels WHERE ID = ?";
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
            throw new GenericSystemException(e.getMessage());
        }
        return kennel;
    }

    public int addKennel(Kennel kennel) throws GenericSystemException {
        int addedKennelId = -1;
        String query = "INSERT INTO kennels (name) VALUES (?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement kennelStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            kennelStatement.setString(1, kennel.getKennelName());
            kennelStatement.executeUpdate();
            ResultSet generatedKeys = kennelStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                addedKennelId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return addedKennelId;
    }
}
