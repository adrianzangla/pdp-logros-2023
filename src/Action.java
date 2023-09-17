import java.util.List;

public class Action {
    private String name;
    private List<Achievement> achievements;

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void perform(User user, double times) {
        for (Achievement achievement : achievements) {
            achievement.progress(user, times);
        }
    }
}
