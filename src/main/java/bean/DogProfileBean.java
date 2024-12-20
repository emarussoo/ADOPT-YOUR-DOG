package bean;

import baseclasses.DogBase;

public class DogProfileBean{
    private String dogId;
    private String dogName;
    private String dogAge;
    private String dogBreed;

    public DogProfileBean(String dogId, String dogName, String dogAge, String dogBreed) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogAge() {
        return dogAge;
    }

    public void setDogAge(String dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }
}
