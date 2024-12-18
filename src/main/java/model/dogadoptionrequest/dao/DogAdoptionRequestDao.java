package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.List;

public abstract class DogAdoptionRequestDao {
    public abstract DogAdoptionRequest load(int darId);
    public abstract void add(DogAdoptionRequest dogAdoptionRequest);
    public abstract void delete(int darId);
    public abstract List<DogAdoptionRequest> getAllKennelDogAdoptionRequest(int kennelId);

}
