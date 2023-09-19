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
            user.setNameStyle(content.replaceFirst("username", user.getName()));
        }
    }
    //metodo "toString" que devuelve la forma en la que va a imprimir lo que se le indica
    @Override
    public String toString() {
        return content;
    }
}
