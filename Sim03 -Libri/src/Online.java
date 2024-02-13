

public class Online extends Transazione{
    String ip;

    public Online(String tipo, int identificativo, int data, String ip) {
        super(tipo, identificativo, data);
        this.ip = ip;
    }
    public String toString() {
        return Identificativo +" " + data + " "+ " - "  + ip +" "+ tot;
    }

}
