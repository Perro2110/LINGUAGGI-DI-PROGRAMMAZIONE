public class Hockey extends Squadra {
    double num_medio_gol;
    double numero_medio_di_falli_a_partita;

    public Hockey(int codice, String sport, String nome_della_squadra, int num_partite_vinte, int num_partite_perse,
            double num_medio_gol, double numero_medio_di_falli_a_partita) {
        super(codice, sport, nome_della_squadra, num_partite_vinte, num_partite_perse);
        this.num_medio_gol = num_medio_gol;
        this.numero_medio_di_falli_a_partita = numero_medio_di_falli_a_partita;
    }
@Override
public String toString() {
    return nome_della_squadra+"\t"+codice+"\t"+num_partite_vinte+"\t"+num_partite_perse+"\t"+num_medio_gol+"\t"+numero_medio_di_falli_a_partita+"\t"+" -\t"+sport;
}
}
