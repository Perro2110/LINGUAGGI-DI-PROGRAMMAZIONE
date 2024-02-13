/*
 * @ Perrotta Marco
 * 
 * Struttura Tennis figlia di Campo 
 * 
 */

public class Tennis extends Campo {
    float temperatura_media;
    String terreno;

    public Tennis(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costo_orario,
            float temperatura_media, String terreno) {
        super(codice, sport, nomeCampo, larghezza, lunghezza, costo_orario);
        this.temperatura_media = temperatura_media;
        this.terreno = terreno;
    }
                        
    public String toString() {
        return sport + " " + nomeCampo + " " + codice + " " + larghezza + " " + lunghezza + " " + temperatura_media
                + " " + terreno + " - " + " - " + costo_orario;
    }

}
