public abstract class Item {

    protected String name;
    protected Integer price;

    public Integer getPrice() {
        return price;
    }

    public Item(String name, Integer price) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void use(User user);

    public void buy(User user) {
        if (user.getPoints() >= price) {
            user.getInventory().put(this, user.getInventory().getOrDefault(this, 0) + 1);
            user.setPoints(user.getPoints() - price);
        }
    }

    public void buy(User user, PaymentMethod payment) {
        if (payment.pay(this)) {
            user.getInventory().put(this, user.getInventory().getOrDefault(this, 0) + 1);
        }
    }
}
