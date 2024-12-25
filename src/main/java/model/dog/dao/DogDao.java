package model.dog.dao;

import model.dog.Dog;

import java.util.List;

public abstract class DogDao {
    public abstract Dog getDogById(int dogId);
    public abstract void add(Dog dog);
    public abstract void removeDogById(int dogId);
    //public abstract List<Dog> searchDogsByBreed(String breed);
    public abstract List<Dog> getAllDogs();
    //public abstract int getCurrentId();
}
