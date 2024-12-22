package bean;

public class DogAdoptionRequestBean{

    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPhone;
    private String dogId;
    private String kennelId;

    public DogAdoptionRequestBean(String userFirstname, String userLastname, String userEmail, String userPhone, String dogId, String kennelId) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dogId = dogId;
        this.kennelId = kennelId;
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

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getKennelId() {
        return kennelId;
    }

    public void setKennelId(String kennelId) {
        this.kennelId = kennelId;
    }
}
