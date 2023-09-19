public class DebitCard extends PaymentMethod {
    //Atributos: dinero
    private double balance;

    public DebitCard(String name, Double balance) {
        super(name);
        this.balance = balance;
    }

    @Override
    //metodo abstracto pay que devuelve un booleano
    //indicando si se puede comprar el objeto segun el precio del mismo el dinero del usuario en su tarjeta de debito
    public boolean pay(Item item) {
        if (balance >= item.getPrice()) {
            balance -= item.getPrice();
            return true;
        }
        return false;
    }
}
