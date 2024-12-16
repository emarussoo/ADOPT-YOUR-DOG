package model.dogadoptionrequest;

import baseclasses.DogAdoptionRequestBase;

public class DogAdoptionRequest extends DogAdoptionRequestBase {
    public DogAdoptionRequest(String userFirstname, String userLastname, String userEmail, String userPhone, int dogId) {
        super(userFirstname, userLastname, userEmail, userPhone, dogId);
    }
}
