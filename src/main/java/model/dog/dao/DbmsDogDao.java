package model.dog.dao;

import exceptions.GenericSystemException;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import utils.ConnectionHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DbmsDogDao extends DogDao{
    @Override
    public Dog getDogById(int dogId) throws GenericSystemException {
        Dog dog = new Dog();
        String query = "SELECT id, name, age, breed, kennel_id FROM DOGS WHERE ID = ?";
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
                    dog.setKennelId(DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(dogKennelIdResult));
                }

            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return dog;
    }
    public void add(Dog dog) throws GenericSystemException {
        String query = "INSERT INTO DOGS (name, age, breed, kennel_id) VALUES ( ?, ?, ?, ?)";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            dogsStatement.setString(1, dog.getDogName());
            dogsStatement.setInt(2, dog.getDogAge());
            dogsStatement.setString(3, dog.getDogBreed());
            dogsStatement.setInt(4, dog.getKennel().getKennelId());
            dogsStatement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }

    }
    public void removeDogById(int dogId) throws GenericSystemException {
        String query = "DELETE FROM dogs WHERE id = ?";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            dogsStatement.setInt(1, dogId);
            dogsStatement.executeUpdate();
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
    }

    public List<Dog> getAllDogs() throws GenericSystemException {
        List<Dog> allDogs = new ArrayList<>();
        String query = "SELECT id, name, age, breed, kennel_id FROM DOGS";
        Connection connection = ConnectionHandler.getInstance().getConnection();
        try(PreparedStatement dogsStatement = connection.prepareStatement(query)){
            try(ResultSet dogsResultSet = dogsStatement.executeQuery()){
                while(dogsResultSet.next()){
                    int dogIdResult = dogsResultSet.getInt("id");
                    String dogNameResult = dogsResultSet.getString("name");
                    int dogAgeResult = dogsResultSet.getInt("age");
                    String dogBreedResult = dogsResultSet.getString("breed");
                    int dogKennelIdResult = dogsResultSet.getInt("kennel_id");
                    Dog dog = new Dog(dogIdResult, dogNameResult, dogAgeResult, dogBreedResult, DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(dogKennelIdResult));
                    allDogs.add(dog);
                }
            }
        } catch (SQLException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return allDogs;
    }

}
