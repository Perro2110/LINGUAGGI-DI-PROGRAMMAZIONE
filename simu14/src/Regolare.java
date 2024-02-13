public class Regolare extends Partecipante {
    String ente_di_appartenenza;
    
    public String getEnte_di_appartenenza() {
        return ente_di_appartenenza;
    }
    int numero_dipendenti;
    Boolean accademico;

    public Regolare(int codice, String tipo, String nome, String cognome, String ente_di_appartenenza,
            int numero_dipendenti, Boolean accademico) {
        super(codice, tipo, nome, cognome);
        this.ente_di_appartenenza = ente_di_appartenenza;
        this.numero_dipendenti = numero_dipendenti;
        this.accademico = accademico;
    }
    @Override
    public String toString() {
        return tipo+"\t"+codice+"\t"+nome+"\t"+cognome+"\t"+" - "+"\t"+" - "+"\t"+" - "+"\t"+ente_di_appartenenza+"\t"+numero_dipendenti+"\t"+accademico;
    }


}
