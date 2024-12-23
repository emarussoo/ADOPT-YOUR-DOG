package model.dogadoptionrequest.dao;

import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.ArrayList;
import java.util.List;

public class FileDogAdoptionRequestDao extends DogAdoptionRequestDao{
    @Override
    public DogAdoptionRequest getDarById(int darId){
        return null;
    }
    public void add(DogAdoptionRequest dogAdoptionRequest){
        //add
    }
    public void removeDarById(int darId){
        //delete

    }
    public List<DogAdoptionRequest> getAllDogAdoptionRequest(){
        return new ArrayList<>();
    }
}
