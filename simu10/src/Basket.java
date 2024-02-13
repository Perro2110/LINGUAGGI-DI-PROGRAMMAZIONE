public class Basket extends Squadra{
    float punteggio_med;

    public Basket(String nome_della_squadra, int codice, String sport, int numero_partite_vinte,
            int numero_partite_perse, float punteggio_med) {
        super(nome_della_squadra, codice, sport, numero_partite_vinte, numero_partite_perse);
        this.punteggio_med = punteggio_med;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nome_della_squadra+" "+codice+" "+numero_partite_vinte+" "+numero_partite_perse+" "+punteggio_med+" - "+sport;
        
    }
}
