public class Studente extends Partecipante {
    String nome_del_corso_di_studi;
    String nome_dell_uni;
    int annoDiCorso;

    public Studente(int codice, String tipo, String nome, String cognome, String nome_del_corso_di_studi,
            String nome_dell_uni, int annoDiCorso) {
        super(codice, tipo, nome, cognome);
        this.nome_del_corso_di_studi = nome_del_corso_di_studi;
        this.nome_dell_uni = nome_dell_uni;
        this.annoDiCorso = annoDiCorso;
    }
    @Override
    public String toString() {
        return tipo+"\t"+codice+"\t"+nome+"\t"+cognome+"\t"+nome_del_corso_di_studi+"\t"+nome_dell_uni+"\t"+annoDiCorso+"\t"+" - \t - \t -";
    }
}
