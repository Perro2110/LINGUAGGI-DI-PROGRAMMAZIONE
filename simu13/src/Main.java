/*8.00 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Corso> corsi = new LinkedList<Corso>();
        List<Studente> studenti = new LinkedList<Studente>();
        Map<Integer, String> codiceNome = new HashMap<Integer, String>();
        Scanner sc, sc2;

        try {
            sc = new Scanner(new File("corsi.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNextLine()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            sc.nextLine();
            String nome_del_corso = sc.nextLine();
            String nome_e_cognome_del_docente = sc.nextLine();

            if (tipo.equals("teoria")) {
                int codice_aula = sc.nextInt();
                int numero_ore_settimanali = sc.nextInt();
                double numer_ore_per_lezione = sc.nextDouble();

                if (sc.hasNextLine()) {
                    sc.nextLine();
                }

                Corso corsoappo = new Teoria(codice, tipo, nome_del_corso, nome_e_cognome_del_docente, codice_aula,
                        numero_ore_settimanali, numer_ore_per_lezione);
                corsi.add(corsoappo);
                codiceNome.put(codice, nome_del_corso);
            } else {
                String nomeLaboratorio = sc.nextLine();
                String nomeAssistente = sc.nextLine();
                int num__postazioni_nel_laboratorio = sc.nextInt();

                if (sc.hasNextLine()) {
                    sc.nextLine();
                }

                Corso corsoappo = new Laboratorio(codice, tipo, nome_del_corso, nome_e_cognome_del_docente,
                        nomeLaboratorio, nomeAssistente, num__postazioni_nel_laboratorio);
                corsi.add(corsoappo);
                codiceNome.put(codice, nome_del_corso);
            }
        }
        sc.close();

        try {
            sc2 = new Scanner(new File("studenti.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc2.hasNextLine()) {
            int matricola = sc2.nextInt();
            sc2.nextLine();
            String nome_cognome = sc2.nextLine();

            Studente sappo = new Studente(matricola, nome_cognome);

            String line = sc2.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                Scanner sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice_corso = sc3.nextInt(); // LEGGO
                String voto = sc3.next(); // INFO CHE MI SERVONO SU sc3
                Voto v = new Voto(codice_corso, voto); // CI FACCIO CIO CHE VOGLIO...
                sappo.insVoto(voto, codice_corso);
                sappo.getLibretto().add(v);

                // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                if (sc2.hasNextLine())
                    line = sc2.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            studenti.add(sappo);
        }
        /*
         * 3. Il programma deve stampare a video l’elenco di tutti i corsi in una
         * tabella con queste
         * intestazioni:
         * nome, codice, docente, tipo, aula, ore sett., ore/lez., lab.,
         * assistente, postazioni
         * Per gli attributi che non si applicano ad un corso (lab., assistente,
         * postazioni
         * per i corsi di teoria e aula, ore sett., ore/lez. per i corsi di laboratorio)
         * si
         * stampi “-” . Per il tipo si stampi teoria o lab. (punti 6).
         */
        System.out.println(
                "nome,\tcodice,\tdocente,\ttipo,\taula,\tore sett.,\tore/lez.,\tlab.,\tassistente,\tpostazioni");
        for (Corso c : corsi) {
            System.out.println(c);
        }

        System.out.println();
        for (Studente c : studenti) {
            System.out.println(c);
        }

        /*
         * Il programma deve leggere da riga di comando il codice di uno studente e
         * stampare il
         * nome e cognome dello studente, il nome del corso in cui ha preso il voto più
         * alto e
         * il voto (punti 4).
         */
        int matt = Integer.parseInt(args[0]);
        for (Studente s : studenti) {
            if (s.getMatricola() == matt) {
                System.out.println(
                        s.getNome_e_cognome() + " " + codiceNome.get(s.getCodice_corsoMax()) + " " + s.getVotoMax());
            }
        }

    }
}
