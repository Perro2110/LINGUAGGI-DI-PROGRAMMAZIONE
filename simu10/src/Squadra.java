import java.util.ArrayList;
import java.util.List;

public class Squadra {
    String nome_della_squadra;
    public String getNome_della_squadra() {
        return nome_della_squadra;
    }

    int codice;
    public int getCodice() {
        return codice;
    }

    String sport;
    int numero_partite_vinte;
    int numero_partite_perse;
    List<Giocatore> giocatori = new ArrayList<Giocatore>();

    public Squadra(String nome_della_squadra, int codice, String sport, int numero_partite_vinte,
            int numero_partite_perse) {
        this.nome_della_squadra = nome_della_squadra;
        this.codice = codice;
        this.sport = sport;
        this.numero_partite_vinte = numero_partite_vinte;
        this.numero_partite_perse = numero_partite_perse;
        this.giocatori = new ArrayList<Giocatore>();
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

}
