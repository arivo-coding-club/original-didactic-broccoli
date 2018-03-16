package mission03practice3.game;

import java.util.List;

import mission03practice3.model.Position;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public interface Player {
	String getName();
	String getSymbol();
	void waitReady();
	Position play(List<Position> emptyPositions);
}
