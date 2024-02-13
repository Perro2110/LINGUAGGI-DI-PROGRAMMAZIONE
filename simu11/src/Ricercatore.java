import java.util.ArrayList;
import java.util.List;

public class Ricercatore {
    String nome;
    String cognome;
    double orarioMax;
    List<Partecipazioni> part = new ArrayList<Partecipazioni>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ricercatore(String nome, String cognome) {
        orarioMax = 0;
        this.nome = nome;
        this.cognome = cognome;
        this.part = new ArrayList<Partecipazioni>();
    }

    public List<Partecipazioni> getPart() {
        return part;
    }

    public void setPart(List<Partecipazioni> part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + orarioMax + " " + part.toString();
    }

    public void addOre(double d) {
        orarioMax += d;
    }

    public double maxProgTemp() {
        double max = -1;
        for (Partecipazioni p : part) {
            double attuale = p.getOre();
            if (attuale > max) {
                max = attuale;
            }
        }
        return max;
    }

    public int maxProgCod() {
        double max = -1;
        int codMx = 0;
        for (Partecipazioni p : part) {
            double attuale = p.getOre();
            if (attuale > max) {
                codMx = p.getCodiceDelProgetto();
                max = attuale;
            }
        }
        return codMx;
    }
}
