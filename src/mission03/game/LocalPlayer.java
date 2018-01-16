package mission03.game;

import java.util.List;
import java.util.Random;

import mission03.model.Position;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class LocalPlayer implements Player {
    private Tool tool;

    private String name;

    private String symbol;

	private String name2;

	private String symbol2;


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

	@Override
	public void ComputerVsComputer() {
	}

	@Override
	public String getName2() {
		return this.name2;
	}

	@Override
	public String getSymbol2() {
		// TODO Auto-generated method stub
		return this.symbol2;
	}
}
