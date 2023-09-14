public class MoneyTransaction extends Transaction{
    private Float money;

    public MoneyTransaction(Float money) {
        this.money = money;
    }

    public MoneyTransaction() {
        super();
        this.money = money;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
