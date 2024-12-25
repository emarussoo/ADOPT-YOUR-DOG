package model.dog.dao;

import model.dog.Dog;
import utils.ConnectionHandler;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DbmsDogDao extends DogDao{
    //int currentDogId = 0;
    @Override
    public Dog getDogById(int dogId){
        Dog dog = new Dog();
        String query = "SELECT * FROM DOGS WHERE ID = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            dogsStatement.setString(1, Integer.toString(dogId));
            try(ResultSet dogsResultSet = dogsStatement.executeQuery()){
                while(dogsResultSet.next()){
                    int dogIdResult = dogsResultSet.getInt("id");
                    String dogNameResult = dogsResultSet.getString("name");
                    int dogAgeResult = dogsResultSet.getInt("age");
                    String dogBreedResult = dogsResultSet.getString("breed");
                    int dogKennelIdResult = dogsResultSet.getInt("kennel_id");
                    dog.setDogId(dogIdResult);
                    dog.setDogName(dogNameResult);
                    dog.setDogAge(dogAgeResult);
                    dog.setDogBreed(dogBreedResult);
                    dog.setKennelId(dogKennelIdResult);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //dbms implementation of load operation
        return dog;
    }
    public void add(Dog dog){
        String query = "INSERT INTO DOGS (name, age, breed, kennel_id) VALUES ( ?, ?, ?, ?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            //dogsStatement.setInt(1, dog.getDogId());
            dogsStatement.setString(1, dog.getDogName());
            dogsStatement.setInt(2, dog.getDogAge());
            dogsStatement.setString(3, dog.getDogBreed());
            dogsStatement.setInt(4, dog.getKennelId());
            dogsStatement.executeUpdate();
            //currentDogId++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//dbms implementation of add operation

    }
    public void removeDogById(int dogId){
        String query = "DELETE FROM dogs WHERE id = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            dogsStatement.setInt(1, dogId);
            dogsStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //dbms implementation of delete operation
    }
    /*public List<Dog> searchDogsByBreed(String breed){
        //dbms implementation of search operation
        return new ArrayList<>();
    }*/
    public List<Dog> getAllDogs(){
        List<Dog> allDogs = new ArrayList<>();
        String query = "SELECT * FROM DOGS";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            try(ResultSet dogsResultSet = dogsStatement.executeQuery()){
                while(dogsResultSet.next()){
                    int dogIdResult = dogsResultSet.getInt("id");
                    String dogNameResult = dogsResultSet.getString("name");
                    int dogAgeResult = dogsResultSet.getInt("age");
                    String dogBreedResult = dogsResultSet.getString("breed");
                    int dogKennelIdResult = dogsResultSet.getInt("kennel_id");
                    Dog dog = new Dog(dogIdResult, dogNameResult, dogAgeResult, dogBreedResult, dogKennelIdResult);
                    allDogs.add(dog);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //dbms implementation of getalldogs operation
        return allDogs;
    }

    /*public int getCurrentId(){
        return currentDogId;
    }*/
}
