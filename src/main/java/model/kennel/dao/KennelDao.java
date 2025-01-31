package model.kennel.dao;

import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import model.kennel.Kennel;

import java.util.ArrayList;
import java.util.List;

public abstract class KennelDao {
    //used to get a Kennel Model with a kennelId in input
    public abstract Kennel getKennelById(int kennelId);
    //add a Kennel to the persistence layer
    public abstract int addKennel(Kennel kennel);
    //this will be used to load all the kennel data (dogs and dars associated) with a kennel id in input
    //this will be used during auth procedure
    public Kennel loadKennelDataById(int kennelId) {
        Kennel kennel = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(kennelId);
        List<Dog> kennelDogs = DaoFactory.getDaoSingletonFactory().createDogDao().getAllDogs();
        List<DogAdoptionRequest> kennelRequests = DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().getAllDogAdoptionRequest();

        List <Dog> newDogsList = new ArrayList<>();
        List<DogAdoptionRequest> newDarList = new ArrayList<>();

        for (Dog kennelDog : kennelDogs) {
            if(kennelDog.getKennel().getKennelId() == kennelId){
                newDogsList.add(kennelDog);
            }
        }

        for (DogAdoptionRequest kennelRequest : kennelRequests) {
            if(kennelRequest.getKennel().getKennelId() == kennelId){
                newDarList.add(kennelRequest);
            }
        }

        kennel.setKennelDogs(newDogsList);
        kennel.setKennelRequests(newDarList);
        return kennel;
    }
}
