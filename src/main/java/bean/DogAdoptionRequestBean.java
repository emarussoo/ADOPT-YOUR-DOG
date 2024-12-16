package bean;

public class DogAdoptionRequestBean {
    private String user_firstname;
    private String user_lastname;
    private String user_email;
    private String user_phone;
    private int dog_id;

    public DogAdoptionRequestBean(String user_firstname, String user_lastname, String user_email, String user_phone, int dog_id) {
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.dog_id = dog_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
