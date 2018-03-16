package mission03practice3.game;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public class ComputerVsComputerGameMode extends GameMode {
	public ComputerVsComputerGameMode(Tool tool) {
		super(tool);
	}
	
	@Override
	protected Player getFirstPlayer() {
		return new NamedComputerPlayer("First", "F");
	}
	
	@Override
	protected Player getSecondPlayer() {
		return new NamedComputerPlayer("Second", "S");
	}
}
