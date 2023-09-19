public class Gift extends Item {
    //Atributos: objeto
    private final Item item;
    //constructor de "Gift"
    public Gift(Item item) {
        super(item.getName() + "Gift", 0);
        this.item = item;
    }


    @Override
    //metodo abstracto "use" que añade el objeto al inventario del usuario
    public void use(User user) {
        user.getInventory().put(item, user.getInventory().getOrDefault(item, 0) + 1);
    }
}
