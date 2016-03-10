package walls;

import game.Position;
import game.Dimension;
import creatures.Creature;

public abstract class Wall {
    protected Position position;
    protected Dimension dimension;
    
    public abstract void checkCollide(Creature creature);
}
