package game;

import rooms.*;
import walls.*;
import creatures.Enemy;
import java.util.ArrayList;

public class Game extends JComponentWithEvents {

    public static final int TYPES_OF_ROOMS = 1;
    public static final int MAX_NUM_ROOMS = 9;
    public static final int ROOM_SIZE = 16;
    private ArrayList<Room> rooms = new ArrayList();
    
    @Override
    public void start(){
        generateRooms();
    }

    private void generateRooms() {
        for (int i = 0; i < MAX_NUM_ROOMS; i++) {
            //only making enemy rooms right now
            //@todo: make sure all rooms are reachable
            rooms.add(makeRoom(1));
        }
    }

    private Room makeRoom(int type) {
        if (type == 0) {
            return null;
        }
        else if (type == 1) {
            ArrayList<Wall> walls = generateWalls(type);
            ArrayList<Enemy> enemies = generateEnemies(type);
            return new EnemyRoom(walls, enemies);
        }
        throw new RuntimeException("Invalid room type");
    }

    private ArrayList<Wall> generateWalls(int type) {
        ArrayList<Wall> out = new ArrayList<>();
        //not following template right now
        for (int i = 0; i < ROOM_SIZE; i++) {
            Wall wall;
            if (Math.random() < .5) {
                wall = new NormalWall();
                out.add(wall);
            }
            else {
                wall = new Floor();
                out.add(wall);
            }
        }

        return out;
    }

    private ArrayList<Enemy> generateEnemies(int type) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        launch(500,500);
    }

}
