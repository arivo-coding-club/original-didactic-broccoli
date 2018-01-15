package mission03;

import java.util.List;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class LocalPlayer implements Player {
    private Tool tool;

    private String name;

    private String symbol;

    public LocalPlayer(Tool tool, String name, String symbol) {
        this.tool = tool;
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public Position play(List<Position> emptyPositions) {
        System.out.println("좌표를 입력해 주세요.");
        String input = tool.getScanner().nextLine();

        return Position.parse(input);
    }

    @Override
    public void waitReady() {

    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
