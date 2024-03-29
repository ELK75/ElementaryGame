package game;

import rooms.*;
import walls.*;
import creatures.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game extends JComponentWithEvents {

    //constants with squares
    public static final int TYPES_OF_ROOMS = 1;
    public static final int MAX_NUM_ROOMS = 9;
    public static final int ROOM_WIDTH_SQUARES = 12;
    public static final int ROOM_HEIGHT_SQUARES = 8;
    //constants with pixels
    public static final int ROOM_WIDTH_PIXELS = 1200;
    public static final int ROOM_HEIGHT_PIXELS = 800;
    public static final int MARGIN = 50;

    //variables
    private ArrayList<Room> rooms = new ArrayList();
    private Room currentRoom;

    //Game Logic
    @Override
    public void start() {
        generateRooms();
    }

    private void generateRooms() {
        for (int i = 0; i < MAX_NUM_ROOMS; i++) {
            //only making enemy rooms right now
            //@todo: make sure all rooms are reachable
            rooms.add(makeRoom(1));
        }
        int randomRoomIndex = (int) (Math.random() * rooms.size());
        currentRoom = rooms.get(randomRoomIndex);
    }

    private Room makeRoom(int type) {
        if (type == 0) {
            return null;
        }
        else if (type == 1) {
            ArrayList<Wall> walls = generateWalls(type);
            ArrayList<Enemy> enemies = generateEnemies(walls, type);
            return new EnemyRoom(walls, enemies);
        }
        throw new RuntimeException("Invalid room type");
    }

    private ArrayList<Wall> generateWalls(int type) {
        int roomTypeIndex = (int) (Math.random() * RoomTemplates.ROOM_TYPES);
        char[][] wallLayout = RoomTemplates.ROOM_TEMPLATES[roomTypeIndex];
        ArrayList<Wall> out = makeWalls(wallLayout);
        generateWallDims(out);

        return out;
    }

    private ArrayList<Wall> makeWalls(char[][] wallLayout) {
        ArrayList<Wall> out = new ArrayList<>();
        for (int i = 0; i < wallLayout.length; i++) {
            for (int j = 0; j < wallLayout[i].length; j++) {
                switch (wallLayout[i][j]) {
                    case ('n'):
                        out.add(new NormalWall());
                        break;
                    case ('f'):
                        out.add(new Floor());
                        break;
                    default:
                        throw new RuntimeException("Wall type not recognized");
                }
            }
        }
        return out;
    }

    private void generateWallDims(ArrayList<Wall> walls) {
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.setPosition(i);
            wall.setDimension(Wall.DEFAULT_WALL_DIMENSIONS.clone());
        }
    }

    private ArrayList<Enemy> generateEnemies(ArrayList<Wall> walls, int type) {
        ArrayList<Enemy> out = new ArrayList<>();
        int enemyTotal = (int) (Math.random() * EnemyRoom.MAX_ENEMIES_PER_ROOM);

        for (int i = 0; i < enemyTotal; i++) {
            out.add(makeEnemy(walls));
        }
        return out;
    }

    private Enemy makeEnemy(ArrayList<Wall> walls) {//will need to tell enemy what problem type
        Enemy enemy;
        enemy = new Enemy(ProblemGenerator.ADDITION);
        enemy.setDimension(Creature.DEFAULT_CREATURE_DIMENSIONS);
        do {
            Position position = Position.getRandomPosition();
            enemy.setPosition(position);
            System.out.println(enemy.dimension.getWidth()+", "+enemy.dimension.getHeight());
            //System.out.println("here");
        }
        while (Thing.isCollideWithWall((Thing) enemy, walls));
        return enemy;
    }

    //Game graphics
    @Override
    public void paint(Graphics2D page) {
        drawWalls(page);
        drawEnemies(page);
    }

    private void drawWalls(Graphics2D page) {
        ArrayList<Wall> walls = currentRoom.getWalls();
        for (Wall wall : walls) {
            Position position = wall.getPosition();
            Dimension dimension = wall.getDimension();
            Color color = wall.getColor();

            int left = position.getX() + MARGIN;
            int top = position.getY() + MARGIN;
            int width = dimension.getWidth();
            int height = dimension.getHeight();

            page.setColor(color);
            page.fillRect(left, top, width, height);
        }
    }

    private void drawEnemies(Graphics2D page) {
        EnemyRoom room;
        try {
            room = (EnemyRoom) currentRoom;
        }
        catch (Exception e) {
            return;
        }
        ArrayList<Enemy> enemies = room.getEnemies();
        for (Enemy enemy : enemies) {
            Position position = enemy.getPosition();
            Color color = enemy.getColor();

            int x = position.getX();
            int y = position.getY();
            int tempWidth = 50;
            int tempHeight = 50;

            page.setColor(color);
            page.fillRect(x, y, tempWidth, tempHeight);
        }
    }

    public static void main(String[] args) {
        System.out.println(ROOM_HEIGHT_PIXELS + 2 * MARGIN);
        launch(ROOM_WIDTH_PIXELS + 2 * MARGIN, ROOM_HEIGHT_PIXELS + 2 * MARGIN);
    }

}
