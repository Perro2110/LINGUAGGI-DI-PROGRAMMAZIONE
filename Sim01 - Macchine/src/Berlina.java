public class Berlina extends Automobili {
    double bagagliaio;

    public double getBagagliaio() {
        return bagagliaio;
    }

    public void setBagagliaio(double bagagliaio) {
        this.bagagliaio = bagagliaio;
    }

    public Berlina(String nome_del_modello, String produttore, int peso, int codiceIdentificativo, double bagagliaio) {
        super(nome_del_modello, produttore, peso, codiceIdentificativo);
        this.bagagliaio = bagagliaio;
    }

    public Berlina() {
        this.bagagliaio = 0;
    }


    public String toString() {
        return codiceIdentificativo+ " " + produttore +" "  + nome_del_modello+ " " + bagagliaio+" " + "-";
    }
}
