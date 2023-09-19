import java.util.List;

public interface Sender {
    public void transfer(Receiver to, List<Item> items);
}
