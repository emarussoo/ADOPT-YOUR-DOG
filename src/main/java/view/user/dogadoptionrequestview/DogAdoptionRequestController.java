package view.user.dogadoptionrequestview;

import bean.DogProfileBean;

import java.util.List;

public abstract class DogAdoptionRequestController {
    public abstract void createDogAdoptionRequest(DogProfileBean dogProfileBean);
    public abstract List<String> getUserInfo();
    public abstract void createMessage(String message);
}
