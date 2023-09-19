import java.util.LinkedList;
import java.util.List;

public class Store implements Sender {

    private static final List<Item> items = new LinkedList<>();

    public static List<Item> getItems() {
        return items;
    }

    @Override
    public void transfer(Receiver to, List<Item> items) {
        Transaction transaction = new Transaction(this, to);
        transaction.getItems().addAll(items);
        AchievementSystem.addTransaction(transaction);
    }
}
