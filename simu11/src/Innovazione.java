public class Innovazione extends Progetto {
    int num_azziende_coinvolte;

    public Innovazione(int codice, String tipo, String titolo_progetto, String nomeCognome_coordinatore,
            String orgaString, double importo_totale_in_milioni_di_euro, int num_azziende_coinvolte) {
        super(codice, tipo, titolo_progetto, nomeCognome_coordinatore, orgaString, importo_totale_in_milioni_di_euro);
        this.num_azziende_coinvolte = num_azziende_coinvolte;
    }
    @Override
    public String toString() {
        return tipo+" "+titolo_progetto+" "+codice+" "+nomeCognome_coordinatore+" "+orgaString+" - "+" - "+num_azziende_coinvolte+" "+(importo_totale_in_milioni_di_euro *1000);
    }
}
