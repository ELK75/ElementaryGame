package rooms;

import walls.Wall;
import creatures.Player;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public abstract class Room {

    //static variables
    public static final int MARGIN = 10;
    public static final int MAX_ROOM_TILES = 100;

    //basic variabls
    protected ArrayList<Wall> walls;

    //player variables
    protected Player player;
    private int score;

    public Room(ArrayList<Wall> walls) {
        this.walls = walls;
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }
}
