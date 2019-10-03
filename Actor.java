import java.awt.*;
import java.util.ArrayList;

public abstract class Actor {
    Color colour;
    Cell loc;
    ArrayList<Polygon> display;
    MoveStrategy strat;
    float redness;
    int turns;
    int moves;
    boolean danced = false; //first dance

    AnimationBeat beat = AnimationBeat.getInstance();


    //this is where the dancing should go
    public void paint(Graphics g){
        for(Polygon p: display){
            //if(danced == false){
                dance(p);
            //}
            

            g.setColor(new Color(redness, 0f, 1f-redness));
            g.fillPolygon(p);
            g.setColor(Color.GRAY);
            g.drawPolygon(p);
        }
    }

    public abstract void setPoly();

    public boolean isTeamRed(){
        return redness >= 0.5;
    }

    public void setLocation(Cell loc){
        this.loc = loc;
        if (this.loc.row % 2 == 0){
            this.strat = new RandomMove();
        } else {
            this.strat = new LeftMostMove();
        }
        setPoly();
    }

    private void dance(Polygon p){
        boolean hasDancedB = false;
        boolean hasDancedC = false;
        char phase = beat.inPhase();
            if(phase == 'b' && hasDancedB == false){
                for(int i = 0; i < p.xpoints.length; i++){
                    p.ypoints[i] -= 1;
                }
                hasDancedB = true;
            }
            if(phase == 'c' && hasDancedC == false){
                for(int i = 0; i < p.xpoints.length; i++){
                    p.ypoints[i] += 1;
                }
                hasDancedC = true;
            }
    }
}