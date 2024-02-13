import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc;
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        Map <Integer,Integer>CodiceNumero=new HashMap<Integer,Integer>();
        Map <Integer,Integer>CodiceMed=new HashMap<Integer,Integer>();
        try {
            sc = new Scanner(new File("inventario.txt"));
        } catch (FileNotFoundException e) {
            // se non esiste, lancio una eccezione
            throw e;
        }
        while (sc.hasNext()) {
            String tipo = sc.next();
            int codice = sc.nextInt();
            sc.nextLine();
            String modello = sc.nextLine();
            String produttore = sc.nextLine();
            String data = sc.nextLine();
            int prezzo = sc.nextInt();
            Prodotto p;
            sc.nextLine();
            if (tipo.equals("toner")) {
                String modello_stampante = sc.nextLine();
                p = new Toner(tipo, codice, modello, produttore, data, prezzo, modello_stampante);
            } else {
                int peso = sc.nextInt();
                p = new Stampante(tipo, codice, modello, produttore, data, prezzo, peso);
                sc.nextLine();
            }
            CodiceNumero.put(codice,0);
            CodiceMed.put(codice, 0);
            String line = sc.nextLine(); // PER AGGIUNGERE COSE A LISTA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                Scanner sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice_servizzio = sc3.nextInt();

                p.getNumeroPezzi().add(codice_servizzio);
                CodiceMed.put(codice,CodiceMed.get(codice)+1);
                CodiceNumero.put(codice,CodiceNumero.get(codice)+codice_servizzio);
                if (sc.hasNextLine())
                    line = sc.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            prodotti.add(p);
        }
        System.out.println("Tipo Codice Modello Produttore Data Prezzo ModelloStampante Peso");
        for(Prodotto p:prodotti){
            System.out.println(p);
        }
        for(Prodotto p:prodotti){
            System.out.println(p.getModello()+" "+CodiceNumero.get(p.getCodice()));
        }
    System.out.println("_______________________");
        for(Prodotto p:prodotti){
            System.out.println(p.getModello()+" "+(float)CodiceNumero.get(p.getCodice())/CodiceMed.get(p.getCodice()));
        }
    
    }
}
