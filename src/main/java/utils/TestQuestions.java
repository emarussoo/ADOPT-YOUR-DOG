package utils;

public enum TestQuestions {
    DOMANDA_1("How often do you meet other dogs during outdoor walks?", "good_with_other_dogs"),
    DOMANDA_2("Choose the minimum coat length (1 short, 5 long)", "coat_length"),
    DOMANDA_3("How often do you invite guests at home?", "good_with_strangers"),
    DOMANDA_4("How playful do you want your dog to be (minimum)?", "playfulness"),
    DOMANDA_5("How energetic do you want your dog to be (minimum)?", "energy"),
    DOMANDA_6("How much do you want the dog to bark?", "barking");

    private final String testo;
    private final String apiValue;

    // Costruttore per l'enum
    TestQuestions(String testo, String apiValue) {
        this.testo = testo;
        this.apiValue = apiValue;
    }

    // Getter per il testo della domanda
    public String getTesto() {
        return testo;
    }

    public String getApiValue(){
        return apiValue;
    }
}
