import java.util.*;
class SelectingMenuItem implements State{
    Stage stage;

    public SelectingMenuItem(Stage stage){
        this.stage = stage;
    }

    public void mouseClicked(int x, int y){
        for(MenuItem mi : stage.menuOverlay){
            if (mi.contains(x,y)){
                mi.action.run();
                stage.menuOverlay = new ArrayList<MenuItem>();
            }
        }
    }

    public int run(){
        return 0;
    }

    public String toString(){
        return "SelectingMenuItem";
    }
}