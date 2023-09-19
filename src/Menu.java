import java.util.*;

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
            "(3) Comprar objeto" + '\n' +
            "(4) Mostrar logros" + '\n' +
            "(5) Agregar método de pago" + '\n' +
            "(0) Cancelar";

    private static final String itemOptions = "(1) Usar" + "\n" +
            "(2) Transferir" + "\n" +
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
                        if (selectedUser != null) {
                            userMenu(selectedUser);
                        }
                        break;
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
        int option;
        while (true) {
            for (int i = 0; i < AchievementSystem.getUsers().size(); i++) {
                System.out.println("(" + i + 1 + ") " + AchievementSystem.getUsers().get(i).getNameStyle());
            }
            System.out.println("(0) Cancelar");
            try {
                option = sc.nextInt();
                if (option == 0) {
                    return null;
                }
                return AchievementSystem.getUsers().get(option - 1);
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void userMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        while (true) {
            System.out.println(user.getNameStyle());
            System.out.println(userOptions);
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        playMenu(user);
                        break;
                    case 2:
                        System.out.println("Inventario:");
                        System.out.println("Seleccioná un objeto:");
                        inventoryMenu(user);
                        break;
                    case 3:
                        System.out.println("Tienda");
                        System.out.println("Seleccione un objeto");
                        storeMenu(user);

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
            try {
                System.out.println("¿Cuántas horas?");
                hours = sc.nextInt();
                for (int i = 0; i < AchievementSystem.getGames().size(); i++) {
                    System.out.println("(" + i + 1 + ") " + "\t" + AchievementSystem.getGames().get(i));
                }
                System.out.println("(0) Cancelar");
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                AchievementSystem.getGames().get(option - 1).play(user, hours);
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void inventoryMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        int listIndex = 1;
        Item selectedItem;
        List<Item> items = new ArrayList<>();
        while (true) {
            for (Item item : user.getInventory().keySet()) {
                if (user.getInventory().get(item) > 0) {
                    System.out.println("(" + listIndex + ")" + "\t" + item.getName() + "\t" + user.getInventory().get(item));
                    items.add(item);
                    listIndex++;
                }
            }
            try {
                System.out.println("(0) Cancelar");
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                selectedItem = items.get(option - 1);
                System.out.println(selectedItem);
                System.out.println(itemOptions);
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                if (option == 1) {
                    selectedItem.use(user);
                }
                if (option == 2) {
                    transferMenu(user, selectedItem);
                }
            } catch (Exception e) {
                continue;
            }

        }
    }

    public static void transferMenu(User user, Item item) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        int listIndex = 1;
        List<User> users = new ArrayList<>();
        while (true) {
            for (User otherUser : AchievementSystem.getUsers()) {
                if (otherUser != user) {
                    System.out.println("(" + listIndex + ")" + "\t" + otherUser.getNameStyle());
                    users.add(otherUser);
                    listIndex++;
                }
            }
            try {
                option = sc.nextInt();
                List<Item> itemList = new LinkedList<>();
                itemList.add(item);
                user.transfer(users.get(option - 1), itemList);
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void storeMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        List<Item> items = Store.getItems();
        int listIndex = 1;
        int option;
        Item selectedItem;
        while (true) {
            for (Item item : items) {
                System.out.println("(" + listIndex + ")" + "\t" + item.toString());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                selectedItem = items.get(option - 1);
                System.out.println(selectedItem.toString());
                System.out.println("(1) Comprar");
                System.out.println("(0) Cancelar");
                option = sc.nextInt();
                if (option == 0) {
                    continue;
                }
                List<Item> selectedItemList = new LinkedList<>();
                selectedItemList.add(selectedItem);
                AchievementSystem.getStore().transfer(user, selectedItemList);
            } catch (Exception e) {
                continue;
            }
        }


    }


}
