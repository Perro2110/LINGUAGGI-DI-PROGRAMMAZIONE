public class Voto {
    int codice_corso;
    String voto;

    @Override
    public String toString() {
        return "("+codice_corso+" , "+voto+")";
    }
    
    public Voto(int codice_corso, String voto) {
        this.codice_corso = codice_corso;
        this.voto = voto;
    }
    public int getCodice_corso() {
        return codice_corso;
    }
    public void setCodice_corso(int codice_corso) {
        this.codice_corso = codice_corso;
    }
    public String getVoto() {
        return voto;
    }
    public void setVoto(String voto) {
        this.voto = voto;
    }


}
