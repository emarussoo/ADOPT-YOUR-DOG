package baseclasses;

public class BreedBase {
    String imageLink;
    private String name;
    private String coatLength; //lunghezza pelliccia
    private String playfulness;
    private String energy;
    private String barking;
    private String maxHeightMale;

    public BreedBase(String imageLink,
                     String name,
                     String coatLength,
                     String playfulness,
                     String energy,
                     String barking)
    {
        this.imageLink = imageLink;
        this.name = name;
        this.coatLength = coatLength;
        this.playfulness = playfulness;
        this.energy = energy;
        this.barking = barking;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoatLength() {
        return this.coatLength;
    }

    public void setCoatLength(String coatLength) {
        this.coatLength = coatLength;
    }

    public String getPlayfulness() {
        return this.playfulness;
    }

    public void setPlayfulness(String playfulness) {
        this.playfulness = playfulness;
    }

    public String getEnergy() {
        return this.energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getBarking() {
        return this.barking;
    }

    public void setBarking(String barking) {
        this.barking = barking;
    }
}
