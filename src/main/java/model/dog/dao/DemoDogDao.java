package model.dog.dao;

import model.dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class DemoDogDao extends DogDao{
    int counter = 0;

    private static List<Dog> demoListOfDogs= new ArrayList<Dog>();

    static DemoDogDao instance = null;

    protected DemoDogDao() {

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
        return null;
    }

    public void add(Dog dog){
        dog.setDogId(counter);
        counter++;
        demoListOfDogs.add(dog);
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
        return demoListOfDogs;
    }
}
