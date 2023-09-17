public class GameItem extends Item {
    private Game game;
    private double multiplier;

    public GameItem(String name, Integer price, Game game, double multiplier) {
        super(name, price);
        this.game = game;
        this.multiplier = multiplier;
    }

    @Override
    public void use(User user) {
        user.getMultipliers().put(game, multiplier);
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
