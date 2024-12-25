package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.List;

public abstract class DogAdoptionRequestDao {
    public abstract DogAdoptionRequest getDarById(int darId);
    public abstract void add(DogAdoptionRequest dogAdoptionRequest);
    public abstract List<DogAdoptionRequest> getAllDogAdoptionRequest();
    public abstract void removeAllDarByDogId(int dogId);
    public abstract void removeDarById(int darId);

}
