public abstract class PaymentMethod {
    private String name;

    public PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean pay(Item item);
}
