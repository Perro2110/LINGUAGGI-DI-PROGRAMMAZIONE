import java.util.ArrayList;
import java.util.List;

public class Giocatore {
    int codice;
    List <Partita>partiteGiocate=new ArrayList<Partita>();
    
    public List<Partita> getPartiteGiocate() {
        return partiteGiocate;
    }

    public int getCodice() {
        return codice;
    }

    String tipo;
    String nome_e_cognome;

    public String getNome_e_cognome() {
        return nome_e_cognome;
    }

    public Giocatore(int codice, String tipo, String nome_e_cognome) {
        this.codice = codice;
        this.tipo = tipo;
        this.nome_e_cognome = nome_e_cognome;
        partiteGiocate=new ArrayList<Partita>();
    }

}
