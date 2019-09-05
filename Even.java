import java.util.Random;

public class Even implements CPUStrategy {
    public int strategy(int possibleLocs){
        //produce a random number based on possibleLocs.size
        int a = new Random().nextInt(possibleLocs);
        return a;
    }
}