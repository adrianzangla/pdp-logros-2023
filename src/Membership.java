import java.util.List;

public class Membership extends Item {
    //atributos: multiplicador de puntos,duracion de la membresia,numero de membresia(cada membresia será referenciada por un numero entre 0 y 2)
    private static final Membership defaultMembership = new Membership("Regular", 0, 1d, -1, 0);
    private double pointMultiplier;
    private int time;

    private int tier;
    //metodo "get" que devuelve la membresia que tiene el usuario por defecto
    public static Membership getDefaultMembership() {
        return defaultMembership;
    }
    //constructor de "Membership"
    public Membership(String name, int price, double pointMultiplier, int time, int tier) {
        super(name, price);
        this.pointMultiplier = pointMultiplier;
        this.time = time;
        this.tier = tier;
    }
    //metodo "get" que devuelve el multiplicador de puntos que ofrece la membresia
    public double getPointMultiplier() {
        return pointMultiplier;
    }
    //metodo "get" que devuelvela el tiempo que dura la membresia
    public int getTime() {
        return time;
    }
    //metodo "get" que devuelve el numero que referencia a la membresia
    public int getTier() {
        return tier;
    }
    //metodo "use" actualiza la membresia activa
    //luego saca la membresia del inventario ya que fue utilizada
    @Override
    public void use(User user) {
        if (check(user)) {
            if (user.getActiveMembership().getMembership().getTier() < tier) {
                user.setActiveMembership(this);
            } else {
                user.getActiveMembership().setHoursLeft(user.getActiveMembership().getHoursLeft() + 15*24);
            }
            user.getInventory().put(this, user.getInventory().get(this) - 1);
        }
        check(user);
    }

}
