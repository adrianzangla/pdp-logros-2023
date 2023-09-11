import java.util.List;
import java.util.Map;

public class Achievement {

    private String name;
    private Map<Action, Float> target;

    private Rank rankRequired;

    private Membership membershipRequired;

    private List<Achievement> achievementsRequired;
    private Reward reward;


    public Reward getReward() {
        return reward;
    }

    public Membership getMembershipRequired() {
        return membershipRequired;
    }

    public List<Achievement> getAchievementsRequired() {
        return achievementsRequired;
    }

    public Rank getRankRequired() {
        return rankRequired;
    }

    public Map<Action, Float> getTarget() {
        return target;
    }

}
