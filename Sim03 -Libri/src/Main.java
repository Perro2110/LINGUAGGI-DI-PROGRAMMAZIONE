import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Transazione> acquisti = new ArrayList<Transazione>();
        Map<String, Integer> copie = new HashMap<String, Integer>();

        File f = new File("src\\transazioni.txt");
        Scanner sc = new Scanner(f);

        // punto 1
        while (sc.hasNextLine()) {
            String tipo = sc.next();
            int identificativo = sc.nextInt();
            int data = sc.nextInt();
            if (tipo.equals("f")) {
                String citta_del_negozio = sc.next();
                sc.nextLine();
                fisica negozzioFisicoDiappoggio = new fisica(tipo, identificativo, data, citta_del_negozio);

                while (sc.hasNextLine() && !sc.hasNext("f") && !sc.hasNext("o")) {
                    String titolo = sc.nextLine();

                    Integer pezzi = copie.get(titolo);
                    if (pezzi == null)
                        copie.put(titolo, (1));
                    else
                        copie.put(titolo, (pezzi + 1));
                    String autore = sc.nextLine();
                    int prezzo = sc.nextInt();
                    Libro l = new Libro(titolo, autore, prezzo);
                    negozzioFisicoDiappoggio.Acquista(l);
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                acquisti.add(negozzioFisicoDiappoggio);
            } else {
                String ip = sc.next();
                sc.nextLine();
                Online negozzioOnlineDiappoggio = new Online(tipo, identificativo, data, ip);
                while (sc.hasNextLine() && !sc.hasNext("f") && !sc.hasNext("o")) {
                    String titolo = sc.nextLine();

                    Integer pezzi = copie.get(titolo);
                    if (pezzi == null)
                        copie.put(titolo, (1));
                    else
                        copie.put(titolo, (pezzi + 1));

                    String autore = sc.nextLine();
                    int prezzo = sc.nextInt();
                    Libro l = new Libro(titolo, autore, prezzo);
                    negozzioOnlineDiappoggio.Acquista(l);
                    if (sc.hasNextLine())
                        sc.nextLine();
                }
                acquisti.add(negozzioOnlineDiappoggio);
            }
        }
        // es 2
        System.out.println("ID Data Città IndirizzoIP Total");
        for (Transazione t : acquisti) {
            System.out.println(t);
        }

        //es 3
        System.out.println(" numero totale di copie vendute per ciascun libro");

        System.out.println(copie);

        // es 4
        int aaTot=0;
        for (Transazione t : acquisti) {
            aaTot+=t.getTot();
        }
        System.out.println(aaTot);

    }

}
