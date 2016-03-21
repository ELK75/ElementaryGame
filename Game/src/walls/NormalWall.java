package walls;

import java.awt.Color;

public class NormalWall extends Wall {

    private final Color WALL_COLOR = Color.blue;
    public final Object isNormalWall=new Object();

    @Override
    public Color getColor() {
        return WALL_COLOR;
    }
}
