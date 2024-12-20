package model.daofactory;

import model.dog.dao.DbmsDogDao;
import model.dog.dao.DemoDogDao;
import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DbmsDogAdoptionRequestDao;
import model.dogadoptionrequest.dao.DemoDogAdoptionRequestDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;

public class DbmsDaoFactory extends DaoFactory {
    @Override
    public DogDao createDogDao() {
        return new DbmsDogDao();
    }
    public DogAdoptionRequestDao createDogAdoptionRequestDao() {
        return new DbmsDogAdoptionRequestDao();
    }
}
