import java.awt.*;
import java.util.ArrayList;

public class Stage {
    Grid grid;
    Actor puppy;
    Actor lion;
    Actor rabbit;
    ArrayList<Actor> actors = new ArrayList<Actor>();

    public Stage(){
        grid = new Grid();       
        
        puppy = new Puppy(grid.cellAtColRow(0, 0));
        lion = new Lion(grid.cellAtColRow(0, 18));
        rabbit = new Rabbit(grid.cellAtColRow(14,3));
        Actor rabbit2 = new Rabbit(grid.cellAtColRow(13,3));
        actors.add(puppy);
        actors.add(lion);
        actors.add(rabbit);
        actors.add(rabbit2);
    }

    public void paint(Graphics g, Point mouseLoc){
        grid.paint(g,mouseLoc);
        //paint the arrayList
        for(Actor a: actors){
            a.paint(g);
        }
    }
}