package view.user.dogadoptionrequestview;

import bean.DogProfileBean;
import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLIDogAdoptionRequestPageController extends DogAdoptionRequestPageController {
    private static final Logger logger = LogManager.getLogger(CLIDogAdoptionRequestPageController.class.getName());

    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        logger.info("You are sending a dog adoption request to {} about {} of breed {}, {} years old", dogProfileBean.getKennelName(), dogProfileBean.getDogName(), dogProfileBean.getDogBreed(), dogProfileBean.getDogAge());
    }

    public List<String> getUserInfo(){
        List<String> userInfo = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        try{
            logger.info("Insert your personal data");
            logger.info("Name: ");
            String name = reader.readLine();
            userInfo.add(name);
            logger.info("Surname: ");
            String surname = reader.readLine();
            userInfo.add(surname);
            logger.info("Email: ");
            String email = reader.readLine();
            userInfo.add(email);
            logger.info("Phone number: ");
            String phone = reader.readLine();
            validatePhoneNumber(phone);
            userInfo.add(phone);
        }catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return userInfo;
    }

    public void createMessage(String message){
        logger.info(message);
    }
}
