import java.util.*;

public class BattleFieldGame {

    BattleField battleField;

    List<Missile> missiles;

    private int size;

    Player player1;
    Player player2;
    public void initGame(int size) {
        battleField = new BattleField(size);
        Player player1 = new Player("PlayerA");
        Player player2 = new Player("PlayerB");
        missiles = new ArrayList<>();
        this.size = size;
    }

    void addShip(String name, int size, int x, int y, int bx, int by) {
        int[] xcords = {0,1,-1,0};
        int[] ycords = {1,0,0,-1};
        List<Cordinate> cordinates = new ArrayList<>();
        for(int i=0;i<xcords.length;i++) {
            cordinates.add(new Cordinate(x+xcords[i], y+ycords[i]));
        }
        Ship ship1 = new Ship(size, cordinates);
        player1.getShips().add(ship1);

        for(int i=0;i<xcords.length;i++) {
            cordinates.add(new Cordinate(bx+xcords[i], by+ycords[i]));
        }
        Ship ship2 = new Ship(size, cordinates);
        player2.getShips().add(ship2);
    }

    Missile fireMissile() {
        int x = new Random(this.size).nextInt();
        int y = new Random(this.size).nextInt();
        Missile missile = new Missile(x,y);
        missiles.add(missile);
        return missile;
    }

    void startGame() {
        boolean turn = true;
        while(true) {
            Missile missile = fireMissile();
            if(turn){
                destoryShip(player2, missile);
            } else {
                destoryShip(player1, missile);
            }
            if(player1.getShips().size()==0 || player2.getShips().size()==0){
                String winner = player1.getShips().size()==0?"PayerB":"PlayerB";
                System.out.println("GameOver."+winner+" wins.");
                break;
            }
        }
    }

    void destoryShip(Player player, Missile missile) {
        Ship rship = null;
        boolean isShipRemove = false;
        for(Ship ship: player.getShips()) {
            for(Cordinate shipCord:ship.getCordinates()){
               if(missile.getXcord()==shipCord.getXcord() && missile.getycord()==shipCord.getYcord()){
                   isShipRemove = true;
                   rship = ship;
                   break;
               }
            }
            if(isShipRemove) {
                player.getShips().remove(rship);
                System.out.println(player.getName()+"'s turn: Missile fired at ("
                        +missile.getXcord()+","+missile.getycord()+")");
                break;
            }
        }
    }
}
