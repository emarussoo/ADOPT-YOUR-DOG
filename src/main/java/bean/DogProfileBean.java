package bean;

public class DogProfileBean{
    private String dogId;
    private String dogName;
    private String dogAge;
    private String dogBreed;
    private String kennelName;
    private String kennelId;

    public DogProfileBean(String dogId, String dogName, String dogAge, String dogBreed, String kennelName, String kennelId) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.kennelName = kennelName;
        this.kennelId = kennelId;
    }

    public DogProfileBean(String dogId, String dogName, String dogAge, String dogBreed, String kennelId) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.kennelId = kennelId;
    }

    public DogProfileBean(String dogName, String dogAge, String dogBreed, String kennelId) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.kennelId = kennelId;
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

    public String getKennelName() {
        return kennelName;
    }

    public void setKennelName(String kennelName) {
        this.kennelName = kennelName;
    }

    public String getKennelId() {
        return kennelId;
    }

    public void setKennelId(String kennelId) {
        this.kennelId = kennelId;
    }

    public String toString() {
        return String.format("%-25s %-32s %-25s %-30s %-25s", getDogId(), getDogName(), getDogAge(), getDogBreed(), getKennelName());
    }

    public String kennelString(){
        return String.format("%-32s %-35s %-35s %-35s", getDogId(), getDogName(), getDogAge(), getDogBreed());
    }
}
