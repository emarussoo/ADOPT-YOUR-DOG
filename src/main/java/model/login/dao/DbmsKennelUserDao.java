package model.login.dao;

import exceptions.GenericSystemException;
import model.daofactory.DaoFactory;
import model.login.KennelUser;
import utils.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbmsKennelUserDao extends KennelUserDao {
    public boolean check(KennelUser user) throws GenericSystemException {
        String query = "SELECT kennel_id FROM user WHERE username = ? AND pw = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement kennelUserStatement = connection.prepareStatement(query)){
            kennelUserStatement.setString(1, user.getKennelUsername());
            kennelUserStatement.setString(2, user.getKennelPassword());
            try(ResultSet kennelUserResultSet = kennelUserStatement.executeQuery()){
                while(kennelUserResultSet.next()){
                    user.setKennel(DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(kennelUserResultSet.getInt("kennel_id")));
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return false;
    }

    public void add(KennelUser user) throws GenericSystemException {
        String query = "INSERT INTO user (username, pw, kennel_id) VALUES (?, ?, ?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement userStatement = connection.prepareStatement(query)){
            userStatement.setString(1, user.getKennelUsername());
            userStatement.setString(2, user.getKennelPassword());
            userStatement.setInt(3, user.getKennel().getKennelId());
            userStatement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
    }
}
