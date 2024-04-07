import java.util.ArrayList;
import java.util.List;

public class Ship {

    private int size;
    private List<Cordinate> cordinates;

    public int getSize() {
        return size;
    }

    public List<Cordinate> getCordinates() {
        return cordinates;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCordinates(List<Cordinate> cordinates) {
        this.cordinates = cordinates;
    }

    Ship(int size, List<Cordinate> cordinates) {
        this.size = size;
        this.cordinates = cordinates;
    }

}
