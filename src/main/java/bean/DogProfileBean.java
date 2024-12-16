package bean;

import baseclasses.DogBase;

public class DogProfileBean extends DogBase {
    public DogProfileBean(int dogId, String dogName, int dogAge, String dogBreed) {
        super(dogId, dogName, dogAge, dogBreed);
    }
}
