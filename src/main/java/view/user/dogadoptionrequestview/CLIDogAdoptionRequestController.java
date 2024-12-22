package view.user.dogadoptionrequestview;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CLIDogAdoptionRequestController extends DogAdoptionRequestController{
    private static final Logger logger = LogManager.getLogger(CLIDogAdoptionRequestController.class.getName());

    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        logger.info("Stai mandando una richiesta di adozione al canile {} per {} di razza {} di età {} anni", dogProfileBean.getKennelName(), dogProfileBean.getDogName(), dogProfileBean.getDogBreed(), dogProfileBean.getDogAge());
    }

    public List<String> getUserInfo(){
        List<String> userInfo = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        try{
            logger.info("Inserisci i tuoi dati personali");
            logger.info("Nome: ");
            String name = reader.readLine();
            userInfo.add(name);
            logger.info("Cognome: ");
            String surname = reader.readLine();
            userInfo.add(surname);
            logger.info("Email: ");
            String email = reader.readLine();
            userInfo.add(email);
            logger.info("Telefono: ");
            String phone = reader.readLine();
            userInfo.add(phone);
        }catch (Exception e){
            throw new IllegalStateException();
        }
        return userInfo;
    }

    public void createMessage(String message){
        logger.info(message);
    }
}
