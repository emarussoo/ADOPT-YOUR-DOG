package model;

import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;

public class DemoDaoFactory extends DaoFactory{
    @Override
    public DogDao createDogDao() { return null;}
    public DogAdoptionRequestDao createDogAdoptionRequestDao() { return null;}
}
