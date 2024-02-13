public class Furgone extends Veicolo {
    Boolean rimorchio;
    int numero_posti;
    Boolean vanoDiCarico;
    public Furgone(int codice, String tipo, String targa, String modello, String marca, Boolean rimorchio,
            int numero_posti, Boolean vanoDiCarico) {
        super(codice, tipo, targa, modello, marca);
        this.rimorchio = rimorchio;
        this.numero_posti = numero_posti;
        this.vanoDiCarico = vanoDiCarico;
    }
    public Boolean getRimorchio() {
        return rimorchio;
    }
    public int getNumero_posti() {
        return numero_posti;
    }
    public Boolean getVanoDiCarico() {
        return vanoDiCarico;
    }

//agagliaio ,	cilindrata, categoria

//"tipo, targa, codice, modello, marca, costo giornaliero,bagagliaio, cilindrata, categoria, rimorchio, numero di posti,vano di carico"
public String toString(){
    return "Furgone  "+targa+codice+modello+marca+costo_giornaliero+"- "+" - "+" - "+rimorchio+numero_posti+vanoDiCarico;
}
}
