import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File f = new File("dipendenti.txt");
        Scanner sc = new Scanner(f);
        List<Dipendente> dipendenti = new ArrayList<Dipendente>();
        List<Cliente> clienti = new ArrayList<Cliente>();

        Map<Integer, Dipendente> md = new HashMap<Integer, Dipendente>();
        Map<Integer, Integer> mc = new HashMap<Integer, Integer>();

        // es 1
        while (sc.hasNext()) {
            int codice = sc.nextInt();
            String tipo = sc.next();
            sc.nextLine();
            String nome_del_dipendente = sc.nextLine();
            if (tipo.equals("trainer")) {
                int ore_settimanali = sc.nextInt();
                double costo_orario = sc.nextDouble();
                sc.nextLine();
                String specialita = sc.nextLine();
                Dipendente dAppo = new Trainer(codice, costo_orario, tipo, nome_del_dipendente, ore_settimanali,
                        specialita);
                dipendenti.add(dAppo);
                md.put(codice, dAppo);
            } else {
                long numTelefono = sc.nextLong();
                Boolean b = sc.nextBoolean();
                int appuntamenti_settimanali = sc.nextInt();
                double costo_orario = sc.nextDouble();
                if (sc.hasNext())
                    sc.nextLine();
                Dipendente dAppo = new Nutrizionista(codice, costo_orario, tipo, nome_del_dipendente, numTelefono, b,
                        appuntamenti_settimanali);
                dipendenti.add(dAppo);
                md.put(codice, dAppo);
            }
        }
        sc.close();

        // es 2
        File f2 = new File("clienti.txt");
        Scanner sc2 = new Scanner(f2);

        while (sc2.hasNext()) {
            int codiceCliente = sc2.nextInt();
            sc2.nextLine();
            String nomeCliente = sc2.nextLine();
            Cliente clienteAppo = new Cliente(codiceCliente, nomeCliente);

            /*******************************************************************************************************************
            *******************************************************************************************************************/
            String line = sc2.nextLine(); // PER AGGIUNGERE COSE A LISTA DI PERSONA FINO A INVIO CASUALONE!
            while (!line.equals("")) {
                Scanner sc3 = new Scanner(line); // LAVORA SULLA LINEA APPENA LETTA

                int codice_servizzio = sc3.nextInt(); // ..
                double num_ore = sc3.nextDouble(); // ...

                Integer count = mc.get(codice_servizzio);
                if (count == null)
                    mc.put(codice_servizzio, 1);
                else
                    mc.put(codice_servizzio, (count + 1));

                servizi s = new servizi(codice_servizzio, num_ore);
                clienteAppo.getServizii().add(s);

                // PER CONTINUARE FINO ALLA FINE / AL PROSSIMO INVIO
                if (sc2.hasNextLine())
                    line = sc2.nextLine();
                else {
                    line = "";
                    sc3.close();
                }
            }
            clienti.add(clienteAppo);
            /*******************************************************************************************************************
            *******************************************************************************************************************/
        }
        sc2.close();

        // es 3
        System.out
                .println("nome, codice, tipo, ore settimanali, specialità, telefono, medico, app.sett., costo orario");
        for (Dipendente dip : dipendenti) {
            System.out.println(dip);
        }
        /*
         * Il programma deve stampare a video, per ciascun cliente, il suo codice, il
         * suo nome e il
         * totale del costo dei servizi che ha utilizzato, ottenuto sommando i costi dei
         * singoli servizi,
         * a loro volta ottenuti moltiplicando il numero di ore del servizio per il
         * costo orario del
         * dipendente che ha svolto il servizio
         */
        for (Cliente c : clienti) {
            int cod = c.getCodice_del_cliente();
            String nome = c.getNome_del_cliente();
            float sum = 0;
            for (servizi s : c.getServizii()) {
                int cdd = s.getCodice_dipendente();
                sum += (s.getNumero_di_ore_del_servizio() * (md.get(cdd).getCosto_orario()));
            }
            System.out.println(cod + " " + nome + ":" + sum);
        }
        /*
         * l programma stampare a video il nome del dipendente che ha svolto il maggior
         * numero di
         * servizi (punti 4).
         */

        System.out.println();

        int max = 0;
        String pollo = null;
        for (Dipendente d : dipendenti) {
            int gg = mc.get(d.getCodice());
            if (gg >= max) {
                max = gg;
                pollo = d.getNome_dipendente();
            }
        }
        System.out.println(pollo + " " + max);

    }
}
