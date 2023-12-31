public class GameItem extends Item {
    //Atributos: juego,multiplicador
    private final Game game;
    private double multiplier;
    //constructor de "GameItem"
    public GameItem(String name, Integer price, Game game, double multiplier) {
        super(name, price);
        this.game = game;
        this.multiplier = multiplier;
    }

    @Override
    //metodo abstracto "use" que proviene de Item
    //ubica en el map de multiplier el multiplicador que se le aplica al juego
    public void use(User user) {
        if (check(user)) {
            user.getMultipliers().put(game, multiplier);
        }
    }

    @Override
    public boolean check(User user) {
        if (!user.getInventory().containsKey(this)) {
            unequip(user);
            return false;
        }
        if (user.getInventory().get(this) < 1) {
            user.getInventory().remove(this);
            unequip(user);
            return false;
        }
        return true;
    }

    private void unequip(User user) {
        user.getMultipliers().remove(game);
    }

    @Override
    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    public String toString() {
        return super.toString() + "\n" +
                "Juego: " + game.getName() + "\n" +
                "Ventaja: x" + multiplier + "\n";
    }
}

