package model.dog;

import model.kennel.Kennel;

public class Dog{

    private int dogId;
    private String dogName;
    private int dogAge;
    private String dogBreed;
    private Kennel kennel;

    public Dog(String dogName, int dogAge, String dogBreed, Kennel kennel) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.kennel = kennel;
    }

    public Dog(int dogId, String dogName, int dogAge, String dogBreed, Kennel kennel) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogBreed = dogBreed;
        this.kennel = kennel;
    }

    public Dog(){}

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public Kennel getKennel() {
        return kennel;
    }

    public void setKennelId(Kennel kennel) {
        this.kennel = kennel;
    }
}
