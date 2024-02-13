/*
 * @ Perrotta Marco
 * 
 * Struttura padre per Tennis e Squash 
 * 
 */

public class Campo {
    int codice;
    String sport;
    String nomeCampo;
    float larghezza;
    float lunghezza;
    float costo_orario;
    
    public Campo() {
        this.codice = 0;
        this.sport = null;
        this.nomeCampo = null;
        this.larghezza = 0;
        this.lunghezza = 0;
        this.costo_orario = 0;
    }

    public Campo(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costo_orario) {
        this.codice = codice;
        this.sport = sport;
        this.nomeCampo = nomeCampo;
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.costo_orario = costo_orario;
    }
    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
    public String getNomeCampo() {
        return nomeCampo;
    }
    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }
    public float getLarghezza() {
        return larghezza;
    }
    public void setLarghezza(float larghezza) {
        this.larghezza = larghezza;
    }
    public float getLunghezza() {
        return lunghezza;
    }
    public void setLunghezza(float lunghezza) {
        this.lunghezza = lunghezza;
    }
    public float getCosto_orario() {
        return costo_orario;
    }
    public void setCosto_orario(float costo_orario) {
        this.costo_orario = costo_orario;
    }

}
