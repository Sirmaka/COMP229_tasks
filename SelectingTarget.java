import java.util.*;
class SelectingTarget implements State{
    Stage stage;

    public SelectingTarget(Stage stage){
        this.stage = stage;
    }

    public void mouseClicked(int x, int y){
        for(Cell c: stage.cellOverlay){
            if (c.contains(x, y)){
                Optional<Actor> oa = stage.actorAt(c);
                if (oa.isPresent()){
                    oa.get().makeRedder(0.1f);
                }
            }
        }
        stage.cellOverlay = new ArrayList<Cell>();
        stage.setState(stage.getChoosingActor());
    }

    public void run(){

    }

    public String toString(){
        return "SelectingTarget";
    }
}