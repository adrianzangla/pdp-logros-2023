import java.util.LinkedList;
import java.util.List;

public class AchievementSystem {
    private static List<Transaction> transactions;
    private static List<Game> games;
    private static List<User> users;
    private static List<Rank> ranks;
    private static List<Membership> memberships;
    private static List<Item> items;
    private static List<Transaction> getTransactions() {
        return transactions;
    }


    public static void initialize() {
        List<Membership> memberships = new LinkedList<>();
        memberships.add(new Membership("Preferencial", 1, 2d, 24*30));
        memberships.add(new Membership("VIP", 2, 4d, 24*30));
        AchievementSystem.memberships = memberships;
        List<Rank> ranks = new LinkedList<>();
        ranks.add(new Rank("Pro", 1, 1));
        ranks.add(new Rank("God", 2, 2));
        AchievementSystem.ranks = ranks;
        List<Item> items = new LinkedList<>();
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
        Game minecraft = new Game("Minecraft");
        Game callOfDuty = new Game("Call of Duty");
        Game marioBros = new Game("Mario Bros");
        items.add(new GameItem("Diamond pickaxe", 1, minecraft, 2d));
        items.add(new GameItem("Netherite pickaxe", 2, minecraft, 3d));
        items.add(new GameItem("Chimera Assault Rifle", 1, callOfDuty, 2d));
        items.add(new GameItem("KV Broadside Shotgun", 2, callOfDuty, 3d));
        items.add(new GameItem("Super Mushroom", 1, marioBros, 2d));
        items.add(new GameItem("Fire Flower", 2, marioBros, 3d));
        Achievement a0 = new Achievement()




    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.getTo().receive(transaction.getItems());
    }



}
