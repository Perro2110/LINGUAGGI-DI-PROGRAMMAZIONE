/*
 * Classe immaginata percontenere le varie informazioni delle singole prenotazioni
 */
public class Prenotazione {
    int codiceCampo;
    int oraInizio;
    public int getCodiceCampo() {
        return codiceCampo;
    }
    public void setCodiceCampo(int codiceCampo) {
        this.codiceCampo = codiceCampo;
    }
    public int getOraInizio() {
        return oraInizio;
    }
    public void setOraInizio(int oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String toString(){
        return "("+codiceCampo+","+oraInizio+")";
    }
}
