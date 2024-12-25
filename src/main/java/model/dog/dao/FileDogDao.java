package model.dog.dao;

import model.dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class FileDogDao extends DogDao{
    @Override
    public Dog getDogById(int dogId){
        //file implementation of add operation
        return null;
    }
    public void add(Dog dog){
        //file implementation of add operation

    }
    public void removeDogById(int dogId){
        //file implementation of delete operation
    }
    /*public List<Dog> searchDogsByBreed(String breed){
        //file implementation of search operation
        return new ArrayList<>();
    }*/
    public List<Dog> getAllDogs(){
        //file implementation of getalldogs operation
        return new ArrayList<>();
    }

    public int getCurrentId(){
        return 0;
    }
}
