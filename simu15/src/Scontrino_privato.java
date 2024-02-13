public class Scontrino_privato extends Scontrino {
    String nome_cognome;
    String indirizzo;
    String codiceFiscale;




    public Scontrino_privato(String tipo, int iD, String gionoMeseAnno, int codiceCliente, String nome_cognome,
            String indirizzo, String codiceFiscale) {
        super(tipo, iD, gionoMeseAnno, codiceCliente);
        this.nome_cognome = nome_cognome;
        this.indirizzo = indirizzo;
        this.codiceFiscale = codiceFiscale;
    }




    @Override
    public String toString() {
        return ID + "\t" + gionoMeseAnno + "\t" + nome_cognome + "\t" + indirizzo + "\t" + codiceFiscale + "\t" + "-"  + "\t" + "-" + "\t" + codiceCliente;
    }
}
