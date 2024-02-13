public class Pallavolo extends Squadra{
    float num_medio_set_vinti;

    public Pallavolo(String nome_della_squadra, int codice, String sport, int numero_partite_vinte,
            int numero_partite_perse, float num_medio_set_vinti) {
        super(nome_della_squadra, codice, sport, numero_partite_vinte, numero_partite_perse);
        this.num_medio_set_vinti = num_medio_set_vinti;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nome_della_squadra+" "+codice+" "+numero_partite_vinte+" "+numero_partite_perse+" - "+num_medio_set_vinti+" "+sport;
        
    }
}
