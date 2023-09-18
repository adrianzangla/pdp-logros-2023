public class PointBag extends Item {
    private int value;
    public PointBag(String name, Integer price, int value) {
        super(name, price);
        this.value = value;
    }

    @Override
    public void use(User user) {
        user.setPoints((int) (user.getPoints() + value * user.getActiveMembership().getMembership().getPointMultiplier()));
    }

}
