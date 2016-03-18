package rooms;
import java.util.ArrayList;
import creatures.Enemy;
import walls.Wall;

public class EnemyRoom extends Room {
    public static int MAX_ENEMIES_PER_ROOM=7;
    protected ArrayList<Enemy> enemies;
    
    public EnemyRoom(ArrayList<Wall> walls, ArrayList<Enemy> enemies){
        super(walls);
        this.enemies=enemies;
    }
    
    public ArrayList<Enemy> getEnemies(){
        return this.enemies;
    }
}
