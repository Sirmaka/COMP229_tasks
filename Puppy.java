import java.awt.*;

public class Puppy extends Actor {

    public Puppy(Cell loc){
        this.loc = loc;
        this.colour = Color.GREEN;
        Polygon puppyEar1 = new Polygon();
        Polygon puppyEar2 = new Polygon();
        Polygon puppyFace = new Polygon();
    
        poly.add(puppyEar1);
        puppyEar1.addPoint(loc.x + 5, loc.y + 5);
        puppyEar1.addPoint(loc.x + 15, loc.y + 5);
        puppyEar1.addPoint(loc.x + 5, loc.y + 15);
        poly.add(puppyEar2);
        puppyEar2.addPoint(loc.x + 20, loc.y + 5);
        puppyEar2.addPoint(loc.x + 30, loc.y + 5);
        puppyEar2.addPoint(loc.x + 30, loc.y + 15);
        poly.add(puppyFace);
        puppyFace.addPoint(loc.x+8, loc.y + 7);
        puppyFace.addPoint(loc.x+27, loc.y + 7);
        puppyFace.addPoint(loc.x+27, loc.y + 25);
        puppyFace.addPoint(loc.x+8, loc.y + 25);
    }

}