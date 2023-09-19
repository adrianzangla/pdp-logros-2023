import java.util.LinkedList;
import java.util.List;

public class Achievement implements Sender {
    //la clase logro implementa la interfaz transaccionable
    //Atributos: nombre,objetivo del logro,recompensa(lista de objetos),rango requerido,membresia requerida
    private String name;
    private int target;
    private final List<Item> reward = new LinkedList<>();
    private Rank rankRequired;
    private Membership membershipRequired;
    //constructor de logro
    public Achievement(String name, int target, Rank rankRequired, Membership membershipRequired) {
        this.name = name;
        this.target = target;
        this.rankRequired = rankRequired;
        this.membershipRequired = membershipRequired;
    }

    @Override
    //metodo toString que devuelve la forma en la que va a imprimir lo que se le indica
    public String toString() {
        return "Achievement{" +
                "name='" + name + '\'';
    }
    //metodo get que devuelve el nombre del logro
    public String getName() {
        return name;
    }
    //metodo get que devuelve el objetivo del logro
    public int getTarget() {
        return target;
    }
    //metodo get que devuelve la recompensa
    public List<Item> getReward() {
        return reward;
    }
    //metodo progreso que gestiona el avance del logro dependiendo su situacion
    public void progress(User user, double times) {
        //analiza si el metodo esta cumplido o no(times<0 -> cumplido)
        if (user.getAchievements().getOrDefault(this,0) < 0) {
            return;
        }
        //analiza si cuenta con la membresia requerida
        if (user.getActiveMembership().getMembership().getTier() < membershipRequired.getTier()) {
            return;
        }
        //analiza si cuenta con el rango requerido
        if (user.getRank().getTier() < rankRequired.getTier()) {
            return;
        }

        int current = user.getAchievements().getOrDefault(this, 0);
        if (current + times >= target) {
            //si el progreso actualizado es mayor que el objetivo coloca times en negativo para indicar que ya se cumplió el logro
            //luego realiza la transferencia de la recompensa a travez del metodo transfer
            user.getAchievements().put(this, -1);
            transfer(user, reward);
        } else {
            //si el progreso actualizado no es mayor,guarda el progreso actualizado del logro
            user.getAchievements().put(this, current);
        }
    }

    @Override
    //metodo transfer proveniente de la interfaz Transferable
    //realiza la transaccion y la anota en la lista de transacciones del sistema
    public void transfer(Receiver to, List<Item> items) {
        Transaction transaction = new Transaction(this, to);
        transaction.getItems().addAll(reward);
        AchievementSystem.addTransaction(transaction);
    }
}
