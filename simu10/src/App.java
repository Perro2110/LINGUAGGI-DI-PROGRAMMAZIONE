import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        List<Squadra> squadre = new LinkedList<Squadra>();
        try {
            sc = new Scanner(new File("squadre.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc.hasNext()) {
            String nome = sc.nextLine();
            int codice = sc.nextInt();
            String sport = sc.next();
            sc.nextLine();
            if (sport.equals("basket")) {
                int numero_partite_vinte = sc.nextInt();
                int numero_partite_perse = sc.nextInt();
                float punteggio_med = sc.nextFloat();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                Squadra s = new Basket(nome, codice, sport, numero_partite_vinte, numero_partite_perse, punteggio_med);
                squadre.add(s);
            } else {
                int numero_partite_vinte = sc.nextInt();
                int numero_partite_perse = sc.nextInt();
                float num_medio_set_vinti = sc.nextFloat();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                Squadra s = new Pallavolo(nome, codice, sport, numero_partite_vinte, numero_partite_perse,
                        num_medio_set_vinti);
                squadre.add(s);
            }
        }

        Scanner sc2;
        try {
            sc2 = new Scanner(new File("giocatori.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc2.hasNext()) {
            int cod_squad = sc2.nextInt();
            String cognome = sc2.next();
            int eta = sc2.nextInt();
            int numMaglia = sc2.nextInt();
            String ruolo = sc2.next();
            Boolean titBoolean = sc2.nextBoolean();
            Giocatore g = new Giocatore(cod_squad, cognome, eta, numMaglia, ruolo, titBoolean);

            for (Squadra s : squadre) {
                if (s.getCodice() == cod_squad) {
                    s.getGiocatori().add(g);
                }
            }
            if (sc2.hasNextLine()) {
                sc2.nextLine();
            }
        }
        System.out.println("nome della squadra, codice, n. partite vinte, n. partite perse, punteggio medio, n. medio di set vinti, sport");
        for (Squadra s : squadre) {
            System.out.println(s);
        }

        System.out.println(" ");
        for (Squadra s : squadre) {
            System.out.println(s.getNome_della_squadra()+" "+s.getGiocatori().size());
        }
        
        String nomeDaCercare=args[0]+" "+args[1];
        System.out.println("I giocatori della "+nomeDaCercare);
        for (Squadra s : squadre) {
            if(s.nome_della_squadra.equals(nomeDaCercare)){
                for(Giocatore g:s.getGiocatori()){
                    System.out.println(g);
                }
            }
        }

    }
}
