import java.util.ArrayList;
import java.util.List;

public class ItemTransaction  extends Transaction{
    private  List<Item> items=new ArrayList<>();

    public ItemTransaction(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
