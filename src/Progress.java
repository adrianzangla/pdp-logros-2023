import java.util.HashMap;
import java.util.Map;

public class Progress {
    private Achievement achievement;
    private Map<Action, Float> value;

    private Boolean isComplete;


    public Map<Action, Float> getValue() {
        return value;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Progress(Achievement achievement) {
        this.achievement = achievement;
        Map<Action, Float> target = achievement.getTarget();
        value = new HashMap<Action, Float>(target);
        for (Action action : target.keySet()) {
            value.put(action, 0f);
        }
    }

}
