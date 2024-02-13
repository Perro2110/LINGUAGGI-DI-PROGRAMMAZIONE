public class Cd extends Prodotto {
    int Durata;

    public Cd(String tipo, int codice, String titolo, String autore, int prezzo, int durata) {
        super(tipo, codice, titolo, autore, prezzo);
        Durata = durata;
    }
    public String toString(){
        return tipo +" "+ codice+" "+ titolo+" "+ autore+ " " + prezzo+ "" + " - "+ Durata;
    }
}
