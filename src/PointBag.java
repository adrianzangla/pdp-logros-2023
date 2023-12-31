public class PointBag extends Item {
    //atributos: valor
    private int value;
    //constructor de "PointBag"
    public PointBag(String name, Integer price, int value) {
        super(name, price);
        this.value = value;
    }
    //metodo abstracto "use" que actualiza los puntos del usuario segun el valor de pointBag
    //luego elimina dicha bolsa de puntos del inventario
    @Override
    public void use(User user) {
        if (check(user)) {
            user.setPoints((int) (user.getPoints() + value * user.getActiveMembership().getMembership().getPointMultiplier()));
            user.getInventory().put(this, user.getInventory().get(this) - 1);
            check(user);
        }
    }

    @Override
    public boolean check(User user) {
        if (!user.getInventory().containsKey(this)) {
            return false;
        }
        if (user.getInventory().get(this) < 1) {
            user.getInventory().remove(this);
            return false;
        }
        return true;
    }

    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Puntos: " + value;
    }
}
