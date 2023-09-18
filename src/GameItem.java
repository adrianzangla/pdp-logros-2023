public class GameItem extends Item {
    //Atributos: juego,multiplicador
    private Game game;
    private double multiplier;
    //constructor de GameItem
    public GameItem(String name, Integer price, Game game, double multiplier) {
        super(name, price);
        this.game = game;
        this.multiplier = multiplier;
    }

    @Override
    //metodo abstracto use que proviene de Item
    //ubica en el map de multiplier el multiplicador que se le aplica al juego
    public void use(User user) {
        user.getMultipliers().put(game, multiplier);
    }

    @Override
    //metodo toString que devuelve la forma en la que va a imprimir lo que se le indica
    public String toString() {
        return "GameItem{" +
                "game=" + game +
                ", multiplier=" + multiplier +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
