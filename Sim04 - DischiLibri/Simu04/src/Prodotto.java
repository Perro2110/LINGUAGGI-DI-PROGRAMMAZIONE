public class Prodotto {
    String tipo;
    int codice;
    String titolo;
    String autore;
    int prezzo;
    public int getPrezzo() {
        return prezzo;
    }
    public Prodotto(String tipo, int codice, String titolo, String autore, int prezzo) {
        this.tipo = tipo;
        this.codice = codice;
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }
}
