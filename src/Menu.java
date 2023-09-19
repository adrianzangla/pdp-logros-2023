import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    private static final String welcome = "Bienvenido al Sistema de Logros del Grupo 9. Desde el siguiente menú podrás crear usuarios, simular horas de juego, registrar sus logros obtenidos, objetos en el inventario, realizar compras, transacciones y mostrar estadísticas. ¿Suena aburrido? Pues tenés toda la razón";
    private static final String options = "Seleccioná una opción:\n" +
            "(1) Elegir un usuario\n" +
            "(2) Crear un usuario\n" +
            "(3) Simular 200 acciones\n" +
            "(4) Estadísticas" +
            "(5) Tabla de Clasificación ";
    private static final String userCreation = "Ingresá tu nombre o cancelar";

    private static final String userOptions = "Seleccioná una opción" +
            "(1) Jugar" + '\n' +
            "(2) Mostrar inventario" + '\n' +
            "(3) Consumir objeto" + '\n' +
            "(4) Comprar objeto" + '\n' +
            "(5) Mostrar logros" + '\n' +
            "(6) Realizar transaccion" + '\n' +
            "(0) Cancelar";

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        User selectedUser;
        int option;
        while (true) {
            System.out.println(welcome);
            System.out.println(options);
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        selectedUser = selectUser();
                        userMenu(selectedUser);
                    case 2:
                        createUser();
                        break;
                    case 3:

                }
            } catch (Exception e) {
                continue;
            }
        }

    }

    public static User selectUser() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            for (int i = 0; i < AchievementSystem.getUsers().size(); i++) {
                System.out.println("(" + i + ") " + AchievementSystem.getGames().get(i));
            }
            try {
                return AchievementSystem.getUsers().get(sc.nextInt());
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void userMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        while (true) {
            System.out.println(userOptions);
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        playMenu(user);
                        break;
                    case 2:
                        System.out.println("Inventario: "+'\n'+user.getInventory());
                        break;
                    case 3:

                    case 4:

                    case 5:
                        System.out.println("Logros: "+'\n'+user.getAchievements());
                        break;
                    case 6:
                        User receiverUser=selectUser();
                        List<Item> itemsList=new LinkedList<>();
                        for (int i = 0; i < user.getInventory().size(); i++) {
                            System.out.println("(" + i + ") " + user.getInventory().get(i));
                            try {
                                //como referencio a la key de un map?
                                //itemsList.add(user.getInventory().get(sc.nextInt()));
                            } catch (Exception e) {
                                continue;
                            }
                        }
                        user.transfer(receiverUser, itemsList);
                        break;
                    case 0:
                        break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void createUser() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String name;
        while (true) {
            System.out.println(userCreation);
            try {
                name = sc.nextLine();
                if (name.equalsIgnoreCase("cancelar")) {
                    return;
                }
                for (User user : AchievementSystem.getUsers()) {
                    if (Objects.equals(user.getName(), name)) {
                        throw new AchievementSystemException("Nombre de usuario no disponible");
                    }
                }
                AchievementSystem.getUsers().add(new User(name));
                return;
            } catch (Exception e) {
                continue;
            }
        }


    }

    public static void playMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        int hours;
        while (true) {
            System.out.println("¿Cuántas horas?");
            hours = sc.nextInt();
            for (int i = 0; i < AchievementSystem.getGames().size(); i++) {
                System.out.println("(" + i + ") " + AchievementSystem.getGames().get(i));
            }
            System.out.println("(0) Cancelar");
            try {
                AchievementSystem.getGames().get(sc.nextInt()).play(user, hours);

            } catch (Exception e) {
                continue;
            }
        }

    }


}
