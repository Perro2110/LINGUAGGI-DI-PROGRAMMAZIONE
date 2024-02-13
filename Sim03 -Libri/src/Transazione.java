import java.util.ArrayList;
import java.util.List;

public class Transazione {
    String Tipo;
    int Identificativo;
    int data;
    int tot;
    public int getTot() {
        return tot;
    }

    List <Libro>libri=new ArrayList<Libro>();

    public List<Libro> getLibri() {
        return libri;
    }

    int prezzoTotale;
    public void setPrezzoTotale(int prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Transazione(String tipo, int identificativo, int data) {
        Tipo = tipo;
        Identificativo = identificativo;
        this.data = data;
        this.libri = new ArrayList<Libro>();
    }

    public void Acquista(Libro lib){
        libri.add(lib);
        tot+=lib.prezzo;
    }


}
