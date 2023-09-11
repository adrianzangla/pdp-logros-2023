import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private List<Game> games;
    private List<Progress> progresses;

    private Membership membership;

    private Float experience;

    private List<Item> items;

    public Float getExperience() {
        return experience;
    }

    public void buyGame(Game game) {
        games.add(game);
        List<Achievement> achievements = game.getAchievements();
        for (Achievement achievement : achievements) {
            Progress progress = new Progress(achievement);
            progresses.add(progress);
        }
    }

    private Boolean isComplete(List<Achievement> achievements) {
        for (Achievement achievement : achievements) {
            for (Progress progress : progresses) {
                if (progress.getAchievement() == achievement) {
                    if (!progress.getComplete()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void obtainReward(Achievement achievement) {
        this.items.addAll(achievement.getReward().getItems());
    }

    public void performAction(Action action, Float times) {
        // Para cada Progress en progresses
        for (Progress progress : progresses) {
            Achievement achievement = progress.getAchievement();
            if (
                    achievement.getRankRequired().isRank(this)
                    && achievement.getMembershipRequired() == this.membership
                    && isComplete(achievement.getAchievementsRequired())
            ) {
                Map<Action, Float> value = progress.getValue();
                // Si la accion pertenece al progreso
                if (value.containsKey(action)) {
                    Float currentValue = value.get(action);
                    value.put(action, currentValue + times);
                    Map<Action, Float> target = achievement.getTarget();

                    progress.setComplete(value.get(action) >= target.get(action));


                }
            }

        }
    }

}
