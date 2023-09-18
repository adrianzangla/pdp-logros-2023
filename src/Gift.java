public class Gift extends Item {
    private Item item;

    public Gift(Item item) {
        super(item.getName() + "Gift", 0);
        this.item = item;
    }


    @Override
    public void use(User user) {
        user.getInventory().put(item, user.getInventory().getOrDefault(item, 0) + 1);
    }
}
