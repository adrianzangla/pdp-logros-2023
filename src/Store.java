import java.util.LinkedList;
import java.util.List;

public class Store implements Sender {
    //atributos: lista de objetos
    private static final List<Item> items = new LinkedList<>();
    private static final int consumablesIndex = 18;
    //metodo "get" que devuelve la lista de items
    public static List<Item> getItems() {
        return items;
    }

    public static int getConsumablesIndex() {
        return consumablesIndex;
    }

    //metodo "transfer" que proviene de la interfaz Sender
    //realiza una transaccion hacia un usuario y guarda la misma en la lista de transacciones
    @Override
    public void transfer(Receiver to, List<Item> items) {
        Transaction transaction = new Transaction(this, to);
        transaction.getItems().addAll(items);
        AchievementSystem.addTransaction(transaction);
    }
}
