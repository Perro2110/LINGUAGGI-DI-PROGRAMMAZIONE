import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Progetto> progetti = new ArrayList<Progetto>();
        List<Ricercatore> ricercatori = new ArrayList<Ricercatore>();
        Map <Integer,String>map=new HashMap<Integer,String>();
        Scanner sc;

        try {
            sc = new Scanner(new File("progetti.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNext()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            sc.nextLine();
            String titoloProgett = sc.nextLine();
            String nome_e_cognome = sc.nextLine();
            String organizzazione_Del_coordinatore = sc.nextLine();

            if (tipo.equals("ricerca")) {
                String codice_arg = sc.next();
                int numero_di_partner = sc.nextInt();
                sc.nextLine();
                double importo_totale_in_milioni_di_euro = sc.nextDouble();

                if (sc.hasNextLine()) {
                    sc.nextLine();
                }

                Progetto pAppo = new Ricerca(codice, tipo, titoloProgett, nome_e_cognome,
                        organizzazione_Del_coordinatore, importo_totale_in_milioni_di_euro, codice_arg,
                        numero_di_partner);
                progetti.add(pAppo);
                map.put(codice,titoloProgett);
            } else {
                int num_azziende_coinvolte = sc.nextInt();
                double importo_totale_in_milioni_di_euro = sc.nextDouble();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                Progetto pAppo = new Innovazione(codice, tipo, titoloProgett, nome_e_cognome,
                        organizzazione_Del_coordinatore, importo_totale_in_milioni_di_euro, num_azziende_coinvolte);
                progetti.add(pAppo);
                map.put(codice,titoloProgett);
            }

        }
        sc.close();
        ;
        Scanner sc2;

        try {
            sc2 = new Scanner(new File("ricercatori.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc2.hasNextLine()) {
            String nome = sc2.nextLine();
            String cognome = sc2.nextLine();
            Ricercatore r = new Ricercatore(nome, cognome);

            /*******************************************************************************************************************
            *******************************************************************************************************************/
            String line = sc2.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                Scanner sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice_prg = sc3.nextInt(); // ..
                double num_ore = sc3.nextDouble(); // ...
                Partecipazioni s = new Partecipazioni(codice_prg, num_ore);
                r.getPart().add(s);
                r.addOre(num_ore);

                // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                if (sc2.hasNextLine())
                    line = sc2.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            ricercatori.add(r);
        }
        // punto 3
        /*
         * Il programma deve stampare a video l’elenco di tutti i progetti in una
         * tabella con queste
         * intestazioni:
         * tipo, titolo, codice, coordinatore, organizzazione, argomento, partner,
         * aziende, importo totale in migliaia di euro
         * Per gli attributi che non si applicano ad un progetto (aziende per i progetti
         * di innovazione e
         * argomento e partner per i progetti di innovazione) si stampi “-” . Per il
         * tipo si stampi
         * ricerca o innovazione. L’importo totale lo si stampi in migliaia di euro
         * (punti 6).
         */
        System.out.println(
                "tipo, titolo, codice, coordinatore, organizzazione, argomento, partner, aziende, importo totale in migliaia di euro");
        for (Progetto pr : progetti) {
            System.out.println(pr);
        }
        // punto 4
        /*
         * Il programma deve stampare a video, per ciascun ricercatore, il suo nome, il
         * suo cognome,
         * il suo impegno orario totale, il numero di progetti a cui partecipa e
         * l’elenco dei progetti
         * nella forma (codice, impegno orario). (punti 6).
         */
        System.out.println("");
        for (Ricercatore rr : ricercatori) {
            System.out.println(rr);
        }

        /*
         * 5. Il programma deve leggere da riga di comando un cognome e stampare il
         * nome, cognome,
         * l’impegno orario più alto e il titolo del progetto per il quale ha
         * quell’impegno orario, per tutti i
         * ricercatori con quel cognome (punti 4).
         */
        System.out.println("_____________");
        String CognomeImpo=args[0];
        for(Ricercatore rrr:ricercatori){
            if(rrr.getCognome().equals(CognomeImpo))
            System.out.println(rrr.getNome()+" "+rrr.getCognome()+" "+rrr.maxProgTemp()+" "+map.get(rrr.maxProgCod()));
        }
    }
}
