import java.util.ArrayList;
import java.util.List;

public class Prodotto {
    String tipo;
    int codice;

    public int getCodice() {
        return codice;
    }

    String modello;

    public String getModello() {
        return modello;
    }

    String produttore;
    String data;
    int prezzo;
    List<Integer> numeroPezzi = new ArrayList<Integer>();

    public Prodotto(String tipo, int codice, String modello, String produttore, String data, int prezzo) {
        this.tipo = tipo;
        this.codice = codice;
        this.modello = modello;
        this.produttore = produttore;
        this.data = data;
        this.prezzo = prezzo;
        this.numeroPezzi = new ArrayList<Integer>();
    }

    public List<Integer> getNumeroPezzi() {
        return numeroPezzi;
    }
}
