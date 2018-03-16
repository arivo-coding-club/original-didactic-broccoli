package mission03practice3.game;
/**
 * Created by newt.on on 2018. 1. 12..
 */
public class LocalGameMode extends GameMode {
	public LocalGameMode(Tool tool) {
		super(tool);
	}
	
	@Override
	protected Player getFirstPlayer() {
		return getLocalPlayer("첫 번쨰");
	}
	
	@Override
	protected Player getSecondPlayer() {
		return getLocalPlayer("두 번째");
	}
	
	private Player getLocalPlayer(String ordinal) {
		System.out.println(ordinal + "플레이어의 이름을 입력해 주세요: ");
		String name = getTool().getScanner().nextLine();
		System.out.println("심볼을 입력해 주세요: ");
		String symbol = getTool().getScanner().nextLine();
		return new LocalPlayer(getTool(), name, symbol);
	}
}
