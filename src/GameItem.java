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
    public String toString() {
        return "GameItem{" +
                "game=" + game +
                ", multiplier=" + multiplier +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
