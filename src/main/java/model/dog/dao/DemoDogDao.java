package model.dog.dao;

import model.dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class DemoDogDao extends DogDao{
    int counter = 3;

    private static List<Dog> demoListOfDogs= new ArrayList<Dog>();

    static DemoDogDao instance = null;

    protected DemoDogDao() {
        demoListOfDogs.add(new Dog(1, "pippo", 2, "pastore tedesco", 1));
        demoListOfDogs.add(new Dog(2, "pluto", 2, "maremmano", 2));

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
        dog.setDogId(counter);
        counter++;
        demoListOfDogs.add(dog);
        //demo implementation of add operation
    }
    public void removeDogById(int dogId){
        for(Dog dog: demoListOfDogs){
            if(dog.getDogId() == dogId){
                demoListOfDogs.remove(dog);
                return;
            }
        }
    }
    public List<Dog> getAllDogs(){
        //demo implementation of getalldogs operation
        return demoListOfDogs;
    }

    public int getCurrentId(){
        return counter++;
    }
}
