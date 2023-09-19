import java.util.*;

public class    Menu {

    private static final String welcome = "Bienvenido al Sistema de Logros del Grupo 9. Desde el siguiente menú podrás crear usuarios, simular horas de juego, registrar sus logros obtenidos, objetos en el inventario, realizar compras, transacciones y mostrar estadísticas. ¿Suena aburrido? Pues tenés toda la razón";
    private static final String options = "Seleccioná una opción:\n" +
            "(1) Elegir un usuario\n" +
            "(2) Crear un usuario\n" +
            "(3) Simular 200 acciones\n" +
            "(5) Tabla de Clasificación ";
    private static final String userCreation = "Ingresá tu nombre o cancelar";

    private static final String userOptions = "Seleccioná una opción" +
            "(1) Jugar" + '\n' +
            "(2) Mostrar inventario" + '\n' +
            "(3) Comprar objeto" + '\n' +
            "(4) Mostrar logros" + '\n' +
            "(5) Agregar método de pago" + '\n' +
            "(6) Promedio de gastos" + "\n" +
            "(0) Cancelar";

    private static final String itemOptions = "(1) Usar" + "\n" +
            "(2) Transferir" + "\n" +
            "(0) Cancelar";

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        while (true) {
            System.out.println(welcome);
            System.out.println(options);
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        selectUser();
                        break;
                    case 2:
                        createUser();
                        break;
                    case 3:
                        simulate();
                    case 4:
                        leaderboard();
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void selectUser() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        while (true) {
            int listIndex = 1;
            for (User user : AchievementSystem.getUsers()) {
                System.out.println("(" + listIndex + ") " + "\t" +user.getNameStyle());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                User user = AchievementSystem.getUsers().get(option - 1);
                userMenu(user);
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
                        break;
                    case 4:
                        System.out.println("Logros:");
                        showAchievements(user);
                        break;
                    case 5:
                        System.out.println("Agregar método de pago");
                        paymentMethodMenu(user);
                        break;
                    case 6:
                        System.out.println("Promedio de gasto por horas jugadas");
                        averageSpending(user);
                    case 0:
                        return;
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
                    if (user.getName() == name) {
                        throw new AchievementSystemException("Nombre de usuario no disponible");
                    }
                }
                AchievementSystem.getUsers().add(new User(name));
                System.out.println("Ususario creado");
                return;
            } catch (AchievementSystemException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void playMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        int hours;
        int listIndex = 1;
        while (true) {
            try {
                System.out.println("¿Cuántas horas?");
                hours = sc.nextInt();
                for (Game game : AchievementSystem.getGames()) {
                    System.out.println("(" + listIndex+ ") " + "\t" + game.getName());
                    listIndex++;
                }
                System.out.println("(0) Cancelar");
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                AchievementSystem.getGames().get(option - 1).play(user, hours);
                System.out.println("El usuario terminó de jugar");
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
                System.out.println("(" + listIndex+ ") " + "\t" + item.getName() + "\t" + user.getInventory().get(item));
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
                    System.out.println("Objeto utilizado");
                }
                if (option == 2) {
                    transferMenu(user, selectedItem);
                    System.out.println("Objeto transferido");
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
                System.out.println("Elegí el método de pago");
                buyMenu(user, selectedItem);
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static void buyMenu(User user, Item item) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int listIndex = 2;
        int option;
        while (true) {
            System.out.println("(" + 1 + ")" + "\t" + "Puntos");
            for (PaymentMethod pm : user.getPaymentMethods()) {
                System.out.println("(" + listIndex + ")" + "\t" + pm.getName());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                if (option == 1) {
                    item.buy(user);
                } else {
                    item.buy(user, user.getPaymentMethods().get(listIndex - 2));
                }
            } catch (AchievementSystemException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static void showAchievements(User user) {
        Set<Achievement> printed = new HashSet<>();
        for (Game game : AchievementSystem.getGames()) {
            System.out.println(game.getName());
            for (Action action : game.getActions()) {
                for (Achievement achievement : action.getAchievements()) {
                    if (user.getAchievements().containsKey(achievement)) {
                        if (!printed.contains(achievement)) {
                            if (user.getAchievements().get(achievement) < 0) {
                                System.out.println(achievement.getName() + "\t" + "(" + achievement.getTarget() + "/" + achievement.getTarget() + ")" + "*");
                            } else {
                                System.out.println(achievement.getName() + "\t" + "(" + user.getAchievements().get(achievement) + "/" + achievement.getTarget() + ")");
                            }
                            printed.add(achievement);
                        }
                    }
                }
            }
        }
    }

    private static void paymentMethodMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int option;
        while (true) {
            System.out.println("(1) Tarjeta de Crédito");
            System.out.println("(2) Tarjeta de Débito");
            System.out.println("(0) Cancelar");
            try {
                option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                if (option == 1) {
                    creditMenu(user);
                }
                if (option == 2) {
                    debitMenu(user);
                }
            } catch (Exception e) {
                continue;
            }

        }
    }

    private static void creditMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.println("Ingresá el nombe de la tarjeta de crédito");
            try {
                String name = sc.nextLine();
                System.out.println("Ingresá el límite (No mientas)");
                Double limit = sc.nextDouble();
                user.getPaymentMethods().add(new CreditCard(name, limit));
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static void debitMenu(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.println("Ingresá el nombe de la tarjeta de débito");
            try {
                String name = sc.nextLine();
                System.out.println("Ingresá el balance (No mientas)");
                Double limit = sc.nextDouble();
                user.getPaymentMethods().add(new CreditCard(name, limit));
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static void averageSpending(User user) {
        int f = 0;
        for (Transaction transaction : AchievementSystem.getTransactions()) {
            if (transaction.getFrom() == AchievementSystem.getStore() && transaction.getTo() == user) {
                for (Item item : transaction.getItems()) {
                    f += item.getPrice();
                }
            }
        }
        System.out.println("Gasto total: " + f);
        System.out.println("Gasto promedio: " + f/user.getHoursPlayed());
    }

    private static void simulate() {
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 30; j++) {
                AchievementSystem.getGames().get(random.nextInt(AchievementSystem.getGames().size())).play(AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size())), random.nextInt(16));
            }
            for (int j = 0; j < 5; j++) {
                try {
                    Store.getItems().get(random.nextInt(Store.getItems().size())).buy(AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size())));
                } catch (AchievementSystemException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            for (int j = 0; j < 5; j++) {
                User user = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                try {
                    Store.getItems().get(random.nextInt(Store.getItems().size())).buy(user, user.getPaymentMethods().get(random.nextInt(user.getPaymentMethods().size())));
                } catch (AchievementSystemException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            for (int j = 0; j < 5; j++) {
                User user = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                List<Item> items = new ArrayList<>(user.getInventory().keySet());
                items.get(random.nextInt(items.size())).use(user);
            }
            for (int j = 0; j < 5; j++) {
                User user0 = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                User user1 = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                if (user0 != user1) {
                    List<Item> items = new ArrayList<>(user0.getInventory().keySet());
                    List<Item> toTransfer = new LinkedList<>();
                    toTransfer.add(items.get(random.nextInt(items.size())));
                    user0.transfer(user1, toTransfer);
                }
            }
        }
    }
    private static void leaderboard() {
        Collections.sort(AchievementSystem.getUsers());
        int listIndex = 1;
        for (User user: AchievementSystem.getUsers()) {
            System.out.println("(" + listIndex + ")" + "\t" + user.getNameStyle());
            listIndex++;
        }
    }
}
