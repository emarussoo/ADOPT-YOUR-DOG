package bean;

public class DogProfileBean {
    private int dog_id;
    private String dog_name;
    private int dog_age;
    private String dog_breed;

    public DogProfileBean(int dog_id, String dog_name, int dog_age, String dog_breed) {
        this.dog_id = dog_id;
        this.dog_name = dog_name;
        this.dog_age = dog_age;
        this.dog_breed = dog_breed;
    }

    public int getDog_id() {
        return dog_id;
    }

    public void setDog_id(int dog_id) {
        this.dog_id = dog_id;
    }

    public String getDog_name() {
        return dog_name;
    }

    public void setDog_name(String dog_name) {
        this.dog_name = dog_name;
    }

    public int getDog_age() {
        return dog_age;
    }

    public void setDog_age(int dog_age) {
        this.dog_age = dog_age;
    }

    public String getDog_breed() {
        return dog_breed;
    }

    public void setDog_breed(String dog_breed) {
        this.dog_breed = dog_breed;
    }
}
