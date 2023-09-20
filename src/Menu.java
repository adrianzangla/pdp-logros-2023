import java.util.*;

public class Menu {

    private static final String welcome = "Bienvenido al Sistema de Logros del Grupo 10.\nDesde el siguiente menú podrás crear usuarios, simular horas de juego, registrar sus logros obtenidos, objetos en el inventario, realizar compras, transacciones y mostrar estadísticas. ¿Suena aburrido? Pues tenés toda la razón";

    private static final String options = "Seleccioná una opción:\n" +
            "(1) Elegir un usuario\n" +
            "(2) Crear un usuario\n" +
            "(3) Simular 200 acciones\n" +
            "(4) Tabla de Clasificación";
    private static final String userCreation = "Ingresá el nombre o cancelar";

    private static final String userOptions = "Seleccioná una opción\n" +
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
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println(welcome);
            System.out.println(options);
            try {
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        selectUser();
                        break;
                    case 2:
                        createUser();
                        break;
                    case 3:
                        simulate();
                        break;
                    case 4:
                        leaderboard();
                        break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "selectUser" que hace que el usuario elija de la lista de usuarios cual quiere
    private static void selectUser() {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 1;
            for (User user : AchievementSystem.getUsers()) {
                System.out.println("(" + listIndex + ") " + "\t" + user.getNameStyle());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                int option = sc.nextInt();
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
    //metodo "userMenu" que hace que el usuario elija una de las opciones a realizar con su usuario seleccionado
    private static void userMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println(user.getNameStyle());
            System.out.println("Puntos: " + user.getPoints());
            System.out.println(userOptions);
            try {
                int option = sc.nextInt();
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
    //metodo "createUser" que crea un usuario y lo agrega a la lista de usuarios para luego poder ser seleccionado
    private static void createUser() {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println(userCreation);
            try {
                String name = sc.nextLine();
                if (name.equalsIgnoreCase("cancelar")) {
                    return;
                }
                for (User user : AchievementSystem.getUsers()) {
                    if (name.equalsIgnoreCase(user.getName())) {
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
    //metodo "playMenu" que le da a elegir al usuario que juego jugar y cuantas horas.
    //Una vez termina de jugar el usuario se da el aviso por pantalla
    private static void playMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 1;
            try {
                System.out.println("Elegí un juego");
                for (Game game : AchievementSystem.getGames()) {
                    System.out.println("(" + listIndex + ") " + "\t" + game.getName());
                    listIndex++;
                }
                System.out.println("(0) Cancelar");
                int option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                System.out.println("¿Cuántas horas?");
                int hours = sc.nextInt();
                AchievementSystem.getGames().get(option - 1).play(user, hours);
                System.out.println("El usuario terminó de jugar");
                sc.nextLine();
                return;
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "inventoryMenu" que muestra el inventario para que el usuario consuma un objeto o realice una transaccion
    private static void inventoryMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 1;
            List<Item> items = new ArrayList<>(user.getInventory().keySet());
            for (Item item : items) {
                System.out.println("(" + listIndex + ") " + "\t" + user.getInventory().get(item) + "\t" + item.getName());
                listIndex++;
            }
            try {
                System.out.println("(0) Cancelar");
                int option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                Item selectedItem = items.get(option - 1);
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
                sc.nextLine();
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "transferMenu" que le permite al usuario elegir un destinatario para luego realizar la transaccion
    private static void transferMenu(User user, Item item) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 1;
            List<User> users = new ArrayList<>();
            for (User otherUser : AchievementSystem.getUsers()) {
                if (otherUser != user) {
                    System.out.println("(" + listIndex + ")" + "\t" + otherUser.getNameStyle());
                    users.add(otherUser);
                    listIndex++;
                }
            }
            try {
                int option = sc.nextInt();
                List<Item> itemList = new LinkedList<>();
                itemList.add(item);
                user.transfer(users.get(option - 1), itemList);
                sc.nextLine();
                return;
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "storeMenu" que muestra todos los objetos de la tienda para que el usuario elija cual comprar
    private static void storeMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 1;
            List<Item> items = Store.getItems();
            for (Item item : items) {
                System.out.println("(" + listIndex + ")" + "\t" + item.getName());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                int option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                Item selectedItem = items.get(option - 1);
                System.out.println(selectedItem.toString());
                System.out.println("(1) Comprar");
                System.out.println("(0) Cancelar");
                option = sc.nextInt();
                if (option == 0) {
                    continue;
                }
                System.out.println("Elegí el método de pago");
                buyMenu(user, selectedItem);
                return;
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "buyMenu" que le permite al usuario comprar un objeto
    private static void buyMenu(User user, Item item) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            int listIndex = 2;
            System.out.println("(" + 1 + ")" + "\t" + "Puntos");
            for (PaymentMethod pm : user.getPaymentMethods()) {
                System.out.println("(" + listIndex + ")" + "\t" + pm.getName());
                listIndex++;
            }
            System.out.println("(0) Cancelar");
            try {
                int option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                if (option == 1) {
                    item.buy(user);
                } else {
                    item.buy(user, user.getPaymentMethods().get(option - 2));
                }
                System.out.println("Objeto comprado");
                sc.nextLine();
                return;
            } catch (AchievementSystemException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {
                return;
            }
        }
    }
    //metodo "showAchievements" que muestra los logros del usuario
    private static void showAchievements(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Set<Achievement> printed = new HashSet<>();
        for (Game game : AchievementSystem.getGames()) {
            System.out.println(game.getName() + ": ");
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
        sc.nextLine();
    }
    //metodo "paymentMethodMenu" que le da a elejir al usuario con que metodo de pago realizar la compra
    private static void paymentMethodMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("(1) Tarjeta de Crédito");
            System.out.println("(2) Tarjeta de Débito");
            System.out.println("(0) Cancelar");
            try {
                int option = sc.nextInt();
                if (option == 0) {
                    return;
                }
                if (option == 1) {
                    creditMenu(user);
                    return;
                }
                if (option == 2) {
                    debitMenu(user);
                    return;
                }
            } catch (Exception e) {
                continue;
            }

        }
    }
    //metodo "creditMenu" que capta la tarjera de credito del usuario y su limite
    private static void creditMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingresá el nombe de la tarjeta de crédito o cancelar");

            try {
                String name = sc.nextLine();
                if (name == "cancelar") {
                    return;
                }
                System.out.println("Ingresá el límite (No mientas) o 0 para cancelar");
                Double limit = sc.nextDouble();
                if (limit == 0) {
                    return;
                }
                user.getPaymentMethods().add(new CreditCard(name, limit));
                System.out.println("Método de pago agregado");
                sc.nextLine();
                return;
            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "debitMenu" que  capta la tarjera de debito del usuario y su balance
    private static void debitMenu(User user) {
        while (true) {
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingresá el nombe de la tarjeta de débito o cancelar");
            try {
                String name = sc.nextLine();
                if (name == "cancelar") {
                    return;
                }
                System.out.println("Ingresá el balance (No mientas) o -1 para cancelar");
                Double balance = sc.nextDouble();
                if (balance == -1) {
                    return;
                }
                user.getPaymentMethods().add(new DebitCard(name, balance));
                System.out.println("Método de pago agregado");
                sc.nextLine();
                return;

            } catch (Exception e) {
                continue;
            }
        }
    }
    //metodo "averageSpending" que muestra las estadisticas de gasto de un usuario
    private static void averageSpending(User user) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int f = 0;
        for (Transaction transaction : AchievementSystem.getTransactions()) {
            if (transaction.getFrom() == AchievementSystem.getStore() && transaction.getTo() == user) {
                for (Item item : transaction.getItems()) {
                    f += item.getPrice();
                }
            }
        }
        System.out.println("Gasto total: " + f);
        System.out.println("Gasto promedio: " + f / user.getHoursPlayed());
        sc.nextLine();
    }
    //metodo "simulate" que simula movimientos al azar del juego
    private static void simulate() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
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
                } catch (Exception e) {
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
                } catch (Exception e) {
                    continue;
                }
            }
            for (int j = 0; j < 10; j++) {
                try {
                    User user0 = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                    User user1 = AchievementSystem.getUsers().get(random.nextInt(AchievementSystem.getUsers().size()));
                    if (user0 != user1) {
                        List<Item> items = new ArrayList<>(user0.getInventory().keySet());
                        List<Item> toTransfer = new LinkedList<>();
                        toTransfer.add(items.get(random.nextInt(items.size())));
                        user0.transfer(user1, toTransfer);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            for (User user : AchievementSystem.getUsers()) {
                user.useAllConsumables();
                List<Item> items = new ArrayList<>(user.getInventory().keySet());
                items.get(random.nextInt(items.size())).use(user);
            }
        }
        System.out.println("Simulación finalizada");
        sc.nextLine();
    }

    //metodo "leaderboard" que rankea a los usuarios segun sus puntos
    private static void leaderboard() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Collections.sort(AchievementSystem.getUsers());
        int listIndex = 1;
        for (User user : AchievementSystem.getUsers()) {
            System.out.println(listIndex+ "\t" + "Puntos: " + user.getPoints() );
            System.out.println(user.getNameStyle());
            listIndex++;
        }
        sc.nextLine();
    }
}
