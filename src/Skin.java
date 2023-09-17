public class Skin extends Item {
    private String content;

    public Skin(String name, Integer price, String content) {
        super(name, price);
        this.content = content;
    }

    @Override
    public void use(User user) {
        user.setNameStyle(content.replaceFirst("username", user.getName()));
    }

    @Override
    public void buy(User user) {
        if (user.getPoints() >= price) {
            user.getInventory().put(this, user.getInventory().getOrDefault(this, 0) + 1);
            user.setPoints(user.getPoints() - price);
        }
    }

    @Override
    public void buy(User user, PaymentMethod payment) {
        if (payment.pay(this)) {
            user.getInventory().put(this, user.getInventory().getOrDefault(this, 0) + 1);
        }
    }
}
