public class Libro extends Prodotto  {
    String ISBN;

    public Libro(String tipo, int codice, String titolo, String autore, int prezzo, String iSBN) {
        super(tipo, codice, titolo, autore, prezzo);
        ISBN = iSBN;
    }
    public String toString(){
        return tipo +" "+ codice+" "+ titolo+" "+ autore+ " " + prezzo+ " " + ISBN + " - ";
    }
}
