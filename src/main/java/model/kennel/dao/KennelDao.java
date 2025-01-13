package model.kennel.dao;

import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import model.kennel.Kennel;

import java.util.List;

public abstract class KennelDao {
    public abstract Kennel getKennelById(int kennelId);
    public abstract int addKennel(Kennel kennel);
    public Kennel loadKennelDataById(int kennelId) {
        Kennel kennel = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(kennelId);
        List<Dog> kennelDogs = DaoFactory.getDaoSingletonFactory().createDogDao().getAllDogs();
        List<DogAdoptionRequest> kennelRequests = DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().getAllDogAdoptionRequest();

        for (Dog kennelDog : kennelDogs) {
            if(kennelDog.getKennelId() == kennelId){
                kennel.addDog(kennelDog);
            }
        }

        for (DogAdoptionRequest kennelRequest : kennelRequests) {
            if(kennelRequest.getKennelId() == kennelId){
                kennel.addRequest(kennelRequest);
            }
        }

        return kennel;
    }
}
