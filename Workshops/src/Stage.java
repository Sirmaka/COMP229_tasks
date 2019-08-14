import java.awt.*;

public class Stage{
    //remember to paint
    Grid grid = new Grid();
    Lion lion = new Lion(10, 10);
    Rabbit rabbit = new Rabbit(45, 45);
    Puppy puppy = new Puppy(80, 80);

    void paint(Graphics g, Point mousePos){ 
        grid.paint(g, mousePos);
        lion.paint(g);
        rabbit.paint(g);
        puppy.paint(g);
    }
}

interface Actor{
    //specify paint method
    void paint(Graphics g);
}

class Animal implements Actor{
    Cell cell = new Cell(0, 0);
    String color = "";
    //constructors
    public Animal(){
        cell.setBounds(0, 0, 35, 35);
    }
    public Animal(int x, int y){
        cell.setBounds(x, y, 35, 35);
    }

    public void paint(Graphics g){ //implementing the interface
        g.setColor(Color.RED);
        
        if(color.equals("WHITE")){
            g.setColor(Color.WHITE);
        }
        if(color.equals("GREEN")){
            g.setColor(Color.GREEN);
        }
        g.fillRect((int)cell.getX(),(int)cell.getY(), 35, 35);
        g.setColor(Color.BLACK);
        g.drawRect((int)cell.getX(),(int)cell.getY(), 35, 35);
    }
}

class Lion extends Animal{
    Animal a = new Animal();
    public Lion(){
        color = "RED";
    }
    public Lion(int x, int y){
        cell.setBounds(x, y, 35, 35);
        color = "RED";
    }
}

class Rabbit extends Animal{
    Animal a = new Animal();
    public Rabbit(){
        super.color = "WHITE";
    }
    public Rabbit(int x, int y){
        cell.setBounds(x, y, 35, 35);
        super.color = "WHITE";
    }
}

class Puppy extends Animal{
    Animal a = new Animal();
    public Puppy(){
        super.color = "GREEN";
    }
    public Puppy(int x, int y){
        cell.setBounds(x, y, 35, 35);
        super.color = "GREEN";
    }
}