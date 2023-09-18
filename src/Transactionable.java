import java.util.List;

public interface Transactionable {
    public void transfer(Transactionable to, List<Item> items);
    public void receive(List<Item> items);
}
