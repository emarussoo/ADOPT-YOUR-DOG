package model.dog.dao;

import model.dog.Dog;

import java.util.List;

public class DemoDogDao extends DogDao{
    @Override
    public Dog load(int dogId){
        //demo implementation of load operation
        return null;
    };
    public void add(Dog dog){
        //demo implementation of add operation

    };
    public void delete(int dogId){
        //demo implementation of delete operation

    };
    public void searchDogsByBreed(String breed){
        //demo implementation of search operation

    };
    public List<Dog> getAllDogs(){
        //demo implementation of getalldogs operation
        return null;
    };
}
