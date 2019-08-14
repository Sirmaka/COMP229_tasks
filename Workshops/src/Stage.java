import java.awt.*;

public class Stage{
    //remember to paint
    Grid grid = new Grid();
    Lion lion = new Lion(10, 10);
    Rabbit rabbit = new Rabbit(45, 45);
    Puppy puppy = new Puppy(80, 80);

    void paint(Graphics g, Point mousePos){ 
        grid.paint(g, mousePos);
        //lion.paint(g);
       // stage.lion.paint(g);
    }
}

interface Actor{
    //specify paint method
    void paint(Graphics g);
}
//each subclass must define paint method
class Lion implements Actor{
    Cell cell = new Cell(0, 0);
    
    //constructor
    public Lion(int x, int y){
        cell.setBounds(x, y, 35, 35);
    }

    public void paint(Graphics g){ //implementing the interface
        g.setColor(Color.RED);
        g.fillRect((int)cell.getX(),(int)cell.getY(), 35, 35);
        g.setColor(Color.BLACK);
        g.drawRect((int)cell.getX(),(int)cell.getY(), 35, 35);
    }
}

class Rabbit implements Actor{
    Cell cell = new Cell(0, 0);
    

    public Rabbit(int x, int y){
        cell.setBounds(x, y, 35, 35);
    }

    public void paint(Graphics g){ //implementing the interface
        g.setColor(Color.WHITE);
        g.fillRect((int)cell.getX(),(int)cell.getY(), 35, 35);
        g.setColor(Color.BLACK);
        g.drawRect((int)cell.getX(),(int)cell.getY(), 35, 35);
    }
}

class Puppy implements Actor{
    Cell cell = new Cell(0, 0);
    

    public Puppy(int x, int y){
        cell.setBounds(x, y, 35, 35);
    }

    public void paint(Graphics g){ //implementing the interface
        g.setColor(Color.GREEN);
        g.fillRect((int)cell.getX(),(int)cell.getY(), 35, 35);
        g.setColor(Color.BLACK);
        g.drawRect((int)cell.getX(),(int)cell.getY(), 35, 35);
    }
}