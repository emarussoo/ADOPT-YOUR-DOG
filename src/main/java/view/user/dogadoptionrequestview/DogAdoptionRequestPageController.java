package view.user.dogadoptionrequestview;

import bean.DogProfileBean;
import exceptions.InvalidFieldException;

import java.util.List;

public abstract class DogAdoptionRequestPageController {
    public abstract void createDogAdoptionRequest(DogProfileBean dogProfileBean);
    public abstract List<String> getUserInfo();
    public abstract void createMessage(String message);
    public void validatePhoneNumber(String phoneNumber) {
        try{
            Integer.parseInt(phoneNumber);
        }catch(NumberFormatException e){
            throw new InvalidFieldException("Insert a valid phone number");
        }
    }
}
