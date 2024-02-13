/*
 * @ Perrotta Marco
 * 
 * Struttura figlia di Campo 
 * 
 */

public class Squash extends Campo {
    float altezza;
    int piano;

    public Squash(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costo_orario,
            float altezza, int piano) {
        super(codice, sport, nomeCampo, larghezza, lunghezza, costo_orario);
        this.altezza = altezza;
        this.piano = piano;
    }

    public String toString() {
        return sport + " "+ nomeCampo + " "+codice +" "+ larghezza +" "+ lunghezza + "- " + "- " + altezza+" " + piano+" " + costo_orario;
    }

}
