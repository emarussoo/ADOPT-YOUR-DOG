package utils;

public enum TestQuestions {
    DOMANDA_1("Quanto vuoi che il tuo cane sia buono con i bambini?", "good_with_children"),
    DOMANDA_2("Quanto vuoi che sia buono con gli altri cani?", "good_with_other_dogs"),
    DOMANDA_3("Scegli la lunghezza del pelo (1 molto corto, 5 molto lungo)", "coat_length"),
    DOMANDA_4("Quanto vuoi che sia buono con gli ospiti?", "good_with_strangers"),
    DOMANDA_5("Quanto vuoi che sia giocherellone?", "playfulness"),
    DOMANDA_6("Quanto vuoi che sia energico?", "energy"),
    DOMANDA_7("Quanto vuoi che abbai?", "barking"),
    DOMANDA_8("Di che taglia vorresti il tuo cane?", "max_height_male");

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
