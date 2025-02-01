package model.daofactory;

import model.dog.dao.DemoDogDao;
import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DemoDogAdoptionRequestDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;
import model.kennel.dao.DemoKennelDao;
import model.kennel.dao.KennelDao;
import model.login.dao.DemoKennelUserDao;


public class DemoDaoFactory extends DaoFactory {
    @Override
    public DogDao createDogDao() {
        return DemoDogDao.getSingletonInstance();
    }

    @Override
    public DogAdoptionRequestDao createDogAdoptionRequestDao() {
        return DemoDogAdoptionRequestDao.getSingletonInstance();
    }

    @Override
    public KennelDao createKennelDao(){
        return DemoKennelDao.getSingletonInstance();
    }

    @Override
    public DemoKennelUserDao createKennelUserDao(){
        return DemoKennelUserDao.getInstance();
    }
}
