package creatures;

import game.*;

public abstract class Creature extends Thing{
    public static final int DEFAULT_HIT_BOX_HEIGHT=60;
    public static final int DEFAULT_HIT_BOX_WIDTH=60;
    public static final Dimension DEFAULT_CREATURE_DIMENSIONS=new Dimension(DEFAULT_HIT_BOX_WIDTH,DEFAULT_HIT_BOX_HEIGHT);
    protected int currentHealth;
    protected int maxHealth;
    protected int speed;
    protected char facingDirection;
    protected int attackDamage;
    protected int attackRange;
}
