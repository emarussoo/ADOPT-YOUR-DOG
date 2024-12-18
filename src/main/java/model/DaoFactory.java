package model;

import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;

public abstract class DaoFactory {
    public abstract DogDao createDogDao();
    public abstract DogAdoptionRequestDao createDogAdoptionRequestDao();
}
