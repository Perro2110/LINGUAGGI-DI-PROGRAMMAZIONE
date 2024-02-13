/*
 * Classe contenente i vari utenti
 */
import java.util.ArrayList;
import java.util.List;

public class Utente {
    int codice;
    String nome_e_cognome;
    int eta;
    int categoria;

    List <Prenotazione> prenotazioni = new ArrayList<Prenotazione>(); //presumendo di usare i campi piu spesso che di inserirne per quanto anche con una hashMapp per l'ultimo es non sarebbe stato male


    public Utente(int codice, String nome_e_cognome, int eta, int categoria) {
        this.codice = codice;
        this.nome_e_cognome = nome_e_cognome;
        this.eta = eta;
        this.categoria = categoria;
        this.prenotazioni = new ArrayList<Prenotazione>();
    }
    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public String getNome_e_cognome() {
        return nome_e_cognome;
    }
    public void setNome_e_cognome(String nome_e_cognome) {
        this.nome_e_cognome = nome_e_cognome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public String toString(){
        return codice+" "+nome_e_cognome+" "+eta+" "+categoria+" "+prenotazioni.toString();
    }
}
