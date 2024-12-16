package bean;

public class DogBreedBean {
    private String name;
    private float coatLength; //lunghezza pelliccia
    private float playfulness;
    private float protectiveness;
    private float energy;
    private float barking;
    private float maxHeightMale;

    public DogBreedBean(String name,
                        float coatLength,
                        float playfulness,
                        float protectiveness,
                        float energy,
                        float barking,
                        float maxHeightMale)
    {
        this.name = name;
        this.coatLength = coatLength;
        this.playfulness = playfulness;
        this.protectiveness = protectiveness;
        this.energy = energy;
        this.barking = barking;
        this.maxHeightMale = maxHeightMale;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoatLength() {
        return this.coatLength;
    }

    public void setCoatLength(float coatLength) {
        this.coatLength = coatLength;
    }

    public float getPlayfulness() {
        return this.playfulness;
    }

    public void setPlayfulness(float playfulness) {
        this.playfulness = playfulness;
    }

    public float getProtectiveness() {
        return this.protectiveness;
    }

    public void setProtectiveness(float protectiveness) {
        this.protectiveness = protectiveness;
    }

    public float getEnergy() {
        return this.energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getBarking() {
        return this.barking;
    }

    public void setBarking(float barking) {
        this.barking = barking;
    }

    public float getMaxHeightMale() {
        return this.maxHeightMale;
    }

    public void setMaxHeightMale(float maxHeightMale) {
        this.maxHeightMale = maxHeightMale;
    }
}
