public class Cordinate {

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }

    public void setXcord(int xcord) {
        this.xcord = xcord;
    }

    public void setYcord(int ycord) {
        this.ycord = ycord;
    }

    private int xcord;
    private int ycord;

    private boolean isOccupaied;

    Cordinate(int xcord,int ycord) {
        this.xcord = xcord;
        this.ycord = ycord;
        this.isOccupaied = true;

    }
}
