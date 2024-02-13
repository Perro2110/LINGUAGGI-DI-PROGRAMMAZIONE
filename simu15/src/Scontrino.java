import java.util.ArrayList;
import java.util.List;

public class Scontrino {
    String tipo;
    int ID;
    String gionoMeseAnno;
    List <Prodotto> prodotti=new ArrayList<Prodotto>();

    int codiceCliente;

    public int getCodiceCliente() {
        return codiceCliente;
    }


    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public Scontrino(String tipo, int iD, String gionoMeseAnno,int codiceCliente) {
        this.tipo = tipo;
        ID = iD;
        this.gionoMeseAnno = gionoMeseAnno;
        this.codiceCliente=codiceCliente;
        prodotti=new ArrayList<Prodotto>();
    }
    
}
