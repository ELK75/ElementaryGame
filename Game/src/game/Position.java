package game;

public class Position {
    private int x;
    private int y;
    /**
     * @param x object's x position in pixels
     * @param y object's y position in pixels
     */
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * @param index object's index in the squares array.
     */
    public Position(int index){
        this.y=index/Game.ROOM_WIDTH_SQUARES*Game.ROOM_HEIGHT_PIXELS/Game.ROOM_WIDTH_SQUARES;
        this.x=index%Game.ROOM_WIDTH_SQUARES*Game.ROOM_WIDTH_PIXELS/Game.ROOM_WIDTH_SQUARES;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public static Position getRandomPosition(){
        int x=(int)(Math.random()*Game.ROOM_WIDTH_PIXELS);
        int y=(int)(Math.random()*Game.ROOM_HEIGHT_PIXELS);
        return new Position(x,y);
    }
}
