package utils;

//this enum contains the test questions and associated api paramete
public enum TestQuestions {
    DOMANDA_1("How often do you meet other dogs during outdoor walks?", "good_with_other_dogs"),
    DOMANDA_2("Choose the minimum coat length (1 short, 5 long)", "coat_length"),
    DOMANDA_3("How often do you invite guests at home?", "good_with_strangers"),
    DOMANDA_4("How playful do you want your dog to be (minimum)?", "playfulness"),
    DOMANDA_5("How energetic do you want your dog to be (minimum)?", "energy"),
    DOMANDA_6("How much do you want the dog to bark?", "barking");

    private final String testo;
    private final String apiValue;


    TestQuestions(String testo, String apiValue) {
        this.testo = testo;
        this.apiValue = apiValue;
    }


    public String getTesto() {
        return testo;
    }

    public String getApiValue(){
        return apiValue;
    }
}
