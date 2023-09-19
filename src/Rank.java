public class Rank extends Item {
    //atributos: rango,numero de rango(cada rango será referenciado por un numero entre 0 y 2)
    private static final Rank defaultRank = new Rank("Noob", 0, 0);
    private int tier;
    //constructor de "Rank"
    public Rank(String name, Integer price, int tier) {
        super(name, price);
        this.tier = tier;
    }
    //metodo "get" que devuelve el rango por defecto
    public static Rank getDefaultRank() {
        return defaultRank;
    }
    //metodo "get" que devuelve el numero que referencia al rango
    public int getTier() {
        return tier;
    }


    @Override
    //metodo abstracto "use" que proviene de Item
    //si los puntos del usuario son menores al precio del rango,retorna para que no haga nada ya que no lo puede comprar
    //si no,utiliza el metodo set para actualizar el rango del usuario
    public void use(User user) {
        user.setRank(this);
        user.getInventory().put(this, user.getInventory().get(this) - 1);
    }
}
