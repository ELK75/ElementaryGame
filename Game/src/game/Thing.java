package game;

public class Thing {
    protected Position position;
    protected Dimension dimension;
    
    public Thing(){
    }
    
    public Thing(Position position, Dimension dimension){
        this.position=position;
        this.dimension=dimension;
    }
    
    public void setPosition(Position position){
        this.position=position;
    }
    
    public void setDimension(Dimension dimension){
        this.dimension=dimension;
    }
    
    public Position getPosition(){
        return this.position;
    }
    
    public Dimension getDimension(){
        return this.dimension;
    }
}
