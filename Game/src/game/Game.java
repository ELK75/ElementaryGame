package game;

import rooms.*;
import walls.*;
import creatures.Enemy;
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
            ArrayList<Enemy> enemies = generateEnemies(walls,type);
            return new EnemyRoom(walls, enemies);
        }
        throw new RuntimeException("Invalid room type");
    }

    private ArrayList<Wall> generateWalls(int type) {
        ArrayList<Wall> out = new ArrayList<>();
        //not following template right now, 50% chance a square will have a wall
        for (int i = 0; i < ROOM_WIDTH_SQUARES * ROOM_HEIGHT_SQUARES; i++) {
            out.add(makeWall());
        }

        return out;
    }
    
    private Wall makeWall(){
        Wall wall;
            if (Math.random() < .5) {
                wall = new NormalWall();
            }
            else {
                wall = new Floor();
            }
            return wall;
    }

    private ArrayList<Enemy> generateEnemies(ArrayList<Wall> walls,int type) {
        ArrayList<Enemy> out = new ArrayList<>();
        int enemyTotal = (int) (Math.random() * EnemyRoom.MAX_ENEMIES_PER_ROOM);

        for (int i = 0; i < enemyTotal; i++) {
            out.add(makeEnemy(walls));
        }
        return out;
    }

    private Enemy makeEnemy(ArrayList<Wall> walls) {//will need to tell enemy what problem type
        Enemy enemy;
        //do{
            Position position = Position.getRandomPosition();
             enemy=new Enemy(position, ProblemGenerator.ADDITION);
        //}while(isCollideWithWall((Thing)enemy, walls));
        return enemy;
    }

    private boolean isCollideWithWall(Thing thing, ArrayList<Wall> walls){
        for(Wall wall:walls){
            if(isCollide(thing,(Thing)wall)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isCollide(Thing one, Thing two){
        int[] b1=getBounds(one);
        int[] b2=getBounds(two);
        return isBetween(b1[0],b2[0],b2[2])||isBetween(b1[2],b2[0],b2[2])||
                isBetween(b1[1],b2[1],b2[3])||isBetween(b1[3],b2[1],b2[3]);
    }
    
    private int[] getBounds(Thing thing){
        Position pos=thing.getPosition();
        Dimension dim=thing.getDimension();
        
        int left=pos.getX();
        int top=pos.getY();
        int right=left+dim.getWidth();
        int bottom=top+dim.getHeight();
        
        return new int[]{left,top,right,bottom};
    }
    
    private boolean isBetween(int check, int lesser, int greater){
        return check>lesser&&check<greater;
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

            int left = position.getX();
            int top = position.getY();
            int width = left + dimension.getWidth();
            int height = top + dimension.getHeight();

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
        for(Enemy enemy:enemies){
            Position position=enemy.getPosition();
            Color color=enemy.getColor();
            
            int x=position.getX();
            int y=position.getY();
            int tempWidth=50;
            int tempHeight=50;
            
            page.setColor(color);
            page.fillRect(x,y,tempWidth,tempHeight);
        }
    }

    public static void main(String[] args) {
        launch(ROOM_WIDTH_PIXELS, ROOM_HEIGHT_PIXELS);
    }

}
