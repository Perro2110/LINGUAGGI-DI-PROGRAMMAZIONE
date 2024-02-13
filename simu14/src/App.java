import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Partecipante> partecipanti = new LinkedList<Partecipante>();
        List<Conferenza> conferenze = new LinkedList<Conferenza>();
        Map<Integer, String> mapp = new HashMap<Integer, String>();
        Map<Integer, String> CodiceTipo = new HashMap<Integer, String>();
        Scanner sc, sc2;

        try {
            sc = new Scanner(new File("partecipanti.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNextLine()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            sc.nextLine();
            String nome = sc.nextLine();
            String cognome = sc.nextLine();
            CodiceTipo.put(codice,tipo);
            if (tipo.equals("studente")) {
                String nome_del_corso_di_studi = sc.nextLine();
                String nome_dell_universita = sc.nextLine();
                int anno = sc.nextInt();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                Partecipante p = new Studente(codice, tipo, nome, cognome, nome_del_corso_di_studi,
                        nome_dell_universita, anno);
                partecipanti.add(p);
                mapp.put(codice, nome_dell_universita);
            } else {
                String ente_di_appartenenza = sc.nextLine();
                int numero_dipendenti = sc.nextInt();
                Boolean accademico = sc.nextBoolean();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                Partecipante p = new Regolare(codice, tipo, nome, cognome, ente_di_appartenenza, numero_dipendenti,
                        accademico);
                partecipanti.add(p);
                mapp.put(codice, ente_di_appartenenza);
            }
        }
        sc.close();
        try {
            sc2 = new Scanner(new File("conferenze.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc2.hasNextLine()) {
            String nome_della_conferenza = sc2.nextLine();
            String luogo = sc2.nextLine();
            Conferenza c = new Conferenza(nome_della_conferenza, luogo);

            String line = sc2.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                Scanner sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice = sc3.nextInt(); // LEGGO
                int spesa = sc3.nextInt(); // INFO CHE MI SERVONO SU sc3
                Partecipo s = new Partecipo(codice, spesa); // CI FACCIO CIO CHE VOGLIO...
                for (Partecipante pp : partecipanti) {
                    if (pp.getCodice() == codice) {
                        s.setCognome(pp.getCognome());
                    }
                }
                c.getPresenti().add(s);

                c.incTotSpesa(spesa);
                // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                if (sc2.hasNextLine())
                    line = sc2.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            conferenze.add(c);
        }
        /*
         * 3. Il programma deve stampare a video l’elenco di tutti i partecipanti in una
         * tabella con
         * queste intestazioni:
         * tipo, codice, nome, cognome, corso di studi, università, anno di
         * corso, ente di appartenenza, numero di dipendenti, accademico
         * Per gli attributi che non si applicano ad un progetto (ente di appartenenza,
         * numero
         * di dipendenti, accademico per gli studenti e corso di studi, università,
         * anno di corso per i partecipanti regolari) si stampi “-” . Per il tipo si
         * stampi studente o
         * regolare rispettivamente per i partecipanti studenti e regolari (punti 6
         */
        System.out.println(
                "tipo,\tcodice,\tnome,\tcognome,\tcorso di studi,\tuniversità,\tanno di corso,\tente di appartenenza,\tnumero di dipendenti,\taccademico");
        for (Partecipante p : partecipanti) {
            System.out.println(p);
        }

        /*
         * Il programma deve stampare a video, per ciascuna conferenza, il suo nome, il
         * suo luogo e il
         * totale delle spese di iscrizione, il numero di partecipanti e l’elenco dei
         * partecipanti nella
         * forma (cognome, spese di iscrizione). (punti 6).
         */

        System.out.println();
        for (Conferenza c : conferenze) {
            System.out.println(c.getNomeConferenza() + " ");
            System.out.println(c.getLuogo() + " ");
            System.out.println(c.getTotSpesa() + " " + c.getPresenti().size());
            System.out.println(c.getPresenti());
        }
        /*
         * Il programma deve leggere da tastiera il codice di un partecipante e dire se
         * è regolare o studente. Nel caso sia regolare, stampare il suo ente di
         * appartenenza, nel
         * caso sia studente,
         * stampare la sua università (punti 4).
         */

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserire Codice: ");
        String Codice = stdin.readLine();
        System.out.println(CodiceTipo.get(Integer.parseInt(Codice))+" "+mapp.get(Integer.parseInt(Codice)));
    }
}
