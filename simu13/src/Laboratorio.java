public class Laboratorio extends Corso {
    String nome_laboratorio;
    String nome_assistente;
    int num__postazioni_nel_laboratorio;

    public Laboratorio(int codice, String tipo, String nomeCorso, String nome_cognome_docente, String nome_laboratorio,
            String nome_assistente, int num__postazioni_nel_laboratorio) {
        super(codice, tipo, nomeCorso, nome_cognome_docente);
        this.nome_laboratorio = nome_laboratorio;
        this.nome_assistente = nome_assistente;
        this.num__postazioni_nel_laboratorio = num__postazioni_nel_laboratorio;
    }

    /*
     * Il programma deve stampare a video, per ciascuno studente, il suo nome, la
     * sua media
     * sugli esami, contando il trenta e lode come 31, e il suo libretto, con i
     * corsi indicati con il
     * codice e trenta e lode indicato con 30L. (punti 6).
     */
    @Override
    public String toString() {
        return nomeCorso + "\t" + codice + "\t" + nome_cognome_docente + "\t" + tipo + "\t-" + "\t-" + "\t-\t"
                + nome_laboratorio + "\t" + nome_assistente + "\t" + num__postazioni_nel_laboratorio;
    }

}
