package mission03;

import java.util.List;
import java.util.Random;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public class ComputerPlayer implements Player {
    private Random random;

    public ComputerPlayer() {
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public String getSymbol() {
        return "C";
    }

    @Override
    public void waitReady() {

    }

    @Override
    public Position play(List<Position> emptyPositions) {
        return emptyPositions.get(random.nextInt(emptyPositions.size()));
    }
}
