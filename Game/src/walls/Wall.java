package walls;

import game.Position;
import game.Dimension;
import creatures.Creature;

public abstract class Wall {
    public static final int WALL_TYPES=5;
    protected Position position;
    protected Dimension dimension;
    
    public abstract void checkCollide(Creature creature);
}
