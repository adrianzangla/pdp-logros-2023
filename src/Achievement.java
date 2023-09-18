import java.util.LinkedList;
import java.util.List;

public class Achievement implements Transactionable {
    private String name;
    private double target;
    private final List<Item> reward = new LinkedList<>();
    private Rank rankRequired;
    private Membership membershipRequired;

    public Achievement(String name, double target, Rank rankRequired, Membership membershipRequired) {
        this.name = name;
        this.target = target;
        this.rankRequired = rankRequired;
        this.membershipRequired = membershipRequired;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "name='" + name + '\'';
    }

    public String getName() {
        return name;
    }

    public double getTarget() {
        return target;
    }

    public List<Item> getReward() {
        return reward;
    }

    public void progress(User user, double times) {
        if (user.getAchievements().getOrDefault(this,0d) < 0) {
            return;
        }
        if (user.getActiveMembership().getMembership() != membershipRequired) {
            return;
        }
        if (user.getRank().getTier() < rankRequired.getTier()) {
            return;
        }
        double current = user.getAchievements().getOrDefault(this, 0d);
        if (current + times >= target) {
            user.getAchievements().put(this, -1d);
            transfer(user, reward);
        } else {
            user.getAchievements().put(this, current);
        }
    }

    @Override
    public void transfer(Transactionable to, List<Item> items) {
        Transaction transaction = new Transaction(this, to, reward);
        AchievementSystem.addTransaction(transaction);
    }

    @Override
    public void receive(List<Item> items) {
        return;
    }
}
