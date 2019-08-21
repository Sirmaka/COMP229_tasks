import java.awt.*;

public class Lion extends Actor {
    
    public Lion(Cell loc) {
        this.loc = loc;
        //this.colour = Color.RED;
        Polygon mane = new Polygon();
        Polygon lionFace = new Polygon();
        poly.add(mane);
        mane.addPoint(loc.x + 6, loc.y + 6);
        mane.addPoint(loc.x + 29, loc.y + 6);
        mane.addPoint(loc.x + 29, loc.y + 29);
        mane.addPoint(loc.x + 6, loc.y + 29);
        poly.add(lionFace);
        lionFace.addPoint(loc.x + 11, loc.y + 11);
        lionFace.addPoint(loc.x + 24, loc.y + 11);
        lionFace.addPoint(loc.x + 24, loc.y + 24);
        lionFace.addPoint(loc.x + 11, loc.y + 24);
    }

}