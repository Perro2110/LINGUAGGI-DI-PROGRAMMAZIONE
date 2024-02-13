public class Pub extends Ristorante {
    int numero_dipendenti;
    int numTavoli;

    public Pub(int codice, String tipo, String nome_ristorante, int numero_dipendenti, int numTavoli) {
        super(codice, tipo, nome_ristorante);
        this.numero_dipendenti = numero_dipendenti;
        this.numTavoli = numTavoli;
    }
@Override

public String toString() {
    // TODO Auto-generated method stub
    return nome_ristorante+"\t"+codice+"\t"+tipo+"\t"+numero_dipendenti+"\t"+numTavoli+"\t- "+"\t- "+"\t- ";
}
}
