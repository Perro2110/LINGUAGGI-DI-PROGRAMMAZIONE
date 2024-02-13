public class Scontrino_azienda extends Scontrino {
    String ragioneSociale;
    int partitaIva;
    String indirizzo;



    public Scontrino_azienda(String tipo, int iD, String gionoMeseAnno, int codiceCliente, String ragioneSociale,
            int partitaIva, String indirizzo) {
        super(tipo, iD, gionoMeseAnno, codiceCliente);
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
        this.indirizzo = indirizzo;
    }



    @Override
    public String toString() {
        return ID + "\t" + gionoMeseAnno + "\t" + "-" + "\t" + indirizzo + "\t" + "-" + "\t" + "\t" + ragioneSociale
                + "\t" + partitaIva + "\t" + codiceCliente;
    }

}
