import java.util.LinkedList;
import java.util.List;

public class Action {
    //Atributos:nombre,lista de logros
    private String name;
    private final List<Achievement> achievements = new LinkedList<>();
    //colocar achievements en el constructor?
    public Action(String name) {
        this.name = name;
    }
    //metodo get que devuelve la lista de logros
    public List<Achievement> getAchievements() {
        return achievements;
    }
    //metodo que aumenta el progreso del logro del usuario,segun la cantidad de veces que realiza la acción
    public void perform(User user, double times) {
        for (Achievement achievement : achievements) {
            achievement.progress(user, times);
        }
    }
}
