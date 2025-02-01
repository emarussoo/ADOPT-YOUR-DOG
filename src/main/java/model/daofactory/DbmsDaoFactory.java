package model.daofactory;

import model.dog.dao.DbmsDogDao;
import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DbmsDogAdoptionRequestDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;
import model.kennel.dao.DbmsKennelDao;
import model.kennel.dao.KennelDao;
import model.login.dao.DbmsKennelUserDao;


public class DbmsDaoFactory extends DaoFactory {
    @Override
    public DogDao createDogDao() {
        return new DbmsDogDao();
    }

    @Override
    public DogAdoptionRequestDao createDogAdoptionRequestDao() {
        return new DbmsDogAdoptionRequestDao();
    }

    @Override
    public KennelDao createKennelDao(){
        return new DbmsKennelDao();
    }

    @Override
    public DbmsKennelUserDao createKennelUserDao(){
        return new DbmsKennelUserDao();
    }
}
