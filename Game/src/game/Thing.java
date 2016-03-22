package game;

import java.util.ArrayList;
import walls.*;

public class Thing {

    protected Position position;
    protected Dimension dimension;

    public Thing() {
    }

    public Thing(Position position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Position getPosition() {
        return this.position;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public static boolean isCollideWithWall(Thing thing, ArrayList<Wall> walls) {
        for (Wall wall : walls) {
            //System.out.println(wall.dimension == null);
            try {//only checks collide if isn't a floor
                Floor test = (Floor) wall;
            }
            catch (ClassCastException e) {
                if (isCollide(thing, (Thing) wall)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCollide(Thing one, Thing two) {
        int[] b1 = getBounds(one);
        int[] b2 = getBounds(two);
        
        
        return (isBetween(b1[0], b2[0], b2[2]) || isBetween(b1[2], b2[0], b2[2]))
                && (isBetween(b1[1], b2[1], b2[3]) || isBetween(b1[3], b2[1], b2[3]));
    }

    //{left,top,right,bottom}
    private static int[] getBounds(Thing thing) {
        Position pos = thing.getPosition();
        Dimension dim = thing.getDimension();
        //System.out.println(dim==null);

        int left = pos.getX();
        int top = pos.getY();
        int right = left + dim.getWidth();
        int bottom = top + dim.getHeight();

        return new int[]{left, top, right, bottom};
    }

    private static boolean isBetween(int check, int lesser, int greater) {
        return check > lesser && check < greater;
    }
}
