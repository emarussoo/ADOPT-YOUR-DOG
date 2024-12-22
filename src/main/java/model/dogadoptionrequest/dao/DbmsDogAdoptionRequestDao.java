package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.ArrayList;
import java.util.List;

public class DbmsDogAdoptionRequestDao extends DogAdoptionRequestDao{
    @Override
    public DogAdoptionRequest load(int darId){
        return null;
    }
    public void add(DogAdoptionRequest dogAdoptionRequest){
        //add
    }
    public void delete(int darId){
        //delete
    }
    public List<DogAdoptionRequest> getAllKennelDogAdoptionRequest(int kennelId){
        return new ArrayList<>();
    }
}
