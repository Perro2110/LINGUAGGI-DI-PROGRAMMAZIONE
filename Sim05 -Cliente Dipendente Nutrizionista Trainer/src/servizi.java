public class servizi {
    int codice_dipendente;
    public int getCodice_dipendente() {
        return codice_dipendente;
    }

    double numero_di_ore_del_servizio;
    
    public double getNumero_di_ore_del_servizio() {
        return numero_di_ore_del_servizio;
    }

    public servizi(int codice_dipendente, double numero_di_ore_del_servizio) {
        this.codice_dipendente = codice_dipendente;
        this.numero_di_ore_del_servizio = numero_di_ore_del_servizio;
    }
}
