public class Auto extends Veicolo{
    int cilindrata;
    double Capienza_bagagliaio;
    public Auto(int codice, String tipo, String targa, String modello, String marca, int cilindrata,
            double capienza_bagagliaio) {
        super(codice, tipo, targa, modello, marca);
        this.cilindrata = cilindrata;
        Capienza_bagagliaio = capienza_bagagliaio;
    }
    @Override
    public String toString() {
        return tipo+targa+codice+modello+marca+costo_giornaliero+cilindrata+Capienza_bagagliaio+" - "+" - "+" - ";
    }
}
