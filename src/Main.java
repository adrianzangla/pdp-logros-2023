import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        User u0 = new User("Adrian");
        AchievementSystem.initialize();
        AchievementSystem.getGames().get(0).play(u0, 4);
        System.out.println(u0);

        GameItem gi0 = new GameItem("game item 0", null, null, 0d);
        GameItem gi1 = new GameItem("game item 1", null, null, 0d);

        Map<GameItem, Integer> gm = new HashMap<>();

        gm.put(gi0, 1);
        gm.put(gi1, 2);

        System.out.println(gm);

    }
}
