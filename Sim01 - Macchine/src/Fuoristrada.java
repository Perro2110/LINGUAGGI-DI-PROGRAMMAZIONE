public class Fuoristrada extends Automobili{
    int numMerce;

    public void setNumMerce(int numMerce) {
        this.numMerce = numMerce;
    }

    public Fuoristrada(String nome_del_modello, String produttore, int peso, int codiceIdentificativo, int numMerce) {
        super(nome_del_modello, produttore, peso, codiceIdentificativo);
        this.numMerce = numMerce;
    }

    public Fuoristrada() {
        this.numMerce = 0;
    }

    public String toString() {
        return codiceIdentificativo +" "+ produttore+" "  + nome_del_modello +" "+ "- " + numMerce+" ";
    }

}
