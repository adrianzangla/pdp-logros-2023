import java.util.LinkedList;
import java.util.List;

public abstract class Item {
    //Atributos: nombre del objeto,precio
    protected String name;
    protected int price;
    //constructor de "Item"
    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    //metodo "get" que devuelve el precio del objeto
    public int getPrice() {
        return price;
    }

    //metodo "get" que devuelve el nombre del objeto
    public String getName() {
        return name;
    }
    //metodo abstracto "use" que sera utilizado en las clases hijas de Item
    public abstract void use(User user);
    //
    protected boolean check(User user) {
        if (!user.getInventory().containsKey(this)) {
            return false;
        }
        if (user.getInventory().get(this) < 1) {
            user.getInventory().remove(this);
            return false;
        }
        return true;
    }
    //"buy" es un metodo polimorfico
    //metodo "buy" que le permite al usuario comprar un objeto con los puntos
    public void buy(User user) throws AchievementSystemException {
        if (user.getPoints() >= price) {
            user.setPoints(user.getPoints() - price);
            List<Item> itemList = new LinkedList<>();
            itemList.add(this);
            AchievementSystem.getStore().transfer(user, itemList);
        } else {
            throw new AchievementSystemException("No tenés suficientes puntos");
        }
    }
    //metodo "buy" que le permite al usuario comprar un objeto con el medio de pago elegido
    public void buy(User user, PaymentMethod payment) throws AchievementSystemException {
        if (payment.pay(this)) {
            List<Item> itemList = new LinkedList<>();
            itemList.add(this);
            AchievementSystem.getStore().transfer(user, itemList);
        } else {
            throw new AchievementSystemException("No tenés suficientes dinero");
        }
    }

    @Override
    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    public String toString() {
        return "Objeto: " + name + '\n' +
                "Precio: " + price + '\n';
    }
}
