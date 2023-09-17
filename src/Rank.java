public class Rank extends Item {
    private static final Rank defaultRank = new Rank("Noob", 0, 0);
    private int tier;

    public Rank(String name, Integer price, int tier) {
        super(name, price);
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }


    @Override
    public void use(User user) {
        if (user.getPoints() < price) {
            return;
        }
        user.setRank(this);
    }
}
