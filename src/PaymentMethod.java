public abstract class PaymentMethod {
    //atributos: nombre
    private final String name;
    //constructor de "PaymentMethod"
    public PaymentMethod(String name) {
        this.name = name;
    }
    //metodo "get" que devuelve el nombre del metodo de pago
    public String getName() {
        return name;
    }

    //metodo abstracto "pay" que sera utilizado en las clases hijas de PaymentMethod
    public abstract boolean pay(Item item);
}
