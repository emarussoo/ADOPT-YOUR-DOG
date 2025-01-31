package bean;


public class DogAdoptionRequestBean{

    private String darIdBean;
    private String userFirstnameBean;
    private String userLastnameBean;
    private String userEmailBean;
    private String userPhoneBean;
    private String dogIdBean;
    private String kennelIdBean;

    public DogAdoptionRequestBean(String darIdBean, String userFirstnameBean, String userLastnameBean, String userEmailBean, String userPhoneBean, String dogIdBean, String kennelIdBean) {
        this.darIdBean = darIdBean;
        this.userFirstnameBean = userFirstnameBean;
        this.userLastnameBean = userLastnameBean;
        this.userEmailBean = userEmailBean;
        this.userPhoneBean = userPhoneBean;
        this.dogIdBean = dogIdBean;
        this.kennelIdBean = kennelIdBean;
    }

    public DogAdoptionRequestBean(String userFirstnameBean, String userLastnameBean, String userEmailBean, String userPhoneBean, String dogIdBean, String kennelIdBean) {
        this.userFirstnameBean = userFirstnameBean;
        this.userLastnameBean = userLastnameBean;
        this.userEmailBean = userEmailBean;
        this.userPhoneBean = userPhoneBean;
        this.dogIdBean = dogIdBean;
        this.kennelIdBean = kennelIdBean;
    }

    public String getDarIdBean() {
        return darIdBean;
    }

    public void setDarIdBean(String darIdBean) {
        this.darIdBean = darIdBean;
    }

    public String getUserFirstnameBean() {
        return userFirstnameBean;
    }

    public void setUserFirstnameBean(String userFirstnameBean) {
        this.userFirstnameBean = userFirstnameBean;
    }

    public String getUserLastnameBean() {
        return userLastnameBean;
    }

    public void setUserLastnameBean(String userLastnameBean) {
        this.userLastnameBean = userLastnameBean;
    }

    public String getUserEmailBean() {
        return userEmailBean;
    }

    public void setUserEmailBean(String userEmailBean) {
        this.userEmailBean = userEmailBean;
    }

    public String getUserPhoneBean() {
        return userPhoneBean;
    }

    public void setUserPhoneBean(String userPhoneBean) {
        this.userPhoneBean = userPhoneBean;
    }

    public String getDogIdBean() {
        return dogIdBean;
    }

    public void setDogIdBean(String dogIdBean) {
        this.dogIdBean = dogIdBean;
    }

    public String getKennelIdBean() {
        return kennelIdBean;
    }

    public void setKennelIdBean(String kennelIdBean) {
        this.kennelIdBean = kennelIdBean;
    }

    @Override
    public String toString(){
        return String.format("%-25s %-25s %-25s %-45s %-30s %-25s", getDarIdBean(), getUserFirstnameBean(), getUserLastnameBean(), getUserEmailBean(), getUserPhoneBean(), getDogIdBean());
    }
}
