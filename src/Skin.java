public class Skin extends Item {
    private String content;

    public Skin(String name, Integer price, String content) {
        super(name, price);
        this.content = content;
    }

    @Override
    public void use(User user) {
        if (check(user)) {
            user.setNameStyle(content.replaceFirst("username", user.getName()));
        }
    }

}
