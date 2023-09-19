import java.util.LinkedList;
import java.util.List;

public class Transaction {
    //atributos: desde,hasta,lista de objetos
    private final Sender from;
    private final Receiver to;
    private final List<Item> items = new LinkedList<>();
    //constructor de "Transaccion"
    public Transaction(Sender from, Receiver to) {
        this.from = from;
        this.to = to;
    }
    //metodo "get" que devuelve la lista de objetos a transferir
    public List<Item> getItems() {
        return items;
    }
    //metodo "get" que devuelve hacia que destinatario(usuario) se realiza la transaccion
    public Receiver getTo() {
        return to;
    }

    public Sender getFrom() {
        return from;
    }
}
