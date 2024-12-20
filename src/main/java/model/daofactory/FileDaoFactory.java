package model.daofactory;

import model.dog.dao.DemoDogDao;
import model.dog.dao.DogDao;
import model.dog.dao.FileDogDao;
import model.dogadoptionrequest.dao.DemoDogAdoptionRequestDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;
import model.dogadoptionrequest.dao.FileDogAdoptionRequestDao;

public class FileDaoFactory extends DaoFactory {
    @Override
    public DogDao createDogDao() {
        return new FileDogDao();
    }
    public DogAdoptionRequestDao createDogAdoptionRequestDao() {
        return new FileDogAdoptionRequestDao();
    }
}
