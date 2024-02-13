import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        
        List<Veicolo> l = new ArrayList<Veicolo>();
        List<Cliente> c = new ArrayList<Cliente>();

        Map<Integer, Double> map = new HashMap<Integer, Double>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        Scanner sc;
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
        Scanner sc3;
        // es 1
        while (sc.hasNextLine()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            String Targa = sc.next();

            sc.nextLine();
            String modello = sc.nextLine();
            String marca = sc.nextLine();
            Veicolo v;
            if (tipo.equals("auto")) {
                double capienza = sc.nextDouble();
                int cilindrata = sc.nextInt();
                sc.nextLine();
                String categoria = sc.nextLine();
                v = new Auto(codice, tipo, Targa, modello, marca, capienza, cilindrata, categoria);
            } else {
                Boolean rimorchio = sc.nextBoolean();
                int numero_posti = sc.nextInt();
                Boolean vanno_di_carico = sc.nextBoolean();
                sc.nextLine();
                v = new Furgone(codice, tipo, Targa, modello, marca, rimorchio, numero_posti, vanno_di_carico);
            }
            double costo = sc.nextDouble();
            v.setCosto_giornaliero(costo);
            map.put(codice, costo);
            l.add(v);
        }
        sc.close();
        // es 2

        while (sc2.hasNextLine()) {
            String nome_cognome = sc2.nextLine();
            Cliente clienteAppo = new Cliente(nome_cognome);

            String line = sc2.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice_veicolo = sc3.nextInt(); // ..
                int num_di_giorni = sc3.nextInt(); // ...

                Noleggio n = new Noleggio(codice_veicolo, num_di_giorni);
                clienteAppo.getNoleggi().add(n);

                for (Veicolo vvv : l) {                                   /*PER TUTTI I VEICOLI PRESENTI CONTROLLO QUALE STO NOLEGIANDO COSI AUMENTO LA MAPPA TARGA COUNT*/
                    if (vvv.getCodice() == (codice_veicolo)) {        
                        Integer pezzi = map2.get(vvv.getTarga());
                        if (pezzi == null)
                            map2.put(vvv.getTarga(), (Integer) 1);
                        else
                            map2.put(vvv.getTarga(), pezzi + 1);
                    }
                }

                // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                if (sc2.hasNextLine())
                    line = sc2.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            c.add(clienteAppo);
        }
        // es 3
        System.out.println(
                "tipo, targa, codice, modello, marca, costo giornaliero,bagagliaio, cilindrata, categoria, rimorchio, numero di posti,vano di carico");
        for (Veicolo vv : l) {
            System.out.println(vv);
        }
        /*
         * 4. Il programma deve stampare a video, per ciascun cliente,il suo nome e
         * cognome, il costo
         * del suo noleggio di costo maggiore (costo del noleggio ottenuto moltiplicando
         * il costo del
         * veicolo per il numero di giorni) e il numero di noleggi. (punti 6).
         */

        double max = (-1);

        for (Cliente cliente : c) {
            max = -1;
            for (Noleggio n : cliente.getNoleggi()) {
                int cou = n.getV();
                double maxappo = map.get(cou);
                maxappo = n.getGiorno() * maxappo;
                if (max <= maxappo) {
                    max = maxappo;
                }
            }
            System.out.println(cliente.getNome_cognome() + " " + max);
        }

        /*
         * 5. Il programma deve leggere da tastiera la targa di un veicolo e stampare il
         * numero di noleggi di
         * quel veicolo (punti 4).
         */
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserire Codice: ");
        String Targa2 = stdin.readLine();
        System.out.println(map2.get(Targa2));

    }
}
