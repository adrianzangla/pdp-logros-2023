public class PointBag extends Item {
    private int value;
    public PointBag(String name, Integer price, int value) {
        super(name, price);
        this.value = value;
    }

    @Override
    public void use(User user) {
        if (check(user)) {
            user.setPoints((int) (user.getPoints() + value * user.getActiveMembership().getMembership().getPointMultiplier()));
            user.getInventory().put(this, user.getInventory().get(this) - 1);
        }
        check(user);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Puntos: " + value;
    }
}
