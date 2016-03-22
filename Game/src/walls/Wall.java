package walls;

import game.*;
//import creatures.Creature;
import java.awt.Color;

public abstract class Wall extends Thing {
    public static final int WALL_TYPES=5;
    public static final Dimension DEFAULT_WALL_DIMENSIONS=new Dimension(Game.ROOM_WIDTH_PIXELS/Game.ROOM_WIDTH_SQUARES,Game.ROOM_HEIGHT_PIXELS/Game.ROOM_HEIGHT_SQUARES);
    protected Color color;
    
    //public abstract void checkCollide(Creature creature);
    
    public void setPosition(int index){
        this.position=new Position(index);
    }
    
    public Color getColor(){
        return this.color;
    }
}
