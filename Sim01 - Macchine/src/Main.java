import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Concessionaria c = new Concessionaria();
        File f = new File("src\\ordini.txt");
        Scanner sc = new Scanner(f);
        String tipo;

        while (sc.hasNextLine()) {
            tipo = sc.next();
            if (tipo.equals("b")) {
                Berlina newMacc = new Berlina();
            //    System.out.println("berlina");
                newMacc.setNome_del_modello( sc.next());
                newMacc.setProduttore(sc.next());
                newMacc.setBagagliaio(sc.nextDouble());
                newMacc.setPeso(sc.nextInt());
                newMacc.setCodiceIdentificativo(sc.nextInt());
                c.ADD(newMacc);
            } else if (tipo.equals("f")) {
                Fuoristrada newMacc = new Fuoristrada();
            //    System.out.println("fuoristrada");
                newMacc.setNome_del_modello( sc.next());
                newMacc.setProduttore(sc.next());
                newMacc.setNumMerce(sc.nextInt());
                newMacc.setPeso(sc.nextInt());
                newMacc.setCodiceIdentificativo(sc.nextInt());
                c.ADD(newMacc);
            }
        }
        sc.close();
        c.stampa();
/**Il programma deve stampare a video il numero totale di auto per ciascuno dei seguenti range di 
peso: “800-1000”, “1000-1500”, “1500-2000”.
**/
        c.range(800,1000);
        c.range(1000,1500);
        c.range(1500,2000);
/*        
        4. Il programma deve infine leggere da riga di comando una marca di auto come stringa e 
        stampare l’elenco dei modelli di quella marca presenti nel file ordini.txt. 
*/
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserire Marca: ");
        String Marca = stdin.readLine();

        c.CercaMarca(Marca);
    }
}
