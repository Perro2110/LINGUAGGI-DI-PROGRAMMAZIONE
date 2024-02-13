import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Squadra> squadre = new LinkedList<Squadra>();
        List<Giocatore> giocatori = new LinkedList<Giocatore>();
        Map<Integer, String> CodNome = new HashMap<Integer, String>();

        float NumVinteHockey = 0;
        float NumDisputateHockey = 0;

        float NumVintePallamano = 0;
        float NumDisputatePallamano = 0;

        Scanner sc;
        try {
            sc = new Scanner(new File("squadre.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc.hasNextLine()) {
            int codice = sc.nextInt();
            String sport = sc.next();
            sc.nextLine();
            String nome_squadra = sc.nextLine();

            if (sport.equals("hockey")) {
                int num_partite_vinte = sc.nextInt();
                int num_partite_perse = sc.nextInt();
                double numero_medio_goal = sc.nextDouble();
                double numero_medio_di_falli_a_partita = sc.nextDouble();

                if (sc.hasNextLine())
                    sc.nextLine();
                if (sc.hasNextLine())
                    sc.nextLine();

                Squadra s = new Hockey(codice, sport, nome_squadra, num_partite_vinte, num_partite_perse,
                        numero_medio_goal, numero_medio_di_falli_a_partita);
                squadre.add(s);
                CodNome.put(codice, nome_squadra);

                NumVinteHockey += num_partite_vinte;
                NumDisputateHockey++;

            } else {
                int num_partite_vinte = sc.nextInt();
                int num_partite_perse = sc.nextInt();
                double numero_medio_goal_fatti = sc.nextDouble();

                if (sc.hasNextLine())
                    sc.nextLine();
                if (sc.hasNextLine())
                    sc.nextLine();

                Squadra s = new Pallamano(codice, sport, nome_squadra, num_partite_vinte, num_partite_perse,
                        numero_medio_goal_fatti);
                squadre.add(s);
                CodNome.put(codice, nome_squadra);

                NumVintePallamano += num_partite_vinte;
                NumDisputatePallamano++;
            }
        }
        sc.close();
        Scanner sc2;
        try {
            sc2 = new Scanner(new File("giocatori.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc2.hasNextLine()) {
            int codice_squadra = sc2.nextInt();
            sc2.nextLine();
            String cognome = sc2.nextLine();
            String nome = sc2.nextLine();
            int eta = sc2.nextInt();
            int num_maglia = sc2.nextInt();
            String ruolo = sc2.next();
            Boolean titolare = sc2.nextBoolean();
            Giocatore g = new Giocatore(codice_squadra, cognome, nome, eta, num_maglia, ruolo, titolare);
            giocatori.add(g);
            if (sc2.hasNextLine()) {
                sc2.nextLine();
            }
        }
        sc2.close();
        /*
         * 3. Il programma deve stampare a video l’elenco di tutte le squadre della
         * polisportiva in una
         * tabella con queste intestazioni:
         * nome della squadra, codice, n. partite vinte, n. partite perse,
         * n. medio di gol, n. medio di falli, n. medio di reti, sport
         * Per gli attributi che non si applicano ad una squadra (n. medio di gol e
         * numero medio di falli
         * per le squadre di pallamano e n. medio di reti per le squadre di hockey) si
         * stampi “-” . Per
         * sport si stampi hockey o pallamano a seconda del tipo di squadra (punti 5)
         */
        System.out.println(
                "nome della squadra, codice, n. partite vinte, n. partite perse,n. medio di gol, n. medio di falli, n. medio di reti, sport");
        for (Squadra s : squadre) {
            System.out.println(s);
        }
        /*
         * l programma deve stampare a video l’elenco dei giocatori in una tabella con
         * queste
         * intestazioni
         * nome, cognome, età, numero di maglia, ruolo, titolare, nome
         * squadra
         */
        System.out.println();
        System.out.println(
                "nome,\tcognome,\tetà,\tnumero di maglia,\truolo,\ttitolare,\tnome squadra");
        for (Giocatore s : giocatori) {
            System.out.print(s);
            System.out.println(CodNome.get(s.getCodice_squadra()));
        }

        /*
         * l programma stampare a video il numero medio di partite vinte per sport,
         * ovvero deve fare la
         * media delle partite vinte per le squadre di hockey e per quelle di pallamano
         * e stampare le due medie (punti 4)
         *
         */
        System.out.println("media parte vinte delle squadre di hockey:" + NumVinteHockey / NumDisputateHockey);
        System.out.println("media parte vinte delle squadre di pallamano:" + NumVintePallamano / NumDisputatePallamano);
    }
}
