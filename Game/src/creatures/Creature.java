package creatures;

import game.Position;
import game.Dimension;

public abstract class Creature {
    protected int currentHealth;
    protected int maxHealth;
    protected int speed;
    protected Position position;
    protected char facingDirection;
    protected int attackDamage;
    protected int attackRange;
}
