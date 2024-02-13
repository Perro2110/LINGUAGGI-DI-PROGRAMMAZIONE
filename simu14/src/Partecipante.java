public class Partecipante {
    int codice;
    String tipo;
    public String getTipo() {
        return tipo;
    }

    String nome;
    String cognome;

    public Partecipante(int codice, String tipo, String nome, String cognome) {
        this.codice = codice;
        this.tipo = tipo;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getCodice() {
        return codice;
    }

    public String getCognome() {
        return cognome;
    }

}
