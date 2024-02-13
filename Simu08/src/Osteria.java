public class Osteria extends Ristorante {
    int num_posti_a_sedere;
    double superfice;
    Boolean bagno_Endicap;

    public Osteria(int codice, String tipo, String nome_ristorante, int num_posti_a_sedere, double superfice,
            Boolean bagno_Endicap) {
        super(codice, tipo, nome_ristorante);
        this.num_posti_a_sedere = num_posti_a_sedere;
        this.superfice = superfice;
        this.bagno_Endicap = bagno_Endicap;
    }

    public String toString() {
        // TODO Auto-generated method stub
        return nome_ristorante+"\t"+codice+"\t"+tipo+"\t"+"\t- "+"\t- "+num_posti_a_sedere+"\t"+superfice+"\t"+bagno_Endicap;
    }

}
