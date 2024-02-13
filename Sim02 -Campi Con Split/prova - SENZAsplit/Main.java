/*
 * @ Perrotta Marco
 * 
 * Esecuzione es:
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // punto 1
        List<Campo> campi = new LinkedList<Campo>();
        File file = new File("campi.txt"); //IL PATH NAME VARIA A SECONDA DI DOVE SI TROVA IL FILE..
        Scanner sc = new Scanner(file);
        
        while (sc.hasNextLine()) {
//            String appoString = sc.nextLine(); //OGNI RIGA LA LEGGO E SOLO DOPO LA SPLITTO E NE PRENDO LE INFO
//          arr = appoString.split(" ");

            int codice =sc.nextInt();
            String sport = sc.next();
            sc.nextLine();
            String nomeCampo = sc.nextLine();
            if (sport.equals("tennis")) {

                float larghezza = sc.nextFloat();
                float lunghezza = sc.nextFloat();
                float temperatura_media = sc.nextFloat();
                sc.nextLine();
                String terreno = sc.nextLine();
                float Costo = sc.nextFloat();

                Tennis appoCampo = new Tennis(codice, sport, nomeCampo, larghezza, lunghezza, Costo, temperatura_media,
                        terreno);
                campi.add(appoCampo);
            } else {
                float larghezza = sc.nextFloat();
                float Lunghezza = sc.nextFloat();
                float altezza = sc.nextFloat();
                int piano = sc.nextInt();
                float costo = sc.nextFloat();
                Squash appoCampo = new Squash(codice, sport, nomeCampo, larghezza, Lunghezza, costo, altezza, piano);
                campi.add(appoCampo);
            }
        }
        sc.close();


        // punto 2
        List<Utente> Giocatori = new LinkedList<Utente>();
        File fileUtenti = new File("utenti.txt");
        Scanner sc2 = new Scanner(fileUtenti);

        while (sc2.hasNextLine()) {
            int codiceDelSocio = sc2.nextInt();
            sc2.nextLine();
            String NomeECognome = sc2.nextLine();

            int eta =sc2.nextInt();
            int categoria = sc2.nextInt();
            sc2.nextLine();
            String appoString2 = sc2.nextLine();
            String arr[] = appoString2.split(" ");
            int i = 0;
            Utente appoUtente = new Utente(codiceDelSocio, NomeECognome, eta, categoria);
            for (String el : arr) { // solo per scorrere
                if (i % 2 == 0) {
                    Prenotazione p = new Prenotazione();
                    p.setCodiceCampo(Integer.parseInt(arr[i]));
                    p.setOraInizio(Integer.parseInt(arr[i + 1]));
                    appoUtente.getPrenotazioni().add(p);
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
    }
}
