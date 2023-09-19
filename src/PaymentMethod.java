public abstract class PaymentMethod {
    //atributos: nombre
    private String name;
<<<<<<< HEAD

    public PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

=======
    //metodo abstracto "pay" que sera utilizado en las clases hijas de PaymentMethod
>>>>>>> ce3a8e42e2ee19d032f3bff0f4027307361cb534
    public abstract boolean pay(Item item);
}
