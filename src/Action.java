import java.util.Objects;

public class Action {

    private final String name;
    private final String gameName;

    public Action(String name, String gameName) {
        this.name = name;
        this.gameName = gameName;
    }

    public String getGameName() {
        return this.gameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(name, action.name) && Objects.equals(gameName, action.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gameName);
    }
}

