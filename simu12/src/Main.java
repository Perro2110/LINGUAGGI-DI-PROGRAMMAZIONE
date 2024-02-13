import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Giocatore> giocatori = new LinkedList<Giocatore>();
        List<Partita> partite = new LinkedList<Partita>();
        Map<Integer, String> nomeCodice = new HashMap<Integer, String>();
        Map<Integer, Integer> CodVitt = new HashMap<Integer, Integer>();
        Scanner sc;

        try {
            sc = new Scanner(new File("giocatori.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNextLine()) {
            int codice = sc.nextInt();
            sc.nextLine();
            String tipo = sc.nextLine();
            String nome_e_cognome = sc.nextLine();
            if (tipo.equals("testa-di-serie")) {
                int ranking = sc.nextInt();
                int eta = sc.nextInt();
                Boolean proffessionista = sc.nextBoolean();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                Giocatore g = new Testa_di_serie(codice, tipo, nome_e_cognome, ranking, eta, proffessionista);
                giocatori.add(g);
                nomeCodice.put(codice, nome_e_cognome);
                CodVitt.put(codice, 0);
            } else {
                String circolo_tennis_di_provenienza = sc.nextLine();
                int num_di_set_vinti = sc.nextInt();
                int numero_partite_disputate = sc.nextInt();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                Giocatore g = new Normale(codice, tipo, nome_e_cognome, circolo_tennis_di_provenienza, num_di_set_vinti,
                        numero_partite_disputate);
                giocatori.add(g);
                nomeCodice.put(codice, nome_e_cognome);
                CodVitt.put(codice, 0);
            }

        }
        sc.close();
        Scanner sc2;

        try {
            sc2 = new Scanner(new File("partite.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc2.hasNextLine()) {
            int codicePrimoGiocatore = sc2.nextInt();
            int codiceSecondoGiocatore = sc2.nextInt();
            sc2.nextLine();
            int num_di_set_vinti_PRIMOGIOCATORE = sc2.nextInt();
            int num_di_set_vinti_SECONDOGIOCATORE = sc2.nextInt();
            if (sc2.hasNextLine())
                sc2.nextLine();
            Partita p = new Partita(codicePrimoGiocatore, codiceSecondoGiocatore, num_di_set_vinti_PRIMOGIOCATORE,
                    num_di_set_vinti_SECONDOGIOCATORE);

            Partita p2 = new Partita(codiceSecondoGiocatore, codicePrimoGiocatore, num_di_set_vinti_SECONDOGIOCATORE,
                    num_di_set_vinti_PRIMOGIOCATORE);

            if(num_di_set_vinti_PRIMOGIOCATORE>num_di_set_vinti_SECONDOGIOCATORE)
            CodVitt.put(codicePrimoGiocatore, CodVitt.get(codicePrimoGiocatore) + 1);
            else
            CodVitt.put(codiceSecondoGiocatore, CodVitt.get(codiceSecondoGiocatore) + 1);
            
            partite.add(p);

            for (Giocatore g : giocatori) {
                if (g.getNome_e_cognome().equals(nomeCodice.get(codicePrimoGiocatore))) {
                    g.getPartiteGiocate().add(p);
                }
                if (g.getNome_e_cognome().equals(nomeCodice.get(codiceSecondoGiocatore))) {
                    g.getPartiteGiocate().add(p2);
                }

            }
        }
        /*
         * ES 3
         * . Il programma deve stampare a video l’elenco di tutti i giocatori in una
         * tabella con queste
         * intestazioni:
         * nome, codice, tipo, ranking, età, professionista, circolo, n.set vinti, n.
         * partite
         * Per gli attributi che non si applicano ad un giocatore (circolo, n. set
         * vinti, n.
         * partite per le teste di serie e ranking, età, professionista per i normali)
         * si
         * stampi “-” . Per il tipo si stampi testa-di-serie o normale (punti 6).
         */
        System.out.println("nome\tcodice,\ttipo,\tranking,\tetà,\tprofessionista,\tcircolo,\tn.set vinti,\tn. partite");
        for (Giocatore g : giocatori) {
            System.out.println(g);
        }
        /*
         * 4. Il programma deve stampare a video, per ciascun giocatore, il suo nome e
         * l’elenco delle
         * partite che ha giocato con, per ciascuna partita, il codice del giocatore
         * avversario e il
         * numero di set vinti proprio e dell’avversario. (punti 6).
         * 
         */
        for (Giocatore g : giocatori) {
            System.out.println(nomeCodice.get(g.getCodice()) + " " + g.getPartiteGiocate());
        }
        /*
         * . Il programma stampare a video il nome del giocatore che ha vinto più
         * partite (punti 4).
         */

        int win = -1;
        String piuForte = "";
        // CodVitt
        for (Giocatore g : giocatori) {
            if (CodVitt.get(g.getCodice())>win) {
                win = CodVitt.get(g.getCodice());
                piuForte = g.getNome_e_cognome();
            }
        }
        System.out.println("Il giocatore che ha che ha vinto più partite è "+piuForte);
    }
}
