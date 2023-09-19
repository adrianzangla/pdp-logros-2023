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
