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
    State ChoosingActor;
    State SelectingNewLocation;
    State CPUMoving;
    State SelectingMenuItem;
    State SelectingTarget;

    State state = ChoosingActor;

    //enum State {ChoosingActor, SelectingNewLocation, CPUMoving, SelectingMenuItem, SelectingTarget}
    //State currentState = State.ChoosingActor;


    
    public Stage(){
        grid = new Grid();
        actors = new ArrayList<Actor>();
        cellOverlay = new ArrayList<Cell>();
        menuOverlay = new ArrayList<MenuItem>();
        ChoosingActor = new ChoosingActor(this);
        SelectingNewLocation = new SelectingNewLocation(this);
        CPUMoving = new CPUMoving(this);
        SelectingMenuItem = new SelectingMenuItem(this);
        SelectingTarget = new SelectingTarget(this);
    }

    public void paint(Graphics g, Point mouseLoc){

        // If state is CPUMoving, this will move the CPU units
        state.run();
        //not in a class (NIAC)
        grid.paint(g,mouseLoc);
        grid.paintOverlay(g, cellOverlay, new Color(0f, 0f, 1f, 0.5f));
        //NIAC
        for(Actor a: actors){
            a.paint(g);   
        }
        
        // state display. NIAC
        g.setColor(Color.DARK_GRAY);
        g.drawString(state.toString(),720,20); 

        // display cell. NIAC
        Optional<Cell> cap = grid.cellAtPoint(mouseLoc);
        if (cap.isPresent()){
            Cell capc = cap.get();
            g.setColor(Color.DARK_GRAY);
            g.drawString(String.valueOf(capc.col) + String.valueOf(capc.row), 720, 50);
            g.drawString(capc.description, 820, 50);
            g.drawString("movement cost", 720, 65);
            g.drawString(String.valueOf(capc.movementCost()), 820, 65);
        } 

        // agent display. NIAC
        int yloc = 138;
        for(int i = 0; i < actors.size(); i++){
            Actor a = actors.get(i);
            g.drawString(a.getClass().toString(),720, yloc + 70*i);
            g.drawString("location:", 730, yloc + 13 + 70 * i);
            g.drawString(Character.toString(a.loc.col) + Integer.toString(a.loc.row), 820, yloc + 13 + 70 * i);
            g.drawString("redness:", 730, yloc + 26 + 70*i);
            g.drawString(Float.toString(a.redness), 820, yloc + 26 + 70*i);
            g.drawString("strat:", 730, yloc + 39 + 70*i);
            g.drawString(a.strat.toString(), 820, yloc + 39 + 70*i);
        }

        // menu overlay (on top of everything else). NIAC
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

    public void mouseClicked(int x, int y){
        //state.mouseClicked(x, y);
        //temp solution for debugging purposes
        if(state.equals(ChoosingActor)){
                    //ArrayList<Actor> actors = stage.getActors();
            actorInAction = Optional.empty();
            for (Actor a : actors) {
                if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                    cellOverlay = grid.getRadius(a.loc, a.moves, true);
                    actorInAction = Optional.of(a);
                    setState(getSelectingNewLocation());
                }
        }
        //create the menu
        if(!stage.actorInAction.isPresent()){
            stage.setState(stage.SelectingMenuItem);
            stage.menuOverlay.add(new MenuItem("Oops", x, y, () -> stage.setState(stage.getChoosingActor())));
            stage.menuOverlay.add(new MenuItem("End Turn", x, y+MenuItem.height, () -> stage.setState(stage.getCPUMoving())));
            stage.menuOverlay.add(new MenuItem("End Game", x, y+MenuItem.height*2, () -> System.exit(0)));
        }
        }
        switch (state) {
            case ChoosingActor:
                actorInAction = Optional.empty();
                for (Actor a : actors) {
                    if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                        cellOverlay = grid.getRadius(a.loc, a.moves, true);
                        actorInAction = Optional.of(a);
                        currentState = State.SelectingNewLocation;
                    }
                }
                //create the menu
                if(!actorInAction.isPresent()){
                    currentState = State.SelectingMenuItem;
                    menuOverlay.add(new MenuItem("Oops", x, y, () -> currentState = State.ChoosingActor));
                    menuOverlay.add(new MenuItem("End Turn", x, y+MenuItem.height, () -> currentState = State.CPUMoving));
                    menuOverlay.add(new MenuItem("End Game", x, y+MenuItem.height*2, () -> System.exit(0)));
                }
                break;
            case SelectingNewLocation:
                Optional<Cell> clicked = Optional.empty();
                for (Cell c : cellOverlay) {
                    if (c.contains(x, y)) {
                        clicked = Optional.of(c);
                    }
                }
                if (clicked.isPresent() && actorInAction.isPresent()) {
                    cellOverlay = new ArrayList<Cell>();
                    actorInAction.get().setLocation(clicked.get());
                    actorInAction.get().turns--;
                    //firing menu
                    menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                        cellOverlay = grid.getRadius(actorInAction.get().loc, actorInAction.get().range, false);
                        cellOverlay.remove(actorInAction.get().loc);
                            currentState = State.SelectingTarget;
                    }));
                    currentState = State.SelectingMenuItem;
                } 
                break;
            case SelectingMenuItem:
                for(MenuItem mi : menuOverlay){
                    if (mi.contains(x,y)){
                        mi.action.run();
                        menuOverlay = new ArrayList<MenuItem>();
                    }
                }
                break;
            case SelectingTarget:
                for(Cell c: cellOverlay){
                    if (c.contains(x, y)){
                        Optional<Actor> oa = actorAt(c);
                        if (oa.isPresent()){
                            oa.get().makeRedder(0.1f);
                        }
                    }
                }
                cellOverlay = new ArrayList<Cell>();
                currentState = State.ChoosingActor;
                break;
            default:
                System.out.println(currentState);
                break;
        }
        */

    }

    public Optional<Actor> actorAt(Cell c){
        for(Actor a: actors){
            if (a.loc == c){
                return Optional.of(a);
            }
        }
        return Optional.empty();
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
        return ChoosingActor;
    }
    public State getSelectingMenuItem(){
        return SelectingMenuItem;
    }
    public State getSelectingNewLocation(){
        return SelectingNewLocation;
    }
    public State getCPUMoving(){
        return CPUMoving;
    }
    public State getSelectingTarget(){
        return SelectingTarget;
    }
    

    

}