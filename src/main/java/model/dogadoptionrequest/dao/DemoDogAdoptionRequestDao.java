package model.dogadoptionrequest.dao;


import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.ArrayList;
import java.util.List;

public class DemoDogAdoptionRequestDao extends DogAdoptionRequestDao{

    private List<DogAdoptionRequest> demoListOfDogAdoptionRequest= new ArrayList<DogAdoptionRequest>();
    static DemoDogAdoptionRequestDao instance = null;
    private int counter = 0;

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
        dogAdoptionRequest.setDarId(counter);
        counter++;
        demoListOfDogAdoptionRequest.add(dogAdoptionRequest);
        //add
    }
    public void removeAllDarByDogId(int dogId){
        List<DogAdoptionRequest> newList = new ArrayList<>();
        for(DogAdoptionRequest dar: demoListOfDogAdoptionRequest){
            if(dar.getDog().getDogId() != dogId){
                newList.add(dar);
            }
        }

        demoListOfDogAdoptionRequest = newList;
        //delete
    }

    public void removeDarById(int darId){
        for(DogAdoptionRequest dar: demoListOfDogAdoptionRequest){
            if(dar.getDarId() == darId){
                demoListOfDogAdoptionRequest.remove(dar);
                return;
            }
        }

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
