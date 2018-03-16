package mission03practice3.game;

/**
 * Created by newt.on on 2018. 1. 15..
 */
public class ComputerGameMode extends GameMode{
	public ComputerGameMode(Tool tool) {
		super(tool);
	}
	
	@Override
	protected Player getFirstPlayer() {
		System.out.println("플레이어의 이름을 입력해 주세요: ");
		String name = getTool().getScanner().nextLine();
		System.out.println("심볼을 입력해 주세요: ");
		String symbol = getTool().getScanner().nextLine();
		return new LocalPlayer(getTool(), name, symbol);
	}
	
	@Override
	protected Player getSecondPlayer() {
		return new ComputerPlayer();
	}
}
