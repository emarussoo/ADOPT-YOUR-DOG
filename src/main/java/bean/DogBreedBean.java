package bean;

public class DogBreedBean {
    private String name;
    private float coat_length; //lunghezza pelliccia
    private float playfulness;
    private float protectiveness;
    private float energy;
    private float barking;
    private float max_height_male;

    public DogBreedBean(String name,
                        float coat_length,
                        float playfulness,
                        float protectiveness,
                        float energy,
                        float barking,
                        float max_height_male)
    {
        this.name = name;
        this.coat_length = coat_length;
        this.playfulness = playfulness;
        this.protectiveness = protectiveness;
        this.energy = energy;
        this.barking = barking;
        this.max_height_male = max_height_male;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoat_length() {
        return this.coat_length;
    }

    public void setCoat_length(float coat_length) {
        this.coat_length = coat_length;
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

    public float getMax_height_male() {
        return this.max_height_male;
    }

    public void setMax_height_male(float max_height_male) {
        this.max_height_male = max_height_male;
    }
}
