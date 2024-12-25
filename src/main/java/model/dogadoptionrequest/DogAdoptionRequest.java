package model.dogadoptionrequest;

public class DogAdoptionRequest {
    private int darId;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPhone;
    private int dogId;
    private int kennelId;

    public DogAdoptionRequest(int darId, String userFirstname, String userLastname, String userEmail, String userPhone, int dogId, int kennelId) {
        this.darId = darId;
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dogId = dogId;
        this.kennelId = kennelId;
    }

    public DogAdoptionRequest(String userFirstname, String userLastname, String userEmail, String userPhone, int dogId, int kennelId) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dogId = dogId;
        this.kennelId = kennelId;
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

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public int getKennelId() {
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }

    @Override
    public String toString() {
        return "userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", dogId=" + dogId +
                ", kennelId=" + kennelId;
    }
}
