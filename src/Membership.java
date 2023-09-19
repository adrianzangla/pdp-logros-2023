import java.util.List;

public class Membership extends Item {
    private static final Membership defaultMembership = new Membership("Regular", 0, 1d, -1, 0);
    private double pointMultiplier;
    private int time;

    private int tier;

    public static Membership getDefaultMembership() {
        return defaultMembership;
    }

    public Membership(String name, int price, double pointMultiplier, int time, int tier) {
        super(name, price);
        this.pointMultiplier = pointMultiplier;
        this.time = time;
        this.tier = tier;
    }

    public double getPointMultiplier() {
        return pointMultiplier;
    }

    public int getTime() {
        return time;
    }

    public int getTier() {
        return tier;
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
