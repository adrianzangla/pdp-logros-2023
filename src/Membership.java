import java.util.List;

public class Membership extends Item {
    private static final Membership defaultMembership = new Membership("Regular", 0, 1d, -1);
    private double pointMultiplier;
    private int time;

    public static Membership getDefaultMembership() {
        return defaultMembership;
    }

    public Membership(String name, int price, double pointMultiplier, int time) {
        super(name, price);
    }

    public double getPointMultiplier() {
        return pointMultiplier;
    }

    public int getTime() {
        return time;
    }

    @Override
    public void use(User user) {
        user.setActiveMembership(this);
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
            user.setActiveMembership(this);
        }
    }

}
