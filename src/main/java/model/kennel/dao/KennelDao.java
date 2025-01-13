package model.kennel.dao;

import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import model.kennel.Kennel;

import java.util.ArrayList;
import java.util.List;

public abstract class KennelDao {
    public abstract Kennel getKennelById(int kennelId);
    public abstract int addKennel(Kennel kennel);
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
