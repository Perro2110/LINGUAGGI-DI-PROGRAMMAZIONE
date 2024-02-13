public class Testa_di_serie extends Giocatore {
    int ranking;
    int eta;
    boolean professionista;

    public Testa_di_serie(int codice, String tipo, String nome_e_cognome, int ranking, int eta,
            boolean professionista) {
        super(codice, tipo, nome_e_cognome);
        this.ranking = ranking;
        this.eta = eta;
        this.professionista = professionista;
    }
@Override
public String toString() {
    return nome_e_cognome+"\t"+codice+"\t"+tipo+"\t"+ranking+"\t"+eta+"\t"+professionista+"-\t"+"-\t"+"-\t";
}

}
