package model.dog.dao;

import model.dog.Dog;

import java.util.List;

public class DbmsDogDao extends DogDao{
    @Override
    public Dog load(int dogId){return null;};
    public void add(Dog dog){};
    public void delete(int dogId){};
    public void searchDogsByBreed(String breed){};
    public List<Dog> getAllDogs(){return null;};
}
