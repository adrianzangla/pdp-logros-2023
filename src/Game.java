import java.util.*;

public class Game {
    private String name;
    private List<Action> actions;

    public Game(String name) {
        this.name = name;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void play(User user, Integer hours) {
        Random random = new Random();
        for (int i = 0; i < hours; i++) {
            Action action = actions.get(random.nextInt(actions.size()));
            double times = random.nextDouble(action.getAchievements().get(random.nextInt(action.getAchievements().size())).getTarget()) * user.getMultipliers().getOrDefault(this, 1d);
            action.perform(user, hours);
            user.getActiveMembership().decreaseHoursLeft();
        }
    }

}
