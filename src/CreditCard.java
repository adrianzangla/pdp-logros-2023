public class CreditCard extends PaymentMethod {
    private Double limit;
    private Double spent;

    @Override
    public boolean pay(Item item) {
        if (spent + item.getPrice() <= limit) {
            spent += item.getPrice();
            return true;
        }
        return false;
    }
}
