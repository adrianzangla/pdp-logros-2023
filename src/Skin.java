public class Skin extends Item {
    //atributos: contenido
    private String content;
    //constructor de "Skin"
    public Skin(String name, Integer price, String content) {
        super(name, price);
        this.content = content;
    }
    //metodo  abstracto "use" que le aplica la skin al usuario en su atributo nameStyle
    @Override
    public void use(User user) {
        if (check(user)) {
            user.setNameStyle(content.replaceFirst("username", "[" + user.getActiveMembership().getMembership().getName() + "]" + "[" + user.getRank().getName() + "]" + user.getName()));
        }
    }
    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    @Override
    public boolean check(User user) {
        if (!user.getInventory().containsKey(this)) {
            unequip(user);
            return false;

        }
        if (user.getInventory().get(this) < 1) {
            user.getInventory().remove(this);
            unequip(user);
            return false;
        }
        return true;
    }

    private void unequip(User user) {
        user.setNameStyle("[" + user.getActiveMembership().getMembership().getName() + "]" + "[" + user.getRank().getName() + "]" + user.getName());
    }

    @Override
    public String toString() {
        return content;
    }
}
