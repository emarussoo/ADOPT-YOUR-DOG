package model.kennel;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import java.util.ArrayList;
import java.util.List;

public class Kennel {
    private int kennelId;
    private String kennelName;
    private List<DogAdoptionRequest> kennelRequests = new ArrayList<>();
    private List<Dog> kennelDogs = new ArrayList<>();

    public Kennel(int kennelId, String kennelName) {
        this.kennelId = kennelId;
        this.kennelName = kennelName;
    }

    public Kennel(String kennelName) {
        this.kennelName = kennelName;
    }

    public Kennel(){}

    public int getKennelId() {
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }

    public String getKennelName() {
        return kennelName;
    }

    public void setKennelName(String kennelName) {
        this.kennelName = kennelName;
    }

    public List<DogAdoptionRequest> getKennelRequests() {
        return kennelRequests;
    }

    public void setKennelRequests(List<DogAdoptionRequest> kennelRequests) {
        this.kennelRequests = kennelRequests;
    }

    public List<Dog> getKennelDogs() {
        return kennelDogs;
    }

    public void setKennelDogs(List<Dog> kennelDogs) {
        this.kennelDogs = kennelDogs;
    }

    public void addDog(Dog dog) {
        this.kennelDogs.add(dog);
    }

    public void addRequest(DogAdoptionRequest request) {
        this.kennelRequests.add(request);
    }
}
