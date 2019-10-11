import java.util.*;
class CPUMoving implements State{
    Stage stage;

    public CPUMoving(Stage stage){
        this.stage = stage;
    }

    public void mouseClicked(int x, int y){

    }

    public int run(){
        for(Actor a: stage.actors){
            if (!a.isTeamRed()){
                List<Cell> possibleLocs = stage.getClearRadius(a.loc, a.moves, true);
                Cell nextLoc = a.strat.chooseNextLoc(possibleLocs);
                a.setLocation(nextLoc);
            }
        }
        //refresh all actor turns
        for(Actor a: stage.actors){
            a.turns = 1;
        }
        stage.setState(stage.getChoosingActor());
        
        return 1;
    }

    public String toString(){
        return "CPUMoving";
    }
}