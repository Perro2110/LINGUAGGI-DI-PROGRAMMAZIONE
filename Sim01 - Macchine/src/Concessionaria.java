import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    List<Automobili> macchine = new ArrayList<Automobili>();

    public List<Automobili> getMacchine() {
        return macchine;
    }

    public void setMacchine(List<Automobili> macchine) {
        this.macchine = macchine;
    }

    public Concessionaria() {
        List<Automobili> m = new ArrayList<Automobili>();
        this.macchine = m;
    }
    public void ADD(Automobili m) {
        macchine.add(m);
    }

    public void stampa(){
        System.out.println("Codice Marca Modello Bagagliaio Marce");
        for(Automobili a:macchine){
            System.out.println(a);
        }
    }

    public void range(int min,int max){
        int count=0;
        for(Automobili a:macchine){
            if(a.getPeso()<max && a.getPeso()>min){
                count++;
            }
        }
        System.out.println("All interno dell'range tra: "+min + " e " +max +" vi sono: " +count+ " macchine ");
    }

    public void CercaMarca(String Marca){
        for(Automobili a:macchine){
            if(a.getProduttore().equals(Marca)){
                System.out.println(a.getNome_del_modello());
            }
        }
    }
}
