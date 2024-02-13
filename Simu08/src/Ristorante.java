import java.util.ArrayList;
import java.util.List;

public class Ristorante {
    int codice;
    String tipo;
    String nome_ristorante;
    public String getNome_ristorante() {
        return nome_ristorante;
    }

    List <Menu>menu=new ArrayList<Menu>();

    public List<Menu> getMenu() {
        return menu;
    }

    public Ristorante(int codice, String tipo, String nome_ristorante) {
        this.codice = codice;
        this.tipo = tipo;
        this.nome_ristorante = nome_ristorante;
        this.menu=new ArrayList<Menu>();
    }

}
