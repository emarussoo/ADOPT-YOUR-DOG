package model.dogadoptionrequest.dao;

import model.dog.Dog;
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
        return null;
    }

    @Override
    public void add(DogAdoptionRequest dogAdoptionRequest){
        String query = "INSERT INTO dog_adoption_request VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement darStatement = connection.prepareStatement(query)){
            darStatement.setInt(1, dogAdoptionRequest.getDogId());
            darStatement.setString(2, dogAdoptionRequest.getUserFirstname());
            darStatement.setString(3, dogAdoptionRequest.getUserLastname());
            darStatement.setString(4, dogAdoptionRequest.getUserEmail());
            darStatement.setString(5, dogAdoptionRequest.getUserPhone());
            darStatement.setInt(6, dogAdoptionRequest.getDogId());
            darStatement.setInt(7, dogAdoptionRequest.getKennelId());
            darStatement.execute();
            currenntDarId++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //add
    }
    public void removeDarById(int darId){
        //delete
    }
    public List<DogAdoptionRequest> getAllDogAdoptionRequest(){
        List<DogAdoptionRequest> allDars = new ArrayList<>();
        String query = "SELECT * FROM dog_adoption_request";
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
                    DogAdoptionRequest dar = new DogAdoptionRequest(darIdResult, darUserFirstName, darUserLastName, darUserEmail, darUserPhone, darDogId, darKennelId);
                    allDars.add(dar);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //dbms implementation of getalldogs operation
        return allDars;
    }

    public int getCurrentId(){
        return 0;
    }
}
