import java.awt.*;
import java.util.ArrayList;


public abstract class Actor {
    Color colour;
    Cell loc;
    //polygons for drawing
    ArrayList<Polygon> poly = new ArrayList<Polygon>();

    public void paint(Graphics g){
        for(Polygon p: poly){
            g.drawPolygon(p);
        }
    }
}