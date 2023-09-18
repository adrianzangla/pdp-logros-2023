import java.util.*;

public class User implements Transactionable {
    private String name;
    private String nameStyle;
    private final Map<Achievement, Double> achievements = new HashMap<>();
    private Integer points;
    private Rank rank;
    private ActiveMembership activeMembership;
    private final List<PaymentMethod> paymentMethods = new LinkedList<>();
    private final Map<Item, Integer> inventory = new HashMap<>();
    private final Map<Game, Double> multipliers = new HashMap<>();


    public User(String name) {
        this.name = name;
        this.nameStyle = name;
        this.points = 0;
        this.activeMembership=new ActiveMembership(Membership.getDefaultMembership(),-1);
        this.rank=Rank.getDefaultRank();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nameStyle='" + nameStyle + '\'' +
                ", achievements=" + achievements +
                ", points=" + points +
                ", rank=" + rank +
                ", activeMembership=" + activeMembership +
                ", paymentMethods=" + paymentMethods +
                ", inventory=" + inventory +
                ", multipliers=" + multipliers +
                '}';
    }

    public String getName() {
        return "[" + activeMembership.getMembership().getName() + "]" + "[" + rank.getName() + "]" + name;
    }

    public String getNameStyle() {
        return "\n" + nameStyle + "\n";
    }

    public Map<Achievement, Double> getAchievements() {
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
    public void transfer(Transactionable to, List<Item> items) {
        List<Item> toTransfer = new LinkedList<>();
        for (Item item : items) {
            if (inventory.containsKey(item) && inventory.get(item) > 0) {
                toTransfer.add(item);
                inventory.put(item, inventory.get(item) - 1);
            }
        }
        Transaction transaction = new Transaction(this, to, toTransfer);
        AchievementSystem.addTransaction(transaction);
    }

    @Override
    public void receive(List<Item> items) {
        for (Item item : items) {
            item.use(this);
        }
    }
}
