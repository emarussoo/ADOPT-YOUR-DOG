package presenter;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.kennel.Kennel;

import java.util.ArrayList;
import java.util.List;

public class ManageDogsController {
    public ManageDogsController() {
        //costruttore
    }

    /*public List<DogProfileBean> getDogsWithKennelId(int kennelId){
        List<Dog> listOfAllDogs;
        List<DogProfileBean> filteredDogsList = new ArrayList<>();
        listOfAllDogs = DaoFactory.getDaoSingletonFactory().createDogDao().getAllDogs();
        for(Dog dog : listOfAllDogs){
            if(dog.getKennelId() == kennelId){
                String dogIdBean = Integer.toString(dog.getDogId());
                String dogNameBean = dog.getDogName();
                String dogAgeBean = Integer.toString(dog.getDogAge());
                String dogBreedBean = dog.getDogBreed();
                String kennelIdBean = Integer.toString(dog.getKennelId());
                String kennelNameBean = DaoFactory.getDaoSingletonFactory().createKennelDao().getKennelById(dog.getKennelId()).getKennelName();
                filteredDogsList.add(new DogProfileBean(dogIdBean, dogNameBean, dogAgeBean, dogBreedBean, kennelIdBean, kennelNameBean));
            }
        }
        return filteredDogsList;
    }*/

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
