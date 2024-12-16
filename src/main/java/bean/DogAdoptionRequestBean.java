package bean;

import baseclasses.DogAdoptionRequestBase;

public class DogAdoptionRequestBean extends DogAdoptionRequestBase {

    public DogAdoptionRequestBean(String userFirstname, String userLastname, String userEmail, String userPhone, int dogId) {
        super(userFirstname, userLastname, userEmail, userPhone, dogId);
    }
}
