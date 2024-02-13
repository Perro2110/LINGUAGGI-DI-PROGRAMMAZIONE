public class Stampante extends Prodotto{
    int peso;

    public Stampante(String tipo, int codice, String modello, String produttore, String data, int prezzo, int peso) {
        super(tipo, codice, modello, produttore, data, prezzo);
        this.peso = peso;
    }
    @Override
    public String toString() {
        return tipo+codice+modello+produttore+data+prezzo+" "+peso;
    }
}
