package presenter;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.kennel.Kennel;

public class ManageDogsController {
    public ManageDogsController() {
        //costruttore
    }

    public void removeDogByDar(DogAdoptionRequestBean dogAdoptionRequestBean){
        int dogId = Integer.parseInt(dogAdoptionRequestBean.getDogIdBean());
        DaoFactory.getDaoSingletonFactory().createDogDao().removeDogById(dogId);
    }

    public void addDog(DogProfileBean dogProfileBean){
        String dogName = dogProfileBean.getDogName();
        int dogAge = Integer.parseInt(dogProfileBean.getDogAge());
        String dogBreed = dogProfileBean.getDogBreed();
        int kennelId = Integer.parseInt(dogProfileBean.getKennelId());
        Kennel kennel = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(kennelId);

        Dog toAddDog = new Dog(dogName, dogAge, dogBreed, kennel);

        DaoFactory.getDaoSingletonFactory().createDogDao().add(toAddDog);
    }

}
