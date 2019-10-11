import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.*;

public class Stage {
    Grid grid;
    ArrayList<Actor> actors;
    List<Cell> cellOverlay;
    List<MenuItem> menuOverlay;
    Optional<Actor> actorInAction;

    //new state objects
    State choosingActor = new ChoosingActor(this);
    State selectingNewLocation = new SelectingNewLocation(this);
    State stateCPUMoving = new CPUMoving(this);
    State selectingMenuItem = new SelectingMenuItem(this);
    State selectingTarget = new SelectingTarget(this);

    State state = choosingActor;
    //object for the display at the right of the screen
    Display display = new Display(this);
    
    //constructor
    public Stage(){
        grid = new Grid();
        actors = new ArrayList<Actor>();
        cellOverlay = new ArrayList<Cell>();
        menuOverlay = new ArrayList<MenuItem>();
        
    }

    //setters and getters for State objects
    public ArrayList<Actor> getActors(){
        return actors;
    }
    public Grid getGrid(){
        return grid;
    }
    public void setState(State state){
        this.state = state;
    }
    public State getChoosingActor(){
        return choosingActor;
    }
    public State getSelectingMenuItem(){
        return selectingMenuItem;
    }
    public State getSelectingNewLocation(){
        return selectingNewLocation;
    }
    public State getCPUMoving(){
        return stateCPUMoving;
    }
    public State getSelectingTarget(){
        return selectingTarget;
    }
    
    public void paint(Graphics g, Point mouseLoc){
        // If state is CPUMoving, this will move the CPU units.
        state.run();
        //paint the grid 
        grid.paint(g,mouseLoc);
        //paint the overlay
        grid.paintOverlay(g, cellOverlay, new Color(0f, 0f, 1f, 0.5f));
        //paint the actors
        for(Actor a: actors){
            a.paint(g);   
        }
        //code for the display on the right of the screen.
        display.paint(g, mouseLoc);
        // menu overlay (on top of everything else).
        for(MenuItem mi: menuOverlay){
            mi.paint(g);
        }
    }

    public List<Cell> getClearRadius(Cell from, int size, boolean considerCost){
        List<Cell> init = grid.getRadius(from, size, considerCost);
        for(Actor a: actors){
            init.remove(a.loc);
        }
        return init;
    }
    
    //BIG difference here
    public void mouseClicked(int x, int y){
        state.mouseClicked(x, y);
    }

    public Optional<Actor> actorAt(Cell c){
        for(Actor a: actors){
            if (a.loc == c){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}