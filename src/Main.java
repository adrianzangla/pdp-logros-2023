import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        User u0 = new User("Adrian");
        AchievementSystem.initialize();
        System.out.println(u0);
        List<Game>Games=AchievementSystem.getGames();
        Games.get(0).play(u0,50);
        System.out.println(u0);
    }
}
