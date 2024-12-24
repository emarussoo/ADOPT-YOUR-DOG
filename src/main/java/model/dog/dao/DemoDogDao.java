package model.dog.dao;

import model.dog.Dog;

import java.util.ArrayList;
import java.util.List;

public class DemoDogDao extends DogDao{
    int counter = 0;

    private static List<Dog> demoListOfDogs= new ArrayList<Dog>();

    static DemoDogDao instance = null;

    protected DemoDogDao() {
        demoListOfDogs.add(new Dog(1, "pippo", 2, "pastore tedesco", 34));
        demoListOfDogs.add(new Dog(2, "pluto", 2, "maremmano", 90));
        demoListOfDogs.add(new Dog(3, "paperino", 2, "husky", 96));
        demoListOfDogs.add(new Dog(4, "rambo", 2, "maremmano", 96));
        demoListOfDogs.add(new Dog(5, "rocky", 2, "setter", 96));

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
    public void removeDogById(int dogId){
        for(Dog dog: demoListOfDogs){
            if(dog.getDogId() == dogId){
                demoListOfDogs.remove(dog);
                return;
            }
        }
    }
    public List<Dog> searchDogsByBreed(String breed){

        //demo implementation of search operation
        return new ArrayList<>();
    }
    public List<Dog> getAllDogs(){
        //demo implementation of getalldogs operation
        return demoListOfDogs;
    }

    public int getCurrentId(){
        return counter++;
    }
}
