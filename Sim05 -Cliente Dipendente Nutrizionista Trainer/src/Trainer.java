public class Trainer extends Dipendente {
    int ore_settimanali;
    String specialita;

    public Trainer(int codice, double costo_orario, String tipo, String nome_dipendente, int ore_settimanali,
            String specialita) {
        super(codice, costo_orario, tipo, nome_dipendente);
        this.ore_settimanali = ore_settimanali;
        this.specialita = specialita;
    }

    public String toString(){
        return nome_dipendente +" "+ codice+" " + tipo+" " + ore_settimanali+" " + specialita+ " - "+ " - "+" - "+ costo_orario; 
    }
}
