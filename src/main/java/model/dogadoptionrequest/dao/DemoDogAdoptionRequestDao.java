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
    public DogAdoptionRequest getDarById(int darId){
        DogAdoptionRequest toReturnDar = null;
        for(DogAdoptionRequest dar: demoListOfDogAdoptionRequest){
            if(dar.getDarId() == darId){
                toReturnDar = dar;
            }
        }
        return toReturnDar;
    }

    public void add(DogAdoptionRequest dogAdoptionRequest){
        demoListOfDogAdoptionRequest.add(dogAdoptionRequest);
        //add
    }
    public void removeDarById(int darId){
        for(DogAdoptionRequest dar: demoListOfDogAdoptionRequest){
            if(dar.getDarId() == darId){
                demoListOfDogAdoptionRequest.remove(dar);
                return;
            }
        }
        //delete
    }
    public List<DogAdoptionRequest> getAllDogAdoptionRequest(){
        return demoListOfDogAdoptionRequest;
    }

    public static DemoDogAdoptionRequestDao getSingletonInstance() {
        if(instance == null){
            instance = new DemoDogAdoptionRequestDao();
        }
        return instance;
    }
}
