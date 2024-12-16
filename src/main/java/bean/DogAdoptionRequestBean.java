package bean;

public class DogAdoptionRequestBean {
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPhone;
    private int dogId;

    public DogAdoptionRequestBean(String userFirstname, String userLastname, String userEmail, String userPhone, int dogId) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.dogId = dogId;
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
}
