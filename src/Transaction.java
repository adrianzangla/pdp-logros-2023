import java.util.List;

public class Transaction {
    private Transactionable from;
    private Transactionable to;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public Transactionable getTo() {
        return to;
    }

    public Transaction(Transactionable from, Transactionable to, List<Item> items) {
        this.from = from;
        this.to = to;
        this.items = items;
    }


}
