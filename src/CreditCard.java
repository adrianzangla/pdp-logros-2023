public class CreditCard extends PaymentMethod {
    private Double limit;

    @Override
    public boolean pay(Item item) {
        if (item.getPrice() <= limit) {
            return true;
        }
        return false;
    }
}
