public class Pallamano extends Squadra {
    double n_medio_di_reti;

    public Pallamano(int codice, String sport, String nome_della_squadra, int num_partite_vinte, int num_partite_perse,
            double n_medio_di_reti) {
        super(codice, sport, nome_della_squadra, num_partite_vinte, num_partite_perse);
        this.n_medio_di_reti = n_medio_di_reti;
    }

    @Override
    public String toString() {
        return nome_della_squadra + "\t" + codice + "\t" + num_partite_vinte + "\t" + num_partite_perse + "\t"+ "-" + "\t" + "-" + "\t" + n_medio_di_reti+"\t" + sport;
    }

}
