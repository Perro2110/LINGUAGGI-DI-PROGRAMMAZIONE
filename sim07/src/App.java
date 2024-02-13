import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        List<Veicolo> veicoli = new ArrayList<Veicolo>();
        List<Cliente> clienti = new ArrayList<Cliente>();
        Map<Integer, Double> CodiceCosto = new HashMap<Integer, Double>();
        Map<Integer,Integer> CodiceGiorni=new HashMap<Integer, Integer>();
        try {
            sc = new Scanner(new File("veicoli.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        Scanner sc2;
        try {
            sc2 = new Scanner(new File("clienti.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc.hasNext()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            String targa = sc.next();
            sc.nextLine();
            String modello = sc.nextLine();
            String marca = sc.nextLine();
            Veicolo v;
            if (tipo.equals("auto")) {
                int cilindrata = sc.nextInt();
                double capienzaBagagliaio = sc.nextDouble();
                sc.nextLine();
                v = new Auto(codice, tipo, targa, modello, marca, cilindrata, capienzaBagagliaio);
            } else {
                String categoria = sc.nextLine();
                int num_posti = sc.nextInt();
                Boolean vano_di_carico = sc.nextBoolean();
                sc.nextLine();
                v = new Furgone(codice, tipo, targa, modello, marca, categoria, num_posti, vano_di_carico);
            }
            double costo_giornaliero = sc.nextDouble();
            CodiceCosto.put(codice, costo_giornaliero);
            CodiceGiorni.put(codice, 0);
            v.setCosto_giornaliero(costo_giornaliero);
            veicoli.add(v);
        }
        sc.close();
        while (sc2.hasNext()) {
            Cliente cAppo = new Cliente(sc2.nextLine());
            String line = sc2.nextLine();
            Scanner sc3 = new Scanner(line);
            while (sc3.hasNextInt()) {
                int a = sc3.nextInt();
                int b = sc3.nextInt();
                Noleggio nol = new Noleggio(a, b);
                int s=CodiceGiorni.get(a);
                CodiceGiorni.put(a,s+b);
                cAppo.getNoleggi().add(nol);
            }
            sc3.close();
            clienti.add(cAppo);
        }
        System.out.println(
                "tipo, targa, codice, modello, marca, costo giornaliero, cilindrata, bagagliaio, categoria, numero di posti, vano di carico");
        for (Veicolo vv : veicoli) {
            System.out.println(vv);
        }

        for (Cliente c : clienti) {
            double prtot=0;
            for (Noleggio n : c.getNoleggi()) {
                prtot+=(n.getNumGiorni()*CodiceCosto.get(n.getCodiceVeicolo()));
            }
            System.out.println(c.getNome_cognome() +" "+prtot);
        }
        int codiceDaCercare=Integer.parseInt(args[0]);

        double f=CodiceCosto.get(codiceDaCercare)*CodiceGiorni.get(codiceDaCercare);
        System.out.println(f);

    }
}
