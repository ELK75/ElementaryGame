
package game;

public class Dimension {
    private int width;
    private int height;
    
    public Dimension(int width, int height){
        this.width=width;
        this.height=height;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    @Override
    public Dimension clone(){
        return new Dimension(this.width,this.height);
    }
}
