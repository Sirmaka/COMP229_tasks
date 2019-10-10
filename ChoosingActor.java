import java.util.*;

class ChoosingActor implements State{
    Stage stage;

    public ChoosingActor(Stage stage){
        this.stage= stage;
    }
    public void mouseClicked(int x, int y){
        //ArrayList<Actor> actors = stage.getActors();
        stage.actorInAction = Optional.empty();
            for (Actor a : stage.actors) {
                if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                    stage.cellOverlay = stage.grid.getRadius(a.loc, a.moves, true);
                    stage.actorInAction = Optional.of(a);
                    stage.setState(stage.getSelectingNewLocation());
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
    
    public void run(){
        
    }

    public String toString(){
        return "ChoosingActor";
    }

}