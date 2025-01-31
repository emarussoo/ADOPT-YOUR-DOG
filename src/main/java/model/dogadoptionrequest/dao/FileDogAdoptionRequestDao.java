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
    public void removeAllDarByDogId(int dogId){
        //delete
    }

    public void removeDarById(int darId){
        //rimuove dato un id

    }
    public List<DogAdoptionRequest> getAllDogAdoptionRequest(){
        return new ArrayList<>();
    }
}
