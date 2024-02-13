public class Partecipo {
    int codice;
    String cognome;
    int spese_di_iscrizioni;

    public Partecipo(int codice, int spese_di_iscrizioni) {
        this.codice = codice;
        this.spese_di_iscrizioni = spese_di_iscrizioni;
        this.cognome = "";
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getCodice() {
        return codice;
    }

    public int getSpese_di_iscrizioni() {
        return spese_di_iscrizioni;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setSpese_di_iscrizioni(int spese_di_iscrizioni) {
        this.spese_di_iscrizioni = spese_di_iscrizioni;
    }

    @Override
    public String toString() {
        return "(" + cognome + " " + spese_di_iscrizioni + ")";
    }
}
