package model.dogadoptionrequest;
import model.dog.Dog;
import model.kennel.Kennel;

public class DogAdoptionRequest {
    private int darId;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPhone;
    private Kennel kennel;
    private Dog dog;

    public DogAdoptionRequest(int darId, String userFirstname, String userLastname, String userEmail, String userPhone, Dog dog, Kennel kennel) {
        this.darId = darId;
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dog = dog;
        this.kennel = kennel;
    }

    public DogAdoptionRequest(String userFirstname, String userLastname, String userEmail, String userPhone, Dog dog, Kennel kennel) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dog = dog;
        this.kennel = kennel;
    }

    public int getDarId() {
        return darId;
    }

    public void setDarId(int darId) {
        this.darId = darId;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Kennel getKennel() {
        return kennel;
    }

    public void setKennel(Kennel kennel) {
        this.kennel = kennel;
    }

    @Override
    public String toString() {
        return "userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", dogId=" + dog.getDogId();
    }
}
