import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Game {

    private final String name;
    private Map<Action, List<Achievement>> achievements;

    public Game(String name, Map<Action, List<Achievement>> achievements) {
        this.name = name;
        this.achievements = achievements;
    }

    public String getName() {
        return this.name;
    }

    public List<Achievement> getAllAchievements() {
        List<Achievement> allAchievements = new LinkedList<>();

        for (List<Achievement> achievementList : achievements.values()) {
            allAchievements.addAll(achievementList);
        }

        return allAchievements;
    }

    public List<Achievement> getAchievements(Action action) {
        return achievements.get(action);
    }

}
