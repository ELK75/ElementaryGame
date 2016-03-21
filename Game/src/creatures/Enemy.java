package creatures;

import game.Position;
import java.awt.Color;

public class Enemy extends Creature{
    protected String problem;
    protected String solution;
    
    public Enemy(int problemType){
        String[] problemData=game.ProblemGenerator.getProblem(problemType);
        this.problem=problemData[0];
        this.solution=problemData[1];
    }
    
    public void move(){
        
    }
    
    public Color getColor(){
        return Color.yellow;
    }
}
