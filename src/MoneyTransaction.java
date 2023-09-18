import java.util.List;

public class MoneyTransaction extends Transaction implements Transferable{
    private Float money;
    private MeansOfPayment mopOfIssuer;
    private MeansOfPayment mopOfReceiver;

    public MoneyTransaction(Float money,MeansOfPayment mopOfIssuer,MeansOfPayment mopOfReceiver) {
        super();
        this.money = money;
        this.mopOfIssuer=mopOfIssuer;
        this.mopOfReceiver=mopOfReceiver;
    }



    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public void Transfer(User receiver){
        Float issuerMoney;
        Float receiverMoney;
        issuerMoney= this.mopOfIssuer.getBalance()-this.money;
        this.mopOfIssuer.setBalance(issuerMoney);
        List<MeansOfPayment> meansOfPayments=receiver.getMeansOfPayment();
        for (MeansOfPayment m : meansOfPayments) {
            if (m==this.mopOfReceiver){
                receiverMoney=m.getBalance()+this.money;
                m.setBalance(receiverMoney);
                break;
            }
        }

    }
}
