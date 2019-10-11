import java.util.*;
class SelectingNewLocation implements State{
    Stage stage;

    public SelectingNewLocation(Stage stage){
        this.stage = stage;
    }

    public void mouseClicked(int x, int y){
        Optional<Cell> clicked = Optional.empty();
        for (Cell c : stage.cellOverlay) {
            if (c.contains(x, y)) {
                clicked = Optional.of(c);
            }
        }
        if (clicked.isPresent() && stage.actorInAction.isPresent()) {
            stage.cellOverlay = new ArrayList<Cell>();
            stage.actorInAction.get().setLocation(clicked.get());
            stage.actorInAction.get().turns--;
            //firing menu
            stage.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                stage.cellOverlay = stage.grid.getRadius(stage.actorInAction.get().loc, stage.actorInAction.get().range, false);
                stage.cellOverlay.remove(stage.actorInAction.get().loc);
                    stage.setState(stage.getSelectingTarget());
            }));
            stage.setState(stage.getSelectingMenuItem());
        } 
    }

    public int run(){
        return 0;
    }

    public String toString(){
        return "SelectingNewLocation";
    }
}