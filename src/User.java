import java.util.*;

public class User implements Sender, Receiver, Comparable<User> {
    private String name;
    private String nameStyle;
    private final Map<Achievement, Integer> achievements = new HashMap<>();
    private Integer points;
    private Rank rank;
    private ActiveMembership activeMembership;
    private final List<PaymentMethod> paymentMethods = new LinkedList<>();
    private final Map<Item, Integer> inventory = new HashMap<>();
    private final Map<Game, Double> multipliers = new HashMap<>();
    private int hoursPlayed;


    public User(String name) {
        this.name = name;
        this.nameStyle = name;
        this.points = 0;
        this.activeMembership = new ActiveMembership(Membership.getDefaultMembership(), -1);
        this.rank = Rank.getDefaultRank();
        this.hoursPlayed = 0;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    public String toString() {
        return nameStyle + " {" + '\n' +
                " achievements=" + achievements + '\n' +
                ", points=" + points + '\n' +
                ", rank=" + rank + '\n' +
                ", activeMembership=" + activeMembership + '\n' +
                ", paymentMethods=" + paymentMethods + '\n' +
                ", inventory=" + inventory + '\n' +
                ", multipliers=" + multipliers + '\n' +
                '}';
    }

    public String getName() {
        return "[" + activeMembership.getMembership().getName() + "]" + "[" + rank.getName() + "]" + name;
    }

    public String getNameStyle() {
        return nameStyle;
    }

    public Map<Achievement, Integer> getAchievements() {
        return achievements;
    }

    public Integer getPoints() {
        return points;
    }

    public ActiveMembership getActiveMembership() {
        return activeMembership;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    public Rank getRank() {
        return rank;
    }

    public Map<Game, Double> getMultipliers() {
        return multipliers;
    }

    public void setNameStyle(String nameStyle) {
        this.nameStyle = nameStyle;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setActiveMembership(Membership membership) {
        this.activeMembership.setMembership(membership);
        this.activeMembership.setHoursLeft(membership.getTime());
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }


    @Override
    public void transfer(Receiver to, List<Item> items) {
        List<Item> toTransfer = new LinkedList<>();
        for (Item item : items) {
            if (item.check(this)) {
                toTransfer.add(item);
            }
            inventory.put(item, inventory.get(item) - 1);
            item.check(this);
        }
        Transaction transaction = new Transaction(this, to);
        transaction.getItems().addAll(toTransfer);
        AchievementSystem.addTransaction(transaction);
    }

    @Override
    public void receive(List<Item> items) {
        for (Item item : items) {
            item.use(this);
        }
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(points, o.getPoints());
    }
}
