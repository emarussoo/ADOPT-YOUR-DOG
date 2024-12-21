package model.dog.dao;

import model.dog.Dog;

import java.util.List;

public class DbmsDogDao extends DogDao{
    @Override
    public Dog getDogById(int dogId){
        //dbms implementation of load operation
        return null;
    };
    public void add(Dog dog){
        //dbms implementation of add operation

    };
    public void delete(int dogId){
        //dbms implementation of delete operation

    };
    public List<Dog> searchDogsByBreed(String breed){
        //dbms implementation of search operation
        return null;
    };
    public List<Dog> getAllDogs(){
        //dbms implementation of getalldogs operation
        return null;
    };
}
