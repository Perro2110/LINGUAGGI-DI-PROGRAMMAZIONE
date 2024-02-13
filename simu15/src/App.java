import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Scontrino> scontini = new LinkedList<Scontrino>();
        Scanner sc;
        Map<String, Integer> DescrizioneTotale = new HashMap<String, Integer>();
        Map<Integer,Integer> CodPrTot=new HashMap<Integer,Integer>();

        try {
            sc = new Scanner(new File("scontrini.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }

        while (sc.hasNextLine()) {
            String tipo = sc.next();
            int id = sc.nextInt();
            sc.nextLine();
            String giornoMeseAnno = sc.nextLine();
            Scontrino s;
            if (tipo.equals("privato")) {
                String nome_e_cognome = sc.nextLine();
                String indirizzo = sc.nextLine();
                String codFisc = sc.next();
                int codiceCliente = sc.nextInt();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                s = new Scontrino_privato(tipo, id, giornoMeseAnno, codiceCliente, nome_e_cognome, indirizzo, codFisc);
            } else {
                String ragione_sociale = sc.nextLine();
                int partita_iva = sc.nextInt();
                sc.nextLine();
                int codiceCliente = sc.nextInt();
                sc.nextLine();
                String indirizzo = sc.nextLine();
                s = new Scontrino_azienda(tipo, id, giornoMeseAnno, codiceCliente, ragione_sociale, partita_iva, indirizzo);
            
                }

            if (sc.hasNextLine()) {
                String line = sc.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
                while (!line.equals("")) {
                    String descrizione = line;
                    int numProdotti = sc.nextInt(); // LEGGO
                    int prezzo = sc.nextInt(); // INFO CHE MI SERVONO SU sc3
                    if (sc.hasNextLine())
                        sc.nextLine();
                    Prodotto p = new Prodotto(descrizione, numProdotti, prezzo);

                    Integer count = DescrizioneTotale.get(descrizione);
                    if (count == null)
                        DescrizioneTotale.put(descrizione, numProdotti * prezzo);
                    else
                        DescrizioneTotale.put(descrizione, ((DescrizioneTotale.get(descrizione)) + numProdotti * prezzo));

                    Integer count2 = CodPrTot.get(s.getCodiceCliente());
                    if (count2 == null)
                        CodPrTot.put(s.getCodiceCliente(),numProdotti * prezzo);
                    else
                        CodPrTot.put(s.getCodiceCliente(),CodPrTot.get(s.getCodiceCliente())+ numProdotti * prezzo);
                    
                        
                    s.getProdotti().add(p);

                    // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                    if (sc.hasNextLine())
                        line = sc.nextLine();
                    else {
                        line = "";
                    }
                }
            }
            scontini.add(s);
        }
        /*
         * 2. Il programma deve stampare a video l’elenco degli scontrini in una tabella
         * con queste
         * intestazioni:
         * ID Data Nome/Cognome Indirizzo CodiceFiscale RagioneSociale PartitaIva
         * CodiceCliente
         * Per gli attributi che non si applicano ad uno scontrino (Nome/Cognome e
         * CodiceFiscale
         * per le aziende e RagioneSociale e PartitaIva per i privati) si stampi “-”
         * (punti 4)
         */

        System.out.println(
                "ID\tData\t\tNome/Cognome\tIndirizzo\tCodiceFiscale\tRagioneSociale\tPartitaIva\tCodiceCliente\tDescrizione\tQuantità\tPrezzo Totale");
        for (Scontrino s : scontini) {
            System.out.println(s);

        }
        System.out.println("Descrizione\tQuantità\tPrezzo Totale");
        for (Scontrino s : scontini) {
            System.out.println(s.getProdotti());
        }

        /*
         * Il programma deve stampare a video l’elenco dei prodotti acquistati in una
         * tabella con
         * queste intestazioni:
         * Descrizione Quantità Prezzo Totale
         * dove il totale è dato dal prezzo per la quantità (punti 4). Questa stampa è
         * la concatenazione dell’elenco dei prodotti di ciascuno scontrino (SOPRA)
         */

        /*
         * 4. Il programma deve stampare a video l’elenco dei prodotti acquistati in una
         * tabella con
         * queste intestazioni:
         * Descrizione Totale
         * In questo elenco, ciascun prodotto (identificato dalla sua descrizione) deve
         * apparire una
         * sola volta e il totale è dato dalla somma dei totali (vedi definizione sopra)
         * riferiti a quel
         * prodotto in tutti gli scontrini (punti 4).
         */
        System.out.println();
        System.out.println(DescrizioneTotale);

        /*
         * 5. Il programma deve infine leggere da riga di comando un codice cliente e
         * stampare il totale
         * degli scontrini del cliente, ottenuto sommando il totale (vedi definizione
         * sopra) di ciascun prodotto acquistato dal cliente (punti 4)
         */
        String cod=args[0];
        System.out.println(CodPrTot.get(Integer.parseInt(cod)));

    }
}
