package mission03;

import java.util.List;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public interface Player {
    String getName();
    String getSymbol();
    void waitReady();
    Position play(List<Position> emptyPositions);
}
