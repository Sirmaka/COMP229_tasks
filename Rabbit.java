import java.awt.*;

public class Rabbit extends Actor {

    public Rabbit(Cell loc) {
        this.loc = loc;
        this.colour = Color.WHITE;
        Polygon rabbitEar1 = new Polygon();
        Polygon rabbitEar2 = new Polygon();
        Polygon rabbitFace = new Polygon();
        poly.add(rabbitEar1);
        rabbitEar1.addPoint(loc.x + 11, loc.y + 5);
        rabbitEar1.addPoint(loc.x + 11, loc.y + 12);
        rabbitEar1.addPoint(loc.x + 16, loc.y + 12);
        rabbitEar1.addPoint(loc.x + 16, loc.y + 5);
        poly.add(rabbitEar2);
        rabbitEar2.addPoint(loc.x + 19, loc.y + 5);
        rabbitEar2.addPoint(loc.x + 19, loc.y + 12);
        rabbitEar2.addPoint(loc.x + 24, loc.y + 12);
        rabbitEar2.addPoint(loc.x + 24, loc.y + 5);
        poly.add(rabbitFace);
        rabbitFace.addPoint(loc.x+8, loc.y + 12);
        rabbitFace.addPoint(loc.x+27, loc.y + 12);
        rabbitFace.addPoint(loc.x+27, loc.y + 25);
        rabbitFace.addPoint(loc.x+8, loc.y + 25);
        
    }

}