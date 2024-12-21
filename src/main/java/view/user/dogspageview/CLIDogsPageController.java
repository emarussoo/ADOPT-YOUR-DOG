package view.user.dogspageview;

import bean.DogProfileBean;
import view.user.windowmanager.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CLIDogsPageController extends DogsPageController{

    public void createListOfDogs(List<DogProfileBean> listOfDogs){
        for(DogProfileBean dog : listOfDogs){
            System.out.println(dog.getDogId() + ", "+ dog.getDogName()+", "+dog.getDogAge()+", "+dog.getDogBreed());
        }
    }

    public void submitSearch(List<DogProfileBean> listOfDogs){
        WindowManager.getSingletonInstance().submitSearch(listOfDogs);
    }

    public String getInsertedBreed(){
        String insertedBreed;
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println("=====================Inserisci razza da cercare=====================");
        try {
            insertedBreed = reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
        return insertedBreed;
    }

    public DogProfileBean getDogInfo(){
        int insertedId;
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println("=====================Inserisci l'id del cane a cui vorresti mandare la richiesta di adozione=====================");
        try {
            insertedId = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return WindowManager.getSingletonInstance().getPresenter().getDogById(insertedId);
    }
}
