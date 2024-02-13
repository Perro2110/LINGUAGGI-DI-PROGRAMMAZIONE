public class Giocatore {
    int cod_squad;
    String cognome;
    int eta;
    int num_magl;
    String ruolo;
    Boolean titolare;

    public Giocatore(int cod_squad, String cognome, int eta, int num_magl, String ruolo, Boolean titolare) {
        this.cod_squad = cod_squad;
        this.cognome = cognome;
        this.eta = eta;
        this.num_magl = num_magl;
        this.ruolo = ruolo;
        this.titolare = titolare;
    }
    @Override
    public String toString() {
        return cod_squad +" "+num_magl+" "+ruolo+" "+titolare;
    }
}
