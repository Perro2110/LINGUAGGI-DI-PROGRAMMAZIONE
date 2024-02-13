public class Veicolo {
    int codice;
    String tipo;
    String targa;
    String modello;
    String marca;

    double costo_giornaliero;

    public Veicolo(int codice, String tipo, String targa, String modello, String marca) {
        this.codice = codice;
        this.tipo = tipo;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
    }



    public void setCosto_giornaliero(double costo_giornaliero) {
        this.costo_giornaliero = costo_giornaliero;
    }

    public int getCodice() {
        return codice;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto_giornaliero() {
        return costo_giornaliero;
    }

}
