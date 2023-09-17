import java.util.List;
import java.util.Objects;

public class Achievement implements Transactionable {
    private String name;
    private double target;
    private List<Item> reward;
    private Rank rankRequired;
    private Membership membershipRequired;

    public Achievement(String name, double target, List<Item> reward, Rank rankRequired, Membership membershipRequired) {
        this.name = name;
        this.target = target;
        this.reward = reward;
        this.rankRequired = rankRequired;
        this.membershipRequired = membershipRequired;
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
        if (user.getAchievements().get(this) < 0) {
            return;
        }
        if (user.getActiveMembership().getMembership() != membershipRequired) {
            return;
        }
        if (user.getRank().getTier() < rankRequired.getTier()) {
            return;
        }
        double current = user.getAchievements().getOrDefault(this, 0d);
        if (current >= target) {
            current = -1d;
            transfer(user, reward);
        }
        user.getAchievements().put(this, current);
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
