package model.daofactory;

import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;
import model.kennel.dao.KennelDao;

public abstract class DaoFactory {
    public abstract DogDao createDogDao();
    public abstract DogAdoptionRequestDao createDogAdoptionRequestDao();
    public abstract KennelDao createKennelDao();

    private static DaoFactory instance = null;

    public static DaoFactory getDaoSingletonFactory(){
        String persistence = System.getProperty("persistence");
        if(instance == null){
            if(persistence.equals("DEMO")){
                instance = new DemoDaoFactory();
            }

            if(persistence.equals("JDBC")){
                instance = new DbmsDaoFactory();
            }

            if(persistence.equals("FILE")){
                instance = new FileDaoFactory();
            }
        }
        return instance;
    }
}
