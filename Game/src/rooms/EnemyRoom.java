package rooms;
import java.util.ArrayList;
import creatures.Enemy;
import walls.Wall;

public class EnemyRoom extends Room {
    protected ArrayList<Enemy> enemies;
    
    public EnemyRoom(ArrayList<Wall> walls, ArrayList<Enemy> enemies){
        this.walls=walls;
        this.enemies=enemies;
    }
}
