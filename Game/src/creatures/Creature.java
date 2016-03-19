package creatures;

import game.*;

public abstract class Creature extends Thing{
    protected int currentHealth;
    protected int maxHealth;
    protected int speed;
    protected char facingDirection;
    protected int attackDamage;
    protected int attackRange;
}
