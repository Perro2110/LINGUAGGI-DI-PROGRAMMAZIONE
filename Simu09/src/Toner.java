public class Toner extends Prodotto {
    String modello_stampante;

    public Toner(String tipo, int codice, String modello, String produttore, String data, int prezzo, String modello2) {
        super(tipo, codice, modello, produttore, data, prezzo);
        modello_stampante = modello2;
    }
    @Override
    public String toString() {
        return tipo+codice+modello+produttore+data+prezzo+modello_stampante+" ";
    }
}
