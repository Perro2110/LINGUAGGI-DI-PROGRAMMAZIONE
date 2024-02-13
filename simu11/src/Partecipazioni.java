public class Partecipazioni {
    int codiceDelProgetto;
    double ore;

    public int getCodiceDelProgetto() {
        return codiceDelProgetto;
    }

    public void setCodiceDelProgetto(int codiceDelProgetto) {
        this.codiceDelProgetto = codiceDelProgetto;
    }

    public double getOre() {
        return ore;
    }

    public void setOre(double ore) {
        this.ore = ore;
    }

    public Partecipazioni(int codiceDelProgetto, double ore) {
        this.codiceDelProgetto = codiceDelProgetto;
        this.ore = ore;
    }
    @Override
    public String toString() {
        return "("+codiceDelProgetto+" , "+ore+")";
    }
}
