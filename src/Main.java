import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Achievement achievement1 = new Achievement("achievement1", 1f);
        Achievement achievement2 = new Achievement("achievement2", 2f);

        List<Achievement> achievements1 = new LinkedList<>();
        achievements1.add(achievement1);
        achievements1.add(achievement2);

        Action action1 = new Action("action1", "game1");

        Map<Action, List<Achievement>> actionsAchievements = new HashMap<>();
        actionsAchievements.put(action1, achievements1);

        Game game1 = new Game("game1", actionsAchievements);

        Map<String, Game> games = new HashMap<>();
        games.put(game1.getName(), game1);

        User user1 = new User("user1", games);

        user1.listAchievements();

        user1.performAction(action1, 1f);

        user1.listAchievements();

    }
}
