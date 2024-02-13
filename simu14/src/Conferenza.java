import java.util.ArrayList;
import java.util.List;

public class Conferenza {
    String nomeConferenza;
    String luogo;
    List<Partecipo> presenti = new ArrayList<Partecipo>();
    int totSpesa;

    public void incTotSpesa(int sp) {
        totSpesa += sp;
    }

    public Conferenza(String nomeConferenza, String luogo) {
        this.nomeConferenza = nomeConferenza;
        this.luogo = luogo;
        this.presenti = new ArrayList<Partecipo>();
        this.totSpesa = 0;
    }

    public int getTotSpesa() {
        return totSpesa;
    }

    public String getNomeConferenza() {
        return nomeConferenza;
    }

    public String getLuogo() {
        return luogo;
    }

    public List<Partecipo> getPresenti() {
        return presenti;
    }

}
