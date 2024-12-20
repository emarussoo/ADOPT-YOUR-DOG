package model.daofactory;

import model.dog.dao.DogDao;
import model.dogadoptionrequest.dao.DogAdoptionRequestDao;
import view.user.factory.CLIFactory;
import view.user.factory.GUIFactory;
import view.user.factory.GraphicalFactory;

public abstract class DaoFactory {
    public abstract DogDao createDogDao();
    public abstract DogAdoptionRequestDao createDogAdoptionRequestDao();

    private static DaoFactory instance = null;

    public static DaoFactory getDaoSingletonFactory(){
        if(instance == null){
            if(System.getProperty("persistence").equals("DEMO")){
                instance = new DemoDaoFactory();
            }

            if(System.getProperty("persistence").equals("JDBC")){
                instance = new DbmsDaoFactory();
            }

            if(System.getProperty("persistence").equals("FILE")){
                instance = new FileDaoFactory();
            }
        }
        return instance;
    }
}
