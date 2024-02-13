import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Prodotto> acquisti = new ArrayList<Prodotto>();
        Map <String,Integer> copie=new HashMap<String,Integer>();
        File f = new File("src\\vendite.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String tipo = sc.next();
            int codice = sc.nextInt();
            sc.nextLine();
            String titolo = sc.nextLine();
            String autore = sc.nextLine();

            Integer pezzi = copie.get(autore);
            if (pezzi == null)
                copie.put(autore, (1));
            else
                copie.put(autore, (pezzi + 1));

            int prezzo = sc.nextInt();
            sc.nextLine();
            if (tipo.equals("libro")) {
                String ISBN = sc.nextLine();
                Libro libAppo = new Libro(tipo, codice, titolo, autore, prezzo, ISBN);
                acquisti.add(libAppo);
            } else {
                int durata = sc.nextInt();
                if(sc.hasNextLine())
                    sc.nextLine();
                Cd cdAppo = new Cd(tipo, codice, titolo, autore, prezzo, durata);
                acquisti.add(cdAppo);
            }

        }
        System.out.println("Tipo Codice Titolo Autori Prezzo ISBN Durata");
        for(Prodotto p:acquisti){
            System.out.println(p);
        }
        //Il programma deve stampare a video il numero totale di prodotti per ciascun autore
        System.out.println(copie);

        /*l programma deve infine stampare il prezzo medio dei prodotti (somma dei prezzi/numero dei prodotti). */
        float c=0;
        int som=0;
        for(Prodotto p:acquisti){
            c++;
            som+=p.getPrezzo();
        }
        System.out.println(som/c);
    }
}
