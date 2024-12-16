package bean;

public class DogBreedBean {
    private String name;
    private float good_with_other_dogs;
    private float shedding;
    private float grooming;
    private float drooling;
    private float coat_length;
    private float good_with_children;
    private float good_with_strangers;
    private float playfulness;
    private float protectiveness;
    private float trainability;
    private float energy;
    private float barking;
    private float max_life_expectancy;
    private float max_height_male;

    public DogBreedBean(String name,
                        float good_with_other_dogs,
                        float shedding,
                        float grooming,
                        float drooling,
                        float coat_length,
                        float good_with_children,
                        float good_with_strangers,
                        float playfulness,
                        float protectiveness,
                        float trainability,
                        float energy,
                        float barking,
                        float max_life_expectancy,
                        float max_height_male)
    {
        this.name = name;
        this.good_with_other_dogs = good_with_other_dogs;
        this.shedding = shedding;
        this.grooming = grooming;
        this.drooling = drooling;
        this.coat_length = coat_length;
        this.good_with_children = good_with_children;
        this.good_with_strangers = good_with_strangers;
        this.playfulness = playfulness;
        this.protectiveness = protectiveness;
        this.trainability = trainability;
        this.energy = energy;
        this.barking = barking;
        this.max_life_expectancy = max_life_expectancy;
        this.max_height_male = max_height_male;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGood_with_other_dogs() {
        return this.good_with_other_dogs;
    }

    public void setGood_with_other_dogs(float good_with_other_dogs) {
        this.good_with_other_dogs = good_with_other_dogs;
    }

    public float getShedding() {
        return this.shedding;
    }

    public void setShedding(float shedding) {
        this.shedding = shedding;
    }

    public float getGrooming() {
        return this.grooming;
    }

    public void setGrooming(float grooming) {
        this.grooming = grooming;
    }

    public float getDrooling() {
        return this.drooling;
    }

    public void setDrooling(float drooling) {
        this.drooling = drooling;
    }

    public float getCoat_length() {
        return this.coat_length;
    }

    public void setCoat_length(float coat_length) {
        this.coat_length = coat_length;
    }

    public float getGood_with_children() {
        return this.good_with_children;
    }

    public void setGood_with_children(float good_with_children) {
        this.good_with_children = good_with_children;
    }

    public float getGood_with_strangers() {
        return this.good_with_strangers;
    }

    public void setGood_with_strangers(float good_with_strangers) {
        this.good_with_strangers = good_with_strangers;
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

    public float getTrainability() {
        return this.trainability;
    }

    public void setTrainability(float trainability) {
        this.trainability = trainability;
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

    public float getMax_life_expectancy() {
        return this.max_life_expectancy;
    }

    public void setMax_life_expectancy(float max_life_expectancy) {
        this.max_life_expectancy = max_life_expectancy;
    }

    public float getMax_height_male() {
        return this.max_height_male;
    }

    public void setMax_height_male(float max_height_male) {
        this.max_height_male = max_height_male;
    }
}
