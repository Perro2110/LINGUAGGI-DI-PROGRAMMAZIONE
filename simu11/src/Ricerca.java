public class Ricerca extends Progetto {
    String codice_argomento;
    int numero_di_partner;

    public Ricerca(int codice, String tipo, String titolo_progetto, String nomeCognome_coordinatore, String orgaString,
            double importo_totale_in_milioni_di_euro, String codice_argomento, int numero_di_partner) {
        super(codice, tipo, titolo_progetto, nomeCognome_coordinatore, orgaString, importo_totale_in_milioni_di_euro);
        this.codice_argomento = codice_argomento;
        this.numero_di_partner = numero_di_partner;
    }
    @Override
    public String toString() {

        return tipo+" "+titolo_progetto+" "+codice+" "+nomeCognome_coordinatore+" "+orgaString+" "+codice_argomento+" "+numero_di_partner+" - "+(importo_totale_in_milioni_di_euro *1000);
    }

}
