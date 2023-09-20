import java.util.List;

public interface Sender {
    //metodo "transfer" que es implementado en Achievement,AchievementSystem,User y Store
    //realiza una transferencia de objetos hacia un destinatario de tipo User
    public void transfer(Receiver to, List<Item> items);
}
