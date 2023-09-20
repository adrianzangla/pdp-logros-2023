import java.util.*;

public class User implements Sender, Receiver, Comparable<User> {
//atributos: nombre,estilo de nombre,logros,puntos,rango,membresia activa,metodos de pago,inventario,multiplicadores
    private final String name;
    private String nameStyle;
    private final Map<Achievement, Integer> achievements = new HashMap<>();
    private int points;
    private Rank rank;
    private final ActiveMembership activeMembership = new ActiveMembership(Membership.getDefaultMembership(), -1);
    private final List<PaymentMethod> paymentMethods = new LinkedList<>();
    private final Map<Item, Integer> inventory = new HashMap<>();
    private final Map<Game, Double> multipliers = new HashMap<>();
    private int hoursPlayed;

    //construcor de "User"
    public User(String name) {
        this.name = name;
        this.rank = Rank.getDefaultRank();
        this.nameStyle = "[" + activeMembership.getMembership().getName() + "]" + "[" + rank.getName() + "]" + name;
        this.points = 0;
        this.hoursPlayed = 0;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }
    //metodo "get" que devuelve el nombre
    public String getName() {
        return name;
    }
    //metodo "get" que devuelve el estilo del nombre
    public String getNameStyle() {
        return nameStyle;
    }
    //metodo "get" que devuelve los logros
    public Map<Achievement, Integer> getAchievements() {
        return achievements;
    }
    //metodo "get" que devuelve los puntos
    public int getPoints() {
        return points;
    }
    //metodo "get" que devuelve la membresia que el usuario utiliza actualmente
    public ActiveMembership getActiveMembership() {
        return activeMembership;
    }
    //metodo "get" que devuelve los metodos de pago
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }
    //metodo "get" que devuelve el inventario
    public Map<Item, Integer> getInventory() {
        return inventory;
    }
    //metodo "get" que devuelve el rango
    public Rank getRank() {
        return rank;
    }
    //metodo "get" que devuelve los multiplicadores de un juego
    public Map<Game, Double> getMultipliers() {
        return multipliers;
    }
    //metodo "set" que actualiza el estilo del nombre
    public void setNameStyle(String nameStyle) {
        this.nameStyle = nameStyle;
    }
    //metodo "set" que actualiza los puntos
    public void setPoints(Integer points) {
        this.points = points;
    }
    //metodo "set" que actualiza la membresia y su tiempo de vida
    public void setActiveMembership(Membership membership) {
        this.activeMembership.setMembership(membership);
        this.activeMembership.setHoursLeft(membership.getTime());
    }
    //metodo "set" que actualiza el rango
    public void setRank(Rank rank) {
        this.rank = rank;
    }


    @Override
    //metodo "tranfer" que proviene de la interfaz Sender
    //realiza la transferencia de ciertos objetos, elegidos por el usuario, hacia otro suario
    public void transfer(Receiver to, List<Item> items) {
        List<Item> toTransfer = new LinkedList<>();
        for (Item item : items) {
            if (item.check(this)) {
                toTransfer.add(item);
            }
            inventory.put(item, inventory.get(item) - 1);
            item.check(this);
        }
        Transaction transaction = new Transaction(this, to);
        transaction.getItems().addAll(toTransfer);
        AchievementSystem.addTransaction(transaction);
    }

    @Override
    //metodo "receive" que proviene de la interfaz Receiver
    //recibe una transferencia de objetos y realiza con ellos lo que le corresponda al metodo use de cada subclase de objeto
    public void receive(List<Item> items) {
        for (Item item : items) {
            item.use(this);
        }
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(o.getPoints(), points);
    }

    public void useAllConsumables() {
        List<Item> items = Store.getItems().subList(Store.getConsumablesIndex(), Store.getItems().size());
        for (Item item : items) {
            while (inventory.containsKey(item)) {
                item.use(this);
            }
        }
    }
}
