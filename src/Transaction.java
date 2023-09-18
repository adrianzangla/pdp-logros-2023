import java.util.List;

public class Transaction {
    //Atributos: desde,hasta,lista de objetos
    private Transactionable from;
    private Transactionable to;
    private final List<Item> items;
    //constructor de Transaccion
    public Transaction(Transactionable from, Transactionable to, List<Item> items) {
        this.from = from;
        this.to = to;
        this.items = items;
    }
    //metodo get que devuelve la lista de objetos a transferir
    public List<Item> getItems() {
        return items;
    }
    //metodo get que devuelve hacia que destinatario(usuario) se realiza la transaccion
    public Transactionable getTo() {
        return to;
    }



}
