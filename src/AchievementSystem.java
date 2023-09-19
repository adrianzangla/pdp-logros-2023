import java.util.LinkedList;
import java.util.List;

public class AchievementSystem {
    //Atributos: lista de transacciones,lista de juegos,lista de usuarios,lista de rangos,lista de membresias,lista de objetos
    private static final List<Transaction> transactions = new LinkedList<>();
    private static final List<Game> games = new LinkedList<>();
    private static final List<User> users = new LinkedList<>();
    private static final List<Rank> ranks = new LinkedList<>();
    private static final List<Membership> memberships = new LinkedList<>();
    private static final List<Item> items = new LinkedList<>();

    //metodo get que devuelve la lisa de transacciones
    private static List<Transaction> getTransactions() {
        return transactions;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Game> getGames() {
        return games;
    }

    public static void initialize() {
        memberships.add(new Membership("Preferencial", 1, 2d, 24*30, 1));
        memberships.add(new Membership("VIP", 2, 4d, 24*30, 2));
        ranks.add(new Rank("Pro", 1, 1));
        ranks.add(new Rank("God", 2, 2));
        //[0-11]
        items.add(new Skin("butterfly", 0, "(¯`·¯`·.¸¸.·´¯·´¯)\n" +
                "( \\            / )\n" +
                " ( ) username ( ) \n" +
                "  (/          \\)  \n" +
                "   (.·´¯`·.¸¸.)   "));
        items.add(new Skin("dachshund", 0, "                   __    \n" +
                "(\\,---------------'()'--o\n" +
                " (_    _username_    /~\" \n" +
                "  (_)_)         (_)_)    "));
        items.add(new Skin("dogs", 0, "                    ,,         \n" +
                "     __           o-°°|\\_____/)\n" +
                "(___()'`; username \\_/|_)     )\n" +
                "/,    /`              \\  __  / \n" +
                "\\\\\"--\\\\               (_/ (_/  "));

        items.add(new Skin("cat&mouse", 0, "  ^~^  ,                \n" +
                " ('Y') )                \n" +
                " /   \\/  username  __QQ \n" +
                "(\\|||/)           (_)_\">\n" +
                "                 /      "));
        items.add(new Skin("cheese", 0, " ()()             ____ \n" +
                " (..)            /|o  |\n" +
                " /\\/\\  username /o|  o|\n" +
                "c\\db/o........./o_|_o_|\n" +
                "         "));
        items.add(new Skin("centipede", 0, "                   \n" +
                "             o    o\n" +
                "   _username_ )  ( \n" +
                "{((((((((((( ( o_o)\n" +
                "  /\\/\\/\\/\\/\\\\ `--  "));
        items.add(new Skin("mosquito", 0, "    __                   \n" +
                "   (  )                  \n" +
                " \\ _\\/_,'    username    \n" +
                "--(\"))))))= -.._.-'-.._.-\n" +
                "     \\\\                  "));
        items.add(new Skin("spiderweb", 0, "        \n" +
                "  / _ \\____________/`/\\+-/\\'\\'\\\n" +
                "\\_\\(_)/_/ username -+-    -+-+-\n" +
                " _//o\\\\_           \\'\\/+-\\/`/`/\n" +
                "  /   \\             \\/-+--\\/`/ "));
        items.add(new Skin("hedgehog", 0, "     ////////// \n" +
                "     ///////////\n" +
                " /. `/username/\\\n" +
                "o__,_|||||||||||'"));
        items.add(new Skin("owl", 0, " ^ ^              \n" +
                "(O,O)             \n" +
                "(   ) username    \n" +
                "-\"-\"--------------"));
        items.add(new Skin("birds", 0, "  ___              ___  \n" +
                " (o o)            (o o) \n" +
                "(  V  ) username (  V  )\n" +
                "--m-m--------------m-m--"));
        items.add(new Skin("parrots", 0, " \\\\           =o) \n" +
                " (o>          /\\\\ \n" +
                "_(()_username_\\_V_\n" +
                " //            \\\\ \n" +
                "                \\\\"));
        //[0-2]
        games.add(new Game("Minecraft"));
        games.add(new Game("Call of Duty"));
        games.add(new Game("Super Mario Bros"));
        //[12-17]
        items.add(new GameItem("Diamond pickaxe", 1, games.get(0), 2d));
        items.add(new GameItem("Netherite pickaxe", 2, games.get(0), 3d));
        items.add(new GameItem("Chimera Assault Rifle", 1, games.get(1), 2d));
        items.add(new GameItem("KV Broadside Shotgun", 2, games.get(1), 3d));
        items.add(new GameItem("Super Mushroom", 1, games.get(2), 2d));
        items.add(new GameItem("Fire Flower", 2, games.get(2), 3d));
        //[18-20]
        items.add(new PointBag("Small Point Bag", 1, 1));
        items.add(new PointBag("Medium Point Bag", 2, 2));
        items.add(new PointBag("Big Point Bag", 3, 3));
        //Minecraft
        games.get(0).getActions().add(new Action("Mine diamonds"));
        games.get(0).getActions().get(0).getAchievements().add(new Achievement("2 Diamonds!",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(0).getActions().get(0).getAchievements().get(0).getReward().add(items.get(12));
        games.get(0).getActions().get(0).getAchievements().get(0).getReward().add(items.get(18));
        games.get(0).getActions().get(0).getAchievements().add(new Achievement("4 Diamonds!",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(0).getActions().get(0).getAchievements().get(1).getReward().add(items.get(13));
        games.get(0).getActions().get(0).getAchievements().get(1).getReward().add(items.get(19));
        games.get(0).getActions().get(0).getAchievements().add(new Achievement("8 Diamonds!",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(0).getActions().get(0).getAchievements().get(2).getReward().add(items.get(0));
        games.get(0).getActions().get(0).getAchievements().get(2).getReward().add(items.get(20));
        games.get(0).getActions().get(0).getAchievements().add(new Achievement("16 Diamonds!",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(0).getAchievements().get(3).getReward().add(items.get(1));
        games.get(0).getActions().get(0).getAchievements().get(3).getReward().add(items.get(20));
        games.get(0).getActions().get(0).getAchievements().add(new Achievement("32 Diamonds!",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(0).getAchievements().get(4).getReward().add(items.get(2));
        games.get(0).getActions().get(0).getAchievements().get(4).getReward().add(items.get(20));

        games.get(0).getActions().add(new Action("Defend Village"));
        games.get(0).getActions().get(1).getAchievements().add(new Achievement("Hero of the Village I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(0).getActions().get(1).getAchievements().get(0).getReward().add(items.get(12));
        games.get(0).getActions().get(1).getAchievements().get(0).getReward().add(items.get(18));
        games.get(0).getActions().get(1).getAchievements().add(new Achievement("Hero of the Village II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(0).getActions().get(1).getAchievements().get(1).getReward().add(items.get(13));
        games.get(0).getActions().get(1).getAchievements().get(1).getReward().add(items.get(19));
        games.get(0).getActions().get(1).getAchievements().add(new Achievement("Hero of the Village III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(0).getActions().get(1).getAchievements().get(2).getReward().add(items.get(0));
        games.get(0).getActions().get(1).getAchievements().get(2).getReward().add(items.get(20));
        games.get(0).getActions().get(1).getAchievements().add(new Achievement("Hero of the Village IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(1).getAchievements().get(3).getReward().add(items.get(1));
        games.get(0).getActions().get(1).getAchievements().get(3).getReward().add(items.get(20));
        games.get(0).getActions().get(1).getAchievements().add(new Achievement("Hero of the Village IV",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(1).getAchievements().get(4).getReward().add(items.get(2));
        games.get(0).getActions().get(1).getAchievements().get(4).getReward().add(items.get(20));

        games.get(0).getActions().add(new Action("Defeat the Ender Dragon"));
        games.get(0).getActions().get(2).getAchievements().add(new Achievement("The End... Again... I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(0).getActions().get(2).getAchievements().get(0).getReward().add(items.get(12));
        games.get(0).getActions().get(2).getAchievements().get(0).getReward().add(items.get(18));
        games.get(0).getActions().get(2).getAchievements().add(new Achievement("The End... Again... II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(0).getActions().get(2).getAchievements().get(1).getReward().add(items.get(13));
        games.get(0).getActions().get(2).getAchievements().get(1).getReward().add(items.get(19));
        games.get(0).getActions().get(2).getAchievements().add(new Achievement("The End... Again... III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(0).getActions().get(2).getAchievements().get(2).getReward().add(items.get(0));
        games.get(0).getActions().get(2).getAchievements().get(2).getReward().add(items.get(20));
        games.get(0).getActions().get(2).getAchievements().add(new Achievement("The End... Again... IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(2).getAchievements().get(3).getReward().add(items.get(1));
        games.get(0).getActions().get(2).getAchievements().get(3).getReward().add(items.get(20));
        games.get(0).getActions().get(2).getAchievements().add(new Achievement("The End... Again... V",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(0).getActions().get(2).getAchievements().get(4).getReward().add(items.get(2));
        games.get(0).getActions().get(2).getAchievements().get(4).getReward().add(items.get(20));

        //Call of Duty
        games.get(1).getActions().add(new Action("Headshot"));
        games.get(1).getActions().get(0).getAchievements().add(new Achievement("Headhunter I!",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(1).getActions().get(0).getAchievements().get(0).getReward().add(items.get(14));
        games.get(1).getActions().get(0).getAchievements().get(0).getReward().add(items.get(18));
        games.get(1).getActions().get(0).getAchievements().add(new Achievement("Headhunter II!",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(1).getActions().get(0).getAchievements().get(1).getReward().add(items.get(15));
        games.get(1).getActions().get(0).getAchievements().get(1).getReward().add(items.get(19));
        games.get(1).getActions().get(0).getAchievements().add(new Achievement("Headhunter III!",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(1).getActions().get(0).getAchievements().get(2).getReward().add(items.get(3));
        games.get(1).getActions().get(0).getAchievements().get(2).getReward().add(items.get(20));
        games.get(1).getActions().get(0).getAchievements().add(new Achievement("Headhunter IV!",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(0).getAchievements().get(3).getReward().add(items.get(4));
        games.get(1).getActions().get(0).getAchievements().get(3).getReward().add(items.get(20));
        games.get(1).getActions().get(0).getAchievements().add(new Achievement("Headhunter V!",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(0).getAchievements().get(4).getReward().add(items.get(5));
        games.get(1).getActions().get(0).getAchievements().get(4).getReward().add(items.get(20));

        games.get(1).getActions().add(new Action("Survive multiplayer game"));
        games.get(1).getActions().get(1).getAchievements().add(new Achievement("Last Man Standing I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(1).getActions().get(1).getAchievements().get(0).getReward().add(items.get(14));
        games.get(1).getActions().get(1).getAchievements().get(0).getReward().add(items.get(18));
        games.get(1).getActions().get(1).getAchievements().add(new Achievement("Last Man Standing II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(1).getActions().get(1).getAchievements().get(1).getReward().add(items.get(15));
        games.get(1).getActions().get(1).getAchievements().get(1).getReward().add(items.get(19));
        games.get(1).getActions().get(1).getAchievements().add(new Achievement("Last Man Standing III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(1).getActions().get(1).getAchievements().get(2).getReward().add(items.get(3));
        games.get(1).getActions().get(1).getAchievements().get(2).getReward().add(items.get(20));
        games.get(1).getActions().get(1).getAchievements().add(new Achievement("Last Man Standing IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(1).getAchievements().get(3).getReward().add(items.get(4));
        games.get(1).getActions().get(1).getAchievements().get(3).getReward().add(items.get(20));
        games.get(1).getActions().get(1).getAchievements().add(new Achievement("Last Man Standing IV",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(1).getAchievements().get(4).getReward().add(items.get(5));
        games.get(1).getActions().get(1).getAchievements().get(4).getReward().add(items.get(20));

        games.get(1).getActions().add(new Action("Destroy vehicle"));
        games.get(1).getActions().get(2).getAchievements().add(new Achievement("Demolition expert I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(1).getActions().get(2).getAchievements().get(0).getReward().add(items.get(14));
        games.get(1).getActions().get(2).getAchievements().get(0).getReward().add(items.get(18));
        games.get(1).getActions().get(2).getAchievements().add(new Achievement("Demolition expert II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(1).getActions().get(2).getAchievements().get(1).getReward().add(items.get(15));
        games.get(1).getActions().get(2).getAchievements().get(1).getReward().add(items.get(19));
        games.get(1).getActions().get(2).getAchievements().add(new Achievement("Demolition expert III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(1).getActions().get(2).getAchievements().get(2).getReward().add(items.get(3));
        games.get(1).getActions().get(2).getAchievements().get(2).getReward().add(items.get(20));
        games.get(1).getActions().get(2).getAchievements().add(new Achievement("Demolition expert IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(2).getAchievements().get(3).getReward().add(items.get(4));
        games.get(1).getActions().get(2).getAchievements().get(3).getReward().add(items.get(20));
        games.get(1).getActions().get(2).getAchievements().add(new Achievement("Demolition expert V",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(1).getActions().get(2).getAchievements().get(4).getReward().add(items.get(5));
        games.get(1).getActions().get(2).getAchievements().get(4).getReward().add(items.get(20));

        //Super Mario Bros
        games.get(2).getActions().add(new Action("Stomp Goomba"));
        games.get(2).getActions().get(0).getAchievements().add(new Achievement("Goomba Stomper I!",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(2).getActions().get(0).getAchievements().get(0).getReward().add(items.get(16));
        games.get(2).getActions().get(0).getAchievements().get(0).getReward().add(items.get(18));
        games.get(2).getActions().get(0).getAchievements().add(new Achievement("Goomba Stomper II!",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(2).getActions().get(0).getAchievements().get(1).getReward().add(items.get(17));
        games.get(2).getActions().get(0).getAchievements().get(1).getReward().add(items.get(19));
        games.get(2).getActions().get(0).getAchievements().add(new Achievement("Goomba Stomper III!",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(2).getActions().get(0).getAchievements().get(2).getReward().add(items.get(6));
        games.get(2).getActions().get(0).getAchievements().get(2).getReward().add(items.get(20));
        games.get(2).getActions().get(0).getAchievements().add(new Achievement("Goomba Stomper IV!",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(0).getAchievements().get(3).getReward().add(items.get(7));
        games.get(2).getActions().get(0).getAchievements().get(3).getReward().add(items.get(20));
        games.get(2).getActions().get(0).getAchievements().add(new Achievement("Goomba Stomper V!",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(0).getAchievements().get(4).getReward().add(items.get(8));
        games.get(2).getActions().get(0).getAchievements().get(4).getReward().add(items.get(20));

        games.get(2).getActions().add(new Action("Get a Star powerup"));
        games.get(2).getActions().get(1).getAchievements().add(new Achievement("Star Collector I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(2).getActions().get(1).getAchievements().get(0).getReward().add(items.get(16));
        games.get(2).getActions().get(1).getAchievements().get(0).getReward().add(items.get(18));
        games.get(2).getActions().get(1).getAchievements().add(new Achievement("Star Collector II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(2).getActions().get(1).getAchievements().get(1).getReward().add(items.get(17));
        games.get(2).getActions().get(1).getAchievements().get(1).getReward().add(items.get(19));
        games.get(2).getActions().get(1).getAchievements().add(new Achievement("Star Collector III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(2).getActions().get(1).getAchievements().get(2).getReward().add(items.get(6));
        games.get(2).getActions().get(1).getAchievements().get(2).getReward().add(items.get(20));
        games.get(2).getActions().get(1).getAchievements().add(new Achievement("Star Collector IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(1).getAchievements().get(3).getReward().add(items.get(7));
        games.get(2).getActions().get(1).getAchievements().get(3).getReward().add(items.get(20));
        games.get(2).getActions().get(1).getAchievements().add(new Achievement("Star Collector IV",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(1).getAchievements().get(4).getReward().add(items.get(8));
        games.get(2).getActions().get(1).getAchievements().get(4).getReward().add(items.get(20));

        games.get(2).getActions().add(new Action("Defeat Bowser"));
        games.get(2).getActions().get(2).getAchievements().add(new Achievement("King Koopa's Nemesis I",2, Rank.getDefaultRank(), Membership.getDefaultMembership()));
        games.get(2).getActions().get(2).getAchievements().get(0).getReward().add(items.get(16));
        games.get(2).getActions().get(2).getAchievements().get(0).getReward().add(items.get(18));
        games.get(2).getActions().get(2).getAchievements().add(new Achievement("King Koopa's Nemesis II",4, ranks.get(0), Membership.getDefaultMembership()));
        games.get(2).getActions().get(2).getAchievements().get(1).getReward().add(items.get(17));
        games.get(2).getActions().get(2).getAchievements().get(1).getReward().add(items.get(19));
        games.get(2).getActions().get(2).getAchievements().add(new Achievement("King Koopa's Nemesis III",8, ranks.get(1), Membership.getDefaultMembership()));
        games.get(2).getActions().get(2).getAchievements().get(2).getReward().add(items.get(6));
        games.get(2).getActions().get(2).getAchievements().get(2).getReward().add(items.get(20));
        games.get(2).getActions().get(2).getAchievements().add(new Achievement("King Koopa's Nemesis IV",16, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(2).getAchievements().get(3).getReward().add(items.get(7));
        games.get(2).getActions().get(2).getAchievements().get(3).getReward().add(items.get(20));
        games.get(2).getActions().get(2).getAchievements().add(new Achievement("King Koopa's Nemesis V",31, Rank.getDefaultRank(), memberships.get(0)));
        games.get(2).getActions().get(2).getAchievements().get(4).getReward().add(items.get(8));
        games.get(2).getActions().get(2).getAchievements().get(4).getReward().add(items.get(20));


    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        List<Item> wrappedItems = new LinkedList<>();
        for (Item item : transaction.getItems()) {
            wrappedItems.add(new Gift(item));
        }
        transaction.getTo().receive(wrappedItems);
    }

}
