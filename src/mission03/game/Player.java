package mission03.game;

import java.util.List;

import mission03.model.Position;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public interface Player {
    String getName();
    String getSymbol();
    void waitReady();
    String getName2();
    String getSymbol2();
    void ComputerVsComputer();
    Position play(List<Position> emptyPositions);
}
