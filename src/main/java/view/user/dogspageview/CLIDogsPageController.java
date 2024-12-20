package view.user.dogspageview;

import bean.DogProfileBean;

import java.util.List;

public class CLIDogsPageController extends DogsPageController{
    public void getAllDogs(){};

    public void createListOfDogs(List<DogProfileBean> listOfDogs){
        for(DogProfileBean dog : listOfDogs){
            System.out.println(dog.getDogId() + ", "+ dog.getDogName()+", "+dog.getDogAge()+", "+dog.getDogBreed());
        }
    };
}
