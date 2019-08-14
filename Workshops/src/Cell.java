import java.awt.*;

class Cell extends Rectangle{
    // fields
    int x;
    int y;
    static int size = 35;
    Rectangle r = new Rectangle();

    //constructors
    public Cell(int x, int y){
        r.setBounds(x, y, size, size);
        /*
        this.x = x;
        this.y = y;
        */
    }

    public int getCellX(){
        return x;
    }
    public int getCellY(){
        return y;
    }

    //methods
    void paint(Graphics g, Point mousePos){
        if(r.contains(mousePos.x, mousePos.y)){
            g.setColor(Color.BLUE);
        } 
        else {
            g.setColor(Color.GRAY);
        }
        g.fillRect((int)r.getX(),(int)r.getY(), size, size);
        g.setColor(Color.BLACK);
        g.drawRect((int)r.getX(),(int)r.getY(), size, size);
        /*
        if(contains(mousePos)){
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        //this is where it needs to inherit
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
        */
    }
    //rectangle makes this obsolete
    /*boolean contains(Point p){
        if (p != null){
            return (x < p.x && x+size > p.x && y < p.y && y+size > p.y);
        } else {
            return false;
        }
    }
    */
}