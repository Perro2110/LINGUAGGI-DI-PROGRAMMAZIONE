import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nome_cognome;
    public String getNome_cognome() {
        return nome_cognome;
    }

    List <Noleggio>noleggi=new ArrayList <Noleggio> ();

    public List<Noleggio> getNoleggi() {
        return noleggi;
    }

    public Cliente(String nome_cognome) {
        this.nome_cognome = nome_cognome;
        this.noleggi = new ArrayList <Noleggio>();
    }
}
