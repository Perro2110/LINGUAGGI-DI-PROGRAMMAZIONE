public class Dipendente {
    int codice;
    double costo_orario;
    String tipo, nome_dipendente;

    public int getCodice() {
        return codice;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome_dipendente() {
        return nome_dipendente;
    }

    public Dipendente(int codice, double costo_orario, String tipo, String nome_dipendente) {
        this.codice = codice;
        this.costo_orario = costo_orario;
        this.tipo = tipo;
        this.nome_dipendente = nome_dipendente;
    }

    public double getCosto_orario() {
        return costo_orario;
    }
}
