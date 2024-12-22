package model.dogadoptionrequest.dao;


import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.ArrayList;
import java.util.List;

public class DemoDogAdoptionRequestDao extends DogAdoptionRequestDao{

    private static List<DogAdoptionRequest> demoListOfDogAdoptionRequest= new ArrayList<DogAdoptionRequest>();
    static DemoDogAdoptionRequestDao instance = null;

    protected DemoDogAdoptionRequestDao(){

    }
    @Override
    public DogAdoptionRequest load(int darId){
        return null;
    }
    public void add(DogAdoptionRequest dogAdoptionRequest){
        demoListOfDogAdoptionRequest.add(dogAdoptionRequest);
        //add
    }
    public void delete(int darId){
        //delete
    }
    public List<DogAdoptionRequest> getAllKennelDogAdoptionRequest(int kennelId){
        List<DogAdoptionRequest> kennelIdDogAdoptionRequest = new ArrayList<>();
        for(DogAdoptionRequest dar : demoListOfDogAdoptionRequest){
            if(dar.getKennelId() == kennelId){
                kennelIdDogAdoptionRequest.add(dar);
            }
        }

        return kennelIdDogAdoptionRequest;
    }

    public static DemoDogAdoptionRequestDao getSingletonInstance() {
        if(instance == null){
            instance = new DemoDogAdoptionRequestDao();
        }
        return instance;
    }
}
