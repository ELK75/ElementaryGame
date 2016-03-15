package walls;

import java.awt.Color;

public class Floor extends Wall {

    private final Color FLOOR_COLOR = Color.gray;

    public Color getColor() {
        return FLOOR_COLOR;
    }
}
