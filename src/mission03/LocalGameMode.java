package mission03;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public class LocalGameMode extends GameMode {
    public LocalGameMode(Tool tool) {
        super(tool);
    }

    @Override
    protected Player getFirstPlayer() {
        return getLocalPlayer("첫 번째");
    }

    @Override
    protected Player getSecondPlayer() {
        return getLocalPlayer("두 번째");
    }

    private Player getLocalPlayer(String ordinal) {
        System.out.print(ordinal + " 플레이어의 이름을 입력해 주세요: ");
        String name = getTool().getScanner().nextLine();
        System.out.print("심볼을 입력해 주세요: ");
        // FIXME ASCII만 받도록
        String symbol = getTool().getScanner().nextLine();
        return new LocalPlayer(getTool(), name, symbol);
    }
}
