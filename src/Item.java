import java.util.LinkedList;
import java.util.List;

public abstract class Item {
    //Atributos: nombre del objeto,precio
    protected String name;
    protected Integer price;
    //constructor de "Item"
    public Item(String name, Integer price) {
        this.name = name;
    }
    //metodo "get" que devuelve el precio del objeto
    public Integer getPrice() {
        return price;
    }

    //metodo "get" que devuelve el nombre del objeto
    public String getName() {
        return name;
    }
    //metodo abstracto "use" que sera utilizado en las clases hijas de Item
    public abstract void use(User user);
    public void buy(User user) {
        if (user.getPoints() >= price) {
            user.setPoints(user.getPoints() - price);
            List<Item> itemList = new LinkedList<>();
            itemList.add(this);
            AchievementSystem.getStore().transfer(user, itemList);
        }
    }

    public void buy(User user, PaymentMethod payment) {
        if (payment.pay(this)) {
            user.getInventory().put(this, user.getInventory().getOrDefault(this, 0) + 1);
        }
    }

    @Override
    public String toString() {
        return "Objeto: " + name + '\n' +
                "Precio: " + price + '\n';
    }
}
