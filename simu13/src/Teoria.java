public class Teoria extends Corso {
    int codice_aula;
    int numero_ore_settimanali;
    double numer_ore_per_lezione;

    public Teoria(int codice, String tipo, String nomeCorso, String nome_cognome_docente, int codice_aula,
            int numero_ore_settimanali, double numer_ore_per_lezione) {
        super(codice, tipo, nomeCorso, nome_cognome_docente);
        this.codice_aula = codice_aula;
        this.numero_ore_settimanali = numero_ore_settimanali;
        this.numer_ore_per_lezione = numer_ore_per_lezione;
    }

    @Override
    public String toString() {
        return nomeCorso + "\t" + codice + "\t" + nome_cognome_docente + "\t" + tipo + "\t" + codice_aula + "\t"
                + numero_ore_settimanali + "\t" + numer_ore_per_lezione + "\t-" + "\t-" + "\t-";
    }

}
