package walls;

import java.awt.Color;

public class Floor extends Wall {

    private final Color FLOOR_COLOR = Color.gray;
    public final Object isFloor=new Object();
    
    public Floor(){
        this.color=FLOOR_COLOR;
    }
    
    @Override
    public Color getColor(){
        return this.color;
    }
}
