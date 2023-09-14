//Transaction es una clase abstracta de la cual se realiza herencia
public class Transaction {
    private long idTransaction;
    private User issuingUser;
    private User receivingUser;
    public Transaction(){

    }

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public User getIssuingUser() {
        return issuingUser;
    }
    public void setIssuingUser(User issuingUser) {
        this.issuingUser = issuingUser;
    }

    public User getReceivingUser() {
        return receivingUser;
    }

    public void setReceivingUser(User receivingUser) {
        this.receivingUser = receivingUser;
    }


}
