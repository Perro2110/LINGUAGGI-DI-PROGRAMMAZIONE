public class Auto extends Veicolo {
    double capienza_bagagliaio;
    int cilindrata;
    String categoria;




        
    public Auto(int codice, String tipo, String targa, String modello, String marca, double capienza_bagagliaio,
            int cilindrata, String categoria) {
        super(codice, tipo, targa, modello, marca);
        this.capienza_bagagliaio = capienza_bagagliaio;
        this.cilindrata = cilindrata;
        this.categoria = categoria;
    }

    public double getCapienza_bagagliaio() {
        return capienza_bagagliaio;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getCategoria() {
        return categoria;
    }
//"tipo, targa, codice, modello, marca, costo giornaliero,bagagliaio, cilindrata, categoria, rimorchio, numero di posti,vano di carico"
    public String toString(){
        return "Automobile "+targa+codice+modello+marca+costo_giornaliero+capienza_bagagliaio+categoria+" - "+" - "+" - ";
    }
}
