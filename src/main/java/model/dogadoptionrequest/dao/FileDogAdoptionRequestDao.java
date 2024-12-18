package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.List;

public class FileDogAdoptionRequestDao extends DogAdoptionRequestDao{
    @Override
    public DogAdoptionRequest load(int darId){ return null;};
    public void add(DogAdoptionRequest dogAdoptionRequest){};
    public void delete(int darId){};
    public List<DogAdoptionRequest> getAllKennelDogAdoptionRequest(int kennelId){return null;};
}
