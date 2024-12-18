package utils;

public enum TestQuestions {
    DOMANDA_1("Quanto spesso incontri altri cani durante le tue passeggiate?", "good_with_other_dogs"),
    DOMANDA_2("Scegli la lunghezza del pelo minima (1 molto corto, 5 molto lungo)", "coat_length"),
    DOMANDA_3("Quanto spesso inviti ospiti a casa?", "good_with_strangers"),
    DOMANDA_4("Quanto vuoi che sia giocherellone (inserisci il valore minimo)?", "playfulness"),
    DOMANDA_5("Quanto vorresti che il tuo cane fosse energico (inserisci il valore minimo)?", "energy"),
    DOMANDA_6("Quanto vuoi che abbai?", "barking");
    //DOMANDA_7("Quanto vorresti grande il tuo cane (inserisci il valore minimo)?", "max_height_male");

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
