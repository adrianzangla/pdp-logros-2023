import java.util.LinkedList;
import java.util.List;

public class Action {
    //Atributos:nombre,lista de logros
    private final String name;
    private final List<Achievement> achievements = new LinkedList<>();
    //constructor de "Action"
    public Action(String name) {
        this.name = name;
    }
    //metodo "get" que devuelve la lista de logros
    public List<Achievement> getAchievements() {
        return achievements;
    }
    //metodo "perform" que aumenta el progreso del logro del usuario,segun la cantidad de veces que realiza la acción
    public void perform(User user, int times) {
        for (Achievement achievement : achievements) {
            achievement.progress(user, times);
        }
    }
}
