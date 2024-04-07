import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
