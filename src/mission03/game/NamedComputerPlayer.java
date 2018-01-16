package mission03.game;

public class NamedComputerPlayer extends ComputerPlayer {
	private String name;
	
	private String symbol;
	
	public NamedComputerPlayer(String name, String symbol) {
		super();
		
		this.name = name;
		this.symbol = symbol;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getSymbol() {
		return this.symbol;
	}
}
