package view;

public enum TestQuestions {
    DOMANDA_1("Hai dei bambini in casa?"),
    DOMANDA_2("Durante le tue passeggiate quotidiane, quanto spesso incontri altri cani?"),
    DOMANDA_3("Quanto sei disposto a toelettare il tuo cane?"),
    DOMANDA_4("Scegli la lunghezza del pelo (1 molto corto, 5 molto lungo)"),
    DOMANDA_5("Quanto spesso inviti ospiti a casa?"),
    DOMANDA_6("Quanto tempo hai per giocare con il tuo cane?"),
    DOMANDA_7("Quanto necessiti che il cane sia protettivo nei confronti del tuo territorio?"),
    DOMANDA_8("Quanto vuoi che il tuo cane sia addomesticabile?"),
    DOMANDA_9("Quanto spesso sei disposto a portare fuori a passeggiare il cane?"),
    DOMANDA_10("Quanto i tuoi vicini influiscono sul tuo stile di vita?"),
    DOMANDA_11("Quanto è grande la tua abitazione/giardino?");

    private final String testo; // Testo della domanda

    // Costruttore per l'enum
    TestQuestions(String testo) {
        this.testo = testo;
    }

    // Getter per il testo della domanda
    public String getTesto() {
        return testo;
    }
}
