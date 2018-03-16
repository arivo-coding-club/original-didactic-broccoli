package mission03practice3.game;

public class NamedComputerPlayer extends ComputerPlayer {
	private String name;
	
	private String symbol;
	
	public NamedComputerPlayer(String name, String symbol) {
		super();
		
		this.name = name;
		this.symbol = symbol;
	}
	
	@Override
	//이부분 꼭 알아두기
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getSymbol() {
		return this.symbol;
	}
}
