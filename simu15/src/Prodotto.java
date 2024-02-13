public class Prodotto {
    String descrizione;
    int quantita;
    int prezzo;

    public Prodotto(String descrizione, int quantita, int prezzo) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }
    @Override
    public String toString() {
        return "\t"+descrizione+"\t"+quantita+"\t"+(quantita*prezzo);
    }
}
