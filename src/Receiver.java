import java.util.List;

public interface Receiver {
    //metodo "receive" que es implementado en User
    //un destinatario de tipo User recibe los objetos
    public void receive(List<Item> items);
}
