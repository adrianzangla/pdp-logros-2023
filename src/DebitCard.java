public class DebitCard extends PaymentMethod {
    private Double balance;

    @Override
    public boolean pay(Item item) {
        if (balance >= item.getPrice()) {
            balance -= item.getPrice();
            return true;
        }
        return false;
    }
}
