public class MeansOfPayment {
    private String meanOfPay;
    private String payDescription;
    private Float balance;

    public MeansOfPayment(String meanOfPay,String payDescription,Float balance){
        this.meanOfPay=meanOfPay;
        this.payDescription=payDescription;
        this.balance=balance;
    }

    public String getMeanOfPay() {
        return meanOfPay;
    }

    public void setMeanOfPay(String meanOfPay) {
        this.meanOfPay = meanOfPay;
    }

    public String getPayDescription() {
        return payDescription;
    }


    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
