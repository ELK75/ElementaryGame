package game;
import rooms.*;
import java.util.Random;
import java.util.ArrayList;
public class Game extends JComponentWithEvents {

    private final int TYPES_OF_ROOMS = 1;
    private final int MAX_NUM_ROOMS = 6;
    private ArrayList<Room> ROOMS = new ArrayList(MAX_NUM_ROOMS);

    void chooseRoom() {
        Room room = new Room();
        for (int rooms = 0; rooms < MAX_NUM_ROOMS-1; rooms++) {
            Random random = new Random();
            int roomSelect = random.nextInt(TYPES_OF_ROOMS);
            room.createRoom(roomSelect);
        }
    }

public static void main(String[] args) {
        // TODO code application logic here
    }

}
