public abstract class PaymentMethod {
    private String name;

    public abstract boolean pay(Item item);
}
