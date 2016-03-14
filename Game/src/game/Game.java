package game;
import rooms.*;
import java.util.Random;
import java.util.ArrayList;
public class Game extends JComponentWithEvents {

    private final int TYPES_OF_ROOMS = 1;
    private final int MAX_NUM_ROOMS = 6;
    private ArrayList<Room> ROOMS = new ArrayList(MAX_NUM_ROOMS);

    void chooseRoom() {
        for (int room = 0; room < MAX_NUM_ROOMS; room++) {
            Random random = new Random();
            int roomSelect = random.nextInt(TYPES_OF_ROOMS);
            createRoom(roomSelect);
        }
    }

public static void main(String[] args) {
        // TODO code application logic here
    }

}
