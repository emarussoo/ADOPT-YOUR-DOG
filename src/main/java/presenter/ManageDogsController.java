package presenter;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dog.dao.DogDao;

import java.util.ArrayList;
import java.util.List;

public class ManageDogsController {
    public ManageDogsController() {
        //costruttore
    }

    public List<DogProfileBean> getDogsWithKennelId(int kennelId){
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
    }

    public int getCurrentDogId(){
        return DaoFactory.getDaoSingletonFactory().createDogDao().getCurrentId();
    }

    public void removeDogByDar(DogAdoptionRequestBean dogAdoptionRequestBean){
        int dogId = Integer.parseInt(dogAdoptionRequestBean.getDogId());
        DaoFactory.getDaoSingletonFactory().createDogDao().removeDogById(dogId);
    }

    public void addDog(DogProfileBean dogProfileBean){
        int dogId = Integer.parseInt(dogProfileBean.getDogId());
        String dogName = dogProfileBean.getDogName();
        int dogAge = Integer.parseInt(dogProfileBean.getDogAge());
        String dogBreed = dogProfileBean.getDogBreed();
        int kennelId = Integer.parseInt(dogProfileBean.getKennelId());

        Dog toAddDog = new Dog(dogId, dogName, dogAge, dogBreed, kennelId);

        DaoFactory.getDaoSingletonFactory().createDogDao().add(toAddDog);
    }

}
