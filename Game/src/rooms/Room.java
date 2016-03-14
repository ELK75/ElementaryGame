package rooms;

import walls.Wall;
import creatures.Player;
import java.util.Random;
import java.util.ArrayList;

public abstract class Room {

    //static variables
    public static final int MARGIN = 10;

    //basic variabls
    protected ArrayList<Wall> walls;

    //player variables
    protected Player player;
    private int score;

    void createRoom(int room) {

    }
}
