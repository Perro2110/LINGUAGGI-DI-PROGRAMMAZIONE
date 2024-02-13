
/*
 * @ Perrotta Marco
 * 
 * Esecuzione es:
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String arr[]; // utile per fare arr=STRINGA.split(" ");
        Map<Integer, Float> incassi = new HashMap<Integer, Float>();
        Map<Integer, Campo> incassi2 = new HashMap<Integer, Campo>();

        // punto 1
        List<Campo> campi = new LinkedList<Campo>();
        File file = new File(
                "C:\\Users\\perro\\OneDrive\\Desktop\\Unife\\SecondoAnno\\Linguaggi di programmazione e Laboratorio\\Sim02 -Campi Con Split\\src\\campi.txt");                                                                                                                                                      // FILE..
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String appoString = sc.nextLine(); // OGNI RIGA LA LEGGO E SOLO DOPO LA SPLITTO E NE PRENDO LE INFO
            arr = appoString.split(" ");

            int codice = Integer.parseInt(arr[0]);

            String sport = arr[1];
            String nomeCampo = sc.nextLine();
            Campo appoCampo;

            if (sport.equals("tennis")) {
                appoString = sc.nextLine();
                arr = appoString.split(" ", 3);
                float larghezza = Float.parseFloat(arr[0]);
                float lunghezza = Float.parseFloat(arr[1]);
                float temperatura_media = Float.parseFloat(arr[2]);

                String terreno = sc.nextLine();
                String CostoOrario = sc.nextLine();
                float Costo = Float.parseFloat(CostoOrario);

                appoCampo = new Tennis(codice, sport, nomeCampo, larghezza, lunghezza, Costo, temperatura_media,
                        terreno);
                campi.add(appoCampo);
            } else {
                appoString = sc.nextLine();
                arr = appoString.split(" ", 5);
                float larghezza = Float.parseFloat(arr[0]);
                float Lunghezza = Float.parseFloat(arr[1]);
                float altezza = Float.parseFloat(arr[2]);
                int piano = Integer.parseInt(arr[3]);
                float costo = Float.parseFloat(arr[4]);
                appoCampo = new Squash(codice, sport, nomeCampo, larghezza, Lunghezza, costo, altezza, piano);
                campi.add(appoCampo);
            }
                incassi2.put(appoCampo.getCodice(),appoCampo);
        }
        sc.close();

        // punto 2
        List<Utente> Giocatori = new LinkedList<Utente>();
        File fileUtenti = new File(
                "C:\\Users\\perro\\OneDrive\\Desktop\\Unife\\SecondoAnno\\Linguaggi di programmazione e Laboratorio\\Sim02 -Campi Con Split\\src\\utenti.txt");
        Scanner sc2 = new Scanner(fileUtenti);

        while (sc2.hasNextLine()) {
            int codiceDelSocio = Integer.parseInt(sc2.nextLine());
            String NomeECognome = sc2.nextLine();

            String appoString2 = sc2.nextLine();
            arr = appoString2.split(" ");

            int eta = Integer.parseInt(arr[0]);
            int categoria = Integer.parseInt(arr[1]);

            appoString2 = sc2.nextLine();
            arr = appoString2.split(" ");
            int i = 0;
            Utente appoUtente = new Utente(codiceDelSocio, NomeECognome, eta, categoria);
            for (String el : arr) { // solo per scorrere
                if (i % 2 == 0) {
                    Prenotazione p = new Prenotazione();
                    p.setCodiceCampo(Integer.parseInt(arr[i]));

                    Float pezzi = incassi.get(Integer.parseInt(arr[i]));
                    if (pezzi == null)
                        incassi.put(Integer.parseInt(arr[i]), (float) 1);
                    else
                        incassi.put(Integer.parseInt(arr[i]), (pezzi + 1));

                    p.setOraInizio(Integer.parseInt(arr[i + 1]));
                    appoUtente.PRENOTA(p);
                } else {
                }
                i++;
            }
            Giocatori.add(appoUtente);
        }

        // es 3
        sc2.close();
        System.out.println(
                "sport , nome del campo, codice, larghezza, lunghezza,temperatura, terreno, altezza, piano, costo");
        for (Campo cm : campi) {
            System.out.println(cm);
        }

        // es 4
        System.out.println("codice, nome e cognome, età, categoria, prenotazioni");
        for (Utente ut : Giocatori) {
            System.out.println(ut);
        }

        // es 5
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserire Codice: ");
        int CodiceIns = Integer.parseInt(stdin.readLine());

        int c = 0;
        float p = 0;
        for (Utente u : Giocatori) {
            for (Prenotazione pr : u.getPrenotazioni())
                if (pr.getCodiceCampo() == CodiceIns) {
                    c++;
                }
        }
        for (Campo cmp : campi) {
            if (cmp.getCodice() == CodiceIns)
                p = cmp.getCosto_orario();
        }
        System.out.println(c * p);

        Campo p2= incassi2.get(Integer.parseInt(args[0]));
        Float c2 = incassi.get(Integer.parseInt(args[0]));
        System.out.println(c2 * p2.getCosto_orario());
    }
}
