import java.util.ArrayList;
import java.util.List;

public class Studente {
    int matricola;
    String nome_e_cognome;
    List<Voto> libretto = new ArrayList<Voto>();
    double media;
    int votoMax;
    int codice_corsoMax;

    public String getVotoMax() {
        if (votoMax == 31)
            return "30L";
        else
            return "" + votoMax;
    }

    public int getCodice_corsoMax() {
        return codice_corsoMax;
    }

    public Studente(int matricola, String nome_e_cognome) {
        this.matricola = matricola;
        this.nome_e_cognome = nome_e_cognome;
        this.libretto = new ArrayList<Voto>();
        media = 0;
        votoMax = -1;
        codice_corsoMax = 999;
    }

    public List<Voto> getLibretto() {
        return libretto;
    }

    public void insVoto(String s, int codice_corso) {
        int v;
        if (s.equals("30L")) {
            media += 31;
            v = 31;
        } else {
            media += Double.parseDouble(s);
            v = Integer.parseInt(s);
        }
        if (v > votoMax) {
            votoMax = v;
            codice_corsoMax = codice_corso;
        }
    }

    @Override
    public String toString() {
        return nome_e_cognome + " " + media / libretto.size() + " " + libretto.toString();
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome_e_cognome() {
        return nome_e_cognome;
    }

    public void setNome_e_cognome(String nome_e_cognome) {
        this.nome_e_cognome = nome_e_cognome;
    }

    public void setLibretto(List<Voto> libretto) {
        this.libretto = libretto;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
