package walls;

import java.awt.Color;

public class NormalWall extends Wall {

    private final Color WALL_COLOR = Color.blue;

    public NormalWall(){
        this.color=WALL_COLOR;
    }
    
    @Override
    public Color getColor() {
        return WALL_COLOR;
    }
}
