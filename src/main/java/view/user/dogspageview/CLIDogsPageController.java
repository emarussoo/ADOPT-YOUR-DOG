package view.user.dogspageview;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.dogadoptionrequestview.CLIDogAdoptionRequestController;
import view.user.windowmanager.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CLIDogsPageController extends DogsPageController{
    private static final Logger logger = LogManager.getLogger(CLIDogsPageController.class.getName());

    public void createListOfDogs(List<DogProfileBean> listOfDogs){
        for(DogProfileBean dog : listOfDogs){
            logger.info(dog.getDogId() + ", "+ dog.getDogName()+", "+dog.getDogAge()+", "+dog.getDogBreed());
        }
    }

    public void submitSearch(List<DogProfileBean> listOfDogs){
        WindowManager.getSingletonInstance().submitSearch(listOfDogs);
    }

    public String getInsertedBreed(){
        String insertedBreed;
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("=====================Inserisci razza da cercare=====================");
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
        logger.info("=====================Inserisci l'id del cane a cui vorresti mandare la richiesta di adozione=====================");
        try {
            insertedId = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return WindowManager.getSingletonInstance().getPresenter().getDogById(insertedId);
    }
}
