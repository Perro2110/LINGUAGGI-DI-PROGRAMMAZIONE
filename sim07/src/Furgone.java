public class Furgone extends Veicolo {
    String categoria;
    int num_posti;
    Boolean vanno;
    public Furgone(int codice, String tipo, String targa, String modello, String marca, String categoria, int num_posti,
            Boolean vanno) {
        super(codice, tipo, targa, modello, marca);
        this.categoria = categoria;
        this.num_posti = num_posti;
        this.vanno = vanno;
    }
    @Override
    public String toString() {
        return tipo+targa+codice+modello+marca+costo_giornaliero+" - "+" - "+categoria+num_posti+vanno;
    }
}
