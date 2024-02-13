public class Partita {
    int codicePrimoGiocatore;
    int codiceSecondoGiocatore;
    int num_di_set_vinti_PRIMOGIOCATORE;
    int num_di_set_vinti_SECONDOGIOCATORE;

    public Partita(int codicePrimoGiocatore, int codiceSecondoGiocatore, int num_di_set_vinti_PRIMOGIOCATORE,
            int num_di_set_vinti_SECONDOGIOCATORE) {
        this.codicePrimoGiocatore = codicePrimoGiocatore;
        this.codiceSecondoGiocatore = codiceSecondoGiocatore;
        this.num_di_set_vinti_PRIMOGIOCATORE = num_di_set_vinti_PRIMOGIOCATORE;
        this.num_di_set_vinti_SECONDOGIOCATORE = num_di_set_vinti_SECONDOGIOCATORE;
    }
@Override
public String toString() {
    return "("+codiceSecondoGiocatore+":"+num_di_set_vinti_PRIMOGIOCATORE+"-"+num_di_set_vinti_SECONDOGIOCATORE+")";
}
}
