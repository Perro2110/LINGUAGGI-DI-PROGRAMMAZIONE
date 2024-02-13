public class Giocatore {
    int codice_squadra;
    public int getCodice_squadra() {
        return codice_squadra;
    }
    String cognome;
    String nome;
    int eta;
    int numero_maglia;
    String ruolo;
    Boolean titolare;

    public Giocatore(int codice_squadra, String cognome, String nome, int eta, int numero_maglia, String ruolo,
            Boolean titolare) {
        this.codice_squadra = codice_squadra;
        this.cognome = cognome;
        this.nome = nome;
        this.eta = eta;
        this.numero_maglia = numero_maglia;
        this.ruolo = ruolo;
        this.titolare = titolare;
    }
    @Override
    public String toString() {
        return nome+"\t"+cognome+"\t"+eta+"\t"+numero_maglia+"\t"+ruolo+"\t"+titolare+"\t";
    }
}
