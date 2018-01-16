package mission03.game;

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
