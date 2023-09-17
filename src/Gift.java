public class Gift extends Item {
    private Item item;

    public Gift(Item item) {
        super(item.getName() + "Gift", 1);
        this.item = item;
    }


    @Override
    public void use(User user) {
        user.getInventory().put(item, user.getInventory().getOrDefault(item, 0) + 1);
    }

    @Override
    public void buy(User user) {
        if (user.getPoints() >= price) {
            user.setPoints(user.getPoints() - price);
        }
    }

    @Override
    public void buy(User user, PaymentMethod payment) {

    }
}
