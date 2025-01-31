package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.List;

public abstract class DogAdoptionRequestDao {
    //used to get a dar Model with an darId in input
    public abstract DogAdoptionRequest getDarById(int darId);
    //used to add a dar to a persistence layer
    public abstract void add(DogAdoptionRequest dogAdoptionRequest);
    //used to get all dog adoption request from a persistence layer
    public abstract List<DogAdoptionRequest> getAllDogAdoptionRequest();
    //this will be used when a dar is accepted
    //all the dars concerning that dog will be removed
    public abstract void removeAllDarByDogId(int dogId);
    //used to remove a specific dar
    public abstract void removeDarById(int darId);
}
