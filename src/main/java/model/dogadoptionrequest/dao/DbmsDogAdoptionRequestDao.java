package model.dogadoptionrequest.dao;

import exceptions.GenericSystemException;
import model.daofactory.DaoFactory;
import model.dogadoptionrequest.DogAdoptionRequest;
import utils.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbmsDogAdoptionRequestDao extends DogAdoptionRequestDao{
    int currenntDarId = 0;
    @Override
    public DogAdoptionRequest getDarById(int darId){
        DogAdoptionRequest dar = null;
        String query = "SELECT id, user_firstname, user_lastname, user_email, user_phone, dog_id, kennel_id FROM dog_adoption_request WHERE id = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement darStatement = connection.prepareStatement(query)){
            darStatement.setInt(1, darId);
            try(ResultSet rs = darStatement.executeQuery()){
                if(rs.next()){
                    int id = rs.getInt("id");
                    String userFirstname = rs.getString("user_firstname");
                    String userLastname = rs.getString("user_lastname");
                    String userEmail = rs.getString("user_email");
                    String userPhone = rs.getString("user_phone");
                    int dogId = rs.getInt("dog_id");
                    int kennelId = rs.getInt("kennel_id");
                    dar = new DogAdoptionRequest(id, userFirstname, userLastname, userEmail, userPhone, DaoFactory.getDaoSingletonFactory().createDogDao().getDogById(dogId), DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(kennelId));
                }
            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return dar;
    }

    @Override
    public void add(DogAdoptionRequest dogAdoptionRequest) throws GenericSystemException {
        String query = "INSERT INTO dog_adoption_request (user_firstname, user_lastname, user_email, user_phone, dog_id, kennel_id) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement darStatement = connection.prepareStatement(query)){
            darStatement.setString(1, dogAdoptionRequest.getUserFirstname());
            darStatement.setString(2, dogAdoptionRequest.getUserLastname());
            darStatement.setString(3, dogAdoptionRequest.getUserEmail());
            darStatement.setString(4, dogAdoptionRequest.getUserPhone());
            darStatement.setInt(5, dogAdoptionRequest.getDog().getDogId());
            darStatement.setInt(6, dogAdoptionRequest.getKennel().getKennelId());
            darStatement.execute();
            currenntDarId++;
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        //add
    }
    public void removeAllDarByDogId(int dogId) throws GenericSystemException {
        String query = "DELETE FROM dog_adoption_request WHERE dog_id = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement darStatement = connection.prepareStatement(query)){
            darStatement.setInt(1, dogId);
            darStatement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        //delete
    }

    public void removeDarById(int darId) throws GenericSystemException {
        String query = "DELETE FROM dog_adoption_request WHERE id = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement darStatement = connection.prepareStatement(query)){
            darStatement.setInt(1, darId);
            darStatement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
    }

    public List<DogAdoptionRequest> getAllDogAdoptionRequest() throws GenericSystemException {
        List<DogAdoptionRequest> allDars = new ArrayList<>();
        String query = "SELECT id, user_firstname, user_lastname, user_email, user_phone, dog_id, kennel_id FROM dog_adoption_request";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            try(ResultSet darResultSet = dogsStatement.executeQuery()){
                while(darResultSet.next()){
                    int darIdResult = darResultSet.getInt("id");
                    String darUserFirstName = darResultSet.getString("user_firstname");
                    String darUserLastName = darResultSet.getString("user_lastname");
                    String darUserEmail = darResultSet.getString("user_email");
                    String darUserPhone = darResultSet.getString("user_phone");
                    int darDogId = darResultSet.getInt("dog_id");
                    int darKennelId = darResultSet.getInt("kennel_id");
                    DogAdoptionRequest dar = new DogAdoptionRequest(darIdResult, darUserFirstName, darUserLastName, darUserEmail, darUserPhone, DaoFactory.getDaoSingletonFactory().createDogDao().getDogById(darDogId), DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(darKennelId));
                    allDars.add(dar);
                }
            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        //dbms implementation of getalldogs operation
        return allDars;
    }

}
