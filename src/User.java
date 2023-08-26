import java.util.Collection;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Map<String, Game> games;

    public User(String name, Map<String, Game> games) {
        this.name = name;
        this.games = games;
    }

    public void performAction(Action action, Float times) {
        if (games.containsKey(action.getGameName())) {
            Game game = games.get(action.getGameName());
            List<Achievement> achievements = game.getAchievements(action);
            for (Achievement achievement : achievements) {
                achievement.incrementProgress(times);
            }
        }
    }

    public void listAchievements() {
        // Este metodo esta aca solo para probar. Pertenece a otra clase
        Collection<Game> gamesCollection = games.values();
        List<Achievement> achievements = null;
        for (Game game : gamesCollection) {
            achievements = game.getAllAchievements();
        }
        if (achievements != null) {
            for (Achievement achievement : achievements) {
                if (achievement.getComplete()) {
                    System.out.println(achievement.getName());
                }
            }
        }
    }

}