

public class fisica extends Transazione {
    String citta_del_negozio;

    public fisica(String tipo, int identificativo, int data, String citta_del_negozio) {
        super(tipo, identificativo, data);
        this.citta_del_negozio = citta_del_negozio;
    }

    public String toString() {
        return Identificativo +" " + data + " "+ citta_del_negozio + " - " + tot;
    }
}
