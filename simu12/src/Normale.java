public class Normale extends Giocatore {
    String circolo_tennis_di_provvenienza;
    int set_vinti;
    int numero_partite_disputate;

    public Normale(int codice, String tipo, String nome_e_cognome, String circolo_tennis_di_provvenienza, int set_vinti,
            int numero_partite_disputate) {
        super(codice, tipo, nome_e_cognome);
        this.circolo_tennis_di_provvenienza = circolo_tennis_di_provvenienza;
        this.set_vinti = set_vinti;
        this.numero_partite_disputate = numero_partite_disputate;
    }

    @Override
    public String toString() {
        return nome_e_cognome+"\t" + codice+"\t" + tipo+"\t" + "-\t" + "-\t" + "-\t" + circolo_tennis_di_provvenienza+"\t" + set_vinti+"\t"+ numero_partite_disputate;
    }

}
