public class CreditCard extends PaymentMethod {
    //Atributos: limite
    private double limit;

    public CreditCard(String name, Double limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    //metodo abstracto pay que retorna un booleano
    //indicando si se puede pagar o no el objeto segun el precio de este y el limite de la tarjeta de credito
    public boolean pay(Item item) {
        if (item.getPrice() <= limit) {
            return true;
        }
        return false;
    }
}
