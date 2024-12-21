package model.dog.dao;

import model.dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class DemoDogDao extends DogDao{

    private static List<Dog> demoListOfDogs= new ArrayList<Dog>();

    static DemoDogDao instance = null;

    protected DemoDogDao() {
        demoListOfDogs.add(new Dog(1, "pippo", 2, "pastore tedesco", 34));
        demoListOfDogs.add(new Dog(2, "pluto", 2, "maremmano", 90));
        demoListOfDogs.add(new Dog(3, "paperino", 2, "husky", 96));

    }

    public static DemoDogDao getSingletonInstance() {
        if(instance == null){
            instance = new DemoDogDao();
        }
        return instance;
    }

    @Override
    public Dog getDogById(int dogId){
        for(Dog dog: demoListOfDogs){
            if(dog.getDogId() == dogId){
                return dog;
            }
        }
        //demo implementation of load operation
        return null;
    }
    public void add(Dog dog){
        demoListOfDogs.add(dog);
        //demo implementation of add operation

    }
    public void delete(int dogId){
        //demo implementation of delete operation

    }
    public List<Dog> searchDogsByBreed(String breed){

        //demo implementation of search operation
        return null;
    }
    public List<Dog> getAllDogs(){
        //demo implementation of getalldogs operation
        return demoListOfDogs;
    }
}
