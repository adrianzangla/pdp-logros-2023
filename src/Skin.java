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
        user.setNameStyle(content.replaceFirst("username", user.getName()));
    }

}
