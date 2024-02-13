public class Automobili {
    String nome_del_modello;
    String produttore;
    int peso;
    int codiceIdentificativo;

    public Automobili(String nome_del_modello, String produttore, int peso, int codiceIdentificativo) {
        this.nome_del_modello = nome_del_modello;
        this.produttore = produttore;
        this.peso = peso;
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public Automobili() {
        this.nome_del_modello = null;
        this.produttore = null;
        this.peso = 0;
        this.codiceIdentificativo = 0;
    }

    public String getNome_del_modello() {
        return nome_del_modello;
    }

    public void setNome_del_modello(String nome_del_modello) {
        this.nome_del_modello = nome_del_modello;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(int codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }


}
