import java.awt.*;
import java.util.*;

class Display{
    Stage stage;
    int minX = 720; //leftmost location of display text.
    int subMinX = 730; //leftomost location of display text for data within objects.
    int maxX = 820;//rightmost location of display text.

    public Display(Stage stage){
        this.stage = stage;
        
    }
    
    public void paint(Graphics g, Point mouseLoc){
        g.setColor(Color.DARK_GRAY);
        g.drawString(stage.state.toString(),minX,20); 
        // display cell.
        Optional<Cell> cap = stage.grid.cellAtPoint(mouseLoc);
        if (cap.isPresent()){
            Cell capc = cap.get();
            g.setColor(Color.DARK_GRAY);
            g.drawString(String.valueOf(capc.col) + String.valueOf(capc.row), minX, 50);
            g.drawString(capc.description, maxX, 50);
            g.drawString("movement cost", minX, 65);
            g.drawString(String.valueOf(capc.movementCost()), maxX, 65);
        } 

        // agent display.
        int yloc = 138;
        for(int i = 0; i < stage.actors.size(); i++){
            Actor a = stage.actors.get(i);
            g.drawString(a.getClass().toString(),minX, yloc + 70*i);
            g.drawString("location:", subMinX, yloc + 13 + 70 * i);
            g.drawString(Character.toString(a.loc.col) + Integer.toString(a.loc.row), maxX, yloc + 13 + 70 * i);
            g.drawString("redness:", subMinX, yloc + 26 + 70*i);
            g.drawString(Float.toString(a.redness), maxX, yloc + 26 + 70*i);
            g.drawString("strat:", subMinX, yloc + 39 + 70*i);
            g.drawString(a.strat.toString(), maxX, yloc + 39 + 70*i);
        }
    }


}