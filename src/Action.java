import java.util.List;

public class Action {
    private String name;
    private List<Achievement> achievements;

    public Action(String name, List<Achievement> achievements) {
        this.name = name;
        this.achievements = achievements;
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
