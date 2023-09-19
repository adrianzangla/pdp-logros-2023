public abstract class PaymentMethod {
    //atributos: nombre
    private String name;

    public PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //metodo abstracto "pay" que sera utilizado en las clases hijas de PaymentMethod
    public abstract boolean pay(Item item);
}
