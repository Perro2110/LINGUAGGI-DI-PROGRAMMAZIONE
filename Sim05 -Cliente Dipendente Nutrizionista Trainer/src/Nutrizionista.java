public class Nutrizionista extends Dipendente {
    long telefono;
    Boolean medico;
    int appuntamenti_settimanali;


    public Nutrizionista(int codice, double costo_orario, String tipo, String nome_dipendente, long telefono,
            Boolean medico, int appuntamenti_settimanali) {
        super(codice, costo_orario, tipo, nome_dipendente);
        this.telefono = telefono;
        this.medico = medico;
        this.appuntamenti_settimanali = appuntamenti_settimanali;
    }




    public String toString() {
        return nome_dipendente+" " + codice+" " + tipo + " - " + " - " + telefono+" " + medico+" " + appuntamenti_settimanali+" " + costo_orario;
    }

}
