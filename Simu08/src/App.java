import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        Scanner sc2;

        List<Ristorante> ristoranti = new LinkedList<Ristorante>();
        Map <Integer,Ristorante> mapCodRist=new HashMap<Integer,Ristorante>();

        try {
            sc = new Scanner(new File("ristoranti.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        try {
            sc2 = new Scanner(new File("menu.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNext()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            sc.nextLine();
            String nome = sc.nextLine();
            if (tipo.equals("pub")) {
                int num_dipendenti = sc.nextInt();
                int num_tavoli = sc.nextInt();
                if (sc.hasNextLine())
                    sc.nextLine();
                Ristorante rappo = new Pub(codice, tipo, nome, num_dipendenti, num_tavoli);
                ristoranti.add(rappo);
                mapCodRist.put(codice, rappo);
            } else {
                int n_posti_a_sedere = sc.nextInt();
                double superfice = sc.nextDouble();
                Boolean dis = sc.nextBoolean();
                if (sc.hasNextLine())
                    sc.nextLine();
                Ristorante rappo = new Osteria(codice, tipo, nome, n_posti_a_sedere, superfice, dis);
                ristoranti.add(rappo);
                mapCodRist.put(codice, rappo);
            }
        }
        sc.close();
        while(sc2.hasNext()){
            int codiceRist=sc2.nextInt();
            sc2.nextLine();
            String descrizioneDelProdotto=sc2.nextLine();
            String tipo=sc2.next();
            float prezzo=sc2.nextFloat();
            float costoMateriePrime=sc2.nextFloat(); 
            if (sc2.hasNextLine())
             sc2.nextLine();
            Menu mapp=new Menu(codiceRist, descrizioneDelProdotto, tipo, prezzo, costoMateriePrime);
            mapCodRist.get(codiceRist).getMenu().add(mapp);
        }

    //es 3
    System.out.println("nome, \tcodice, \ttipo, \tn. dipendenti, \tn. tavoli, \tn. posti, \tsuperficie, \tbagno disabili");
    for(Ristorante r:ristoranti){
        System.out.println(r);
    }  

    System.out.println(" ");
    for(Ristorante r:ristoranti){
        System.out.println(r.getNome_ristorante());
        System.out.println(r.getMenu());
    }  

    float maxPrMed=-1;
    String nomeMax=null;
    for(Ristorante r:ristoranti){
        float prezzoMedio=0;
        for(Menu m:r.getMenu()){
            prezzoMedio+=m.getPrezzo();
        }
        prezzoMedio=prezzoMedio/r.getMenu().size();
        if(prezzoMedio>=maxPrMed){
            maxPrMed=prezzoMedio;
            nomeMax=r.getNome_ristorante();
        }
    }
    System.out.println(nomeMax +" "+maxPrMed);


    }
}
