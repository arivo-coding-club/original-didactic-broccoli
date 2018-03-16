package mission03practice3.game;

public class ComVsComGameMode extends GameMode {
		    public ComVsComGameMode(Tool tool) {
		        super(tool);
		    }

		    @Override
		    protected Player getFirstPlayer() {
		    	return new ComputerPlayer();
		    }

		    @Override
		    protected Player getSecondPlayer() {
		        return new ComputerVsComputer();
		    }
		}
