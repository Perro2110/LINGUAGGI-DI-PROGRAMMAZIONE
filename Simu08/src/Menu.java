public class Menu {
    int codiceRistorante;
    String descrizioneDelProdotto;
    String tipo;
    float prezzo;

    public float getPrezzo() {
        return prezzo;
    }

    float costo_materie_prime;

    public Menu(int codiceRistorante, String descrizioneDelProdotto, String tipo, float prezzo,
            float costo_materie_prime) {
        this.codiceRistorante = codiceRistorante;
        this.descrizioneDelProdotto = descrizioneDelProdotto;
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.costo_materie_prime = costo_materie_prime;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return descrizioneDelProdotto + " " + tipo + " " + prezzo + " " + costo_materie_prime;
    }
}
