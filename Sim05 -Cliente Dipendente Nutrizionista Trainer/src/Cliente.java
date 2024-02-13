import java.util.ArrayList;
import java.util.List;

public class Cliente {
    int codice_del_cliente;
    String nome_del_cliente;

    List<servizi> servizii = new ArrayList<servizi>();

    public List<servizi> getServizii() {
        return servizii;
    }

    public int getCodice_del_cliente() {
        return codice_del_cliente;
    }

    public String getNome_del_cliente() {
        return nome_del_cliente;
    }

    public Cliente(int codice_del_cliente, String nome_del_cliente) {
        this.codice_del_cliente = codice_del_cliente;
        this.nome_del_cliente = nome_del_cliente;
    }

}
