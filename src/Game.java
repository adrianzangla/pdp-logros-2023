import java.util.*;

public class Game {
    //Atributos: nombre del juego,lista de acciones
    private final String name;
    private final List<Action> actions = new LinkedList<>();
    //constructor de Game
    public Game(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    //metodo "get" que devuelve la lista de acciones pertenecientes al juego
    public List<Action> getActions() {
        return actions;
    }
    //metodo "play" que simula la ejecucion de un juego con una accion al azar realizada un numero al azar de veces
    //tambien decrementa las horas de vida de la membresia del usuario si esta es referencial o vip
    public void play(User user, Integer hours) {
        Random random = new Random();
        for (int i = 0; i < hours; i++) {
            Action action = actions.get(random.nextInt(actions.size()));
            int times = (int) (random.nextInt(action.getAchievements().get(random.nextInt(action.getAchievements().size())).getTarget()) * user.getMultipliers().getOrDefault(this, 1d));
            action.perform(user, times);
            user.getActiveMembership().decreaseHoursLeft();
        }
        user.setHoursPlayed(user.getHoursPlayed() + hours);
    }

    @Override
    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' ;
    }
}
