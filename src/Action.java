import java.util.LinkedList;
import java.util.List;

public class Action {
    private String name;
    private final List<Achievement> achievements = new LinkedList<>();

    public Action(String name) {
        this.name = name;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void perform(User user, double times) {
        for (Achievement achievement : achievements) {
            achievement.progress(user, times);
        }
    }
}
