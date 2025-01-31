package view.user.dogspageview;
import bean.DogProfileBean;
import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.windowmanager.UserWindowManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CLIDogsPageController extends DogsPageController{
    private static final Logger logger = LogManager.getLogger(CLIDogsPageController.class.getName());

    public void createListOfDogs(List<DogProfileBean> listOfDogs){
        for(DogProfileBean dog : listOfDogs){
            logger.info("{}, {}, {}, {}", dog.getDogId(), dog.getDogName(), dog.getDogAge(), dog.getDogBreed());
        }
    }

    public String getInsertedBreed() throws GenericSystemException{
        String insertedBreed;
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Insert the breed to search");
        try {
            insertedBreed = reader.readLine();
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return insertedBreed;
    }

    public DogProfileBean getDogInfo() throws GenericSystemException{
        int insertedId;
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Insert the id of the dog you want to adopt");
        try {
            insertedId = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return UserWindowManager.getSingletonInstance().getPresenter().getDogById(insertedId);
    }
}
