
import java.util.List;

public class ItemTransaction  extends Transaction implements Transferable {
    private  List<Item> items;

    public ItemTransaction(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void Transfer(User receiver){

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
