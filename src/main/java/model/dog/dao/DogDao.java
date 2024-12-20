package model.dog.dao;

import model.dog.Dog;

import java.util.List;

public abstract class DogDao {
    public abstract Dog load(int dogId);
    public abstract void add(Dog dog);
    public abstract void delete(int dogId);
    public abstract List<Dog> searchDogsByBreed(String breed);
    public abstract List<Dog> getAllDogs();
}
