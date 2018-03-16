package mission03practice3.game;

import java.util.List;
import java.util.Random;

import mission03practice3.model.Position;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public class ComputerVsComputer implements Player {
	private Random random;
	
	ComputerVsComputer(){
		random = new Random(System.currentTimeMillis());
	}
	
	@Override
	public String getName() {
		return "SecondComputer";
	}
	
	@Override
	public String getSymbol() {
		return "T";
	}
	
	public void ComputerVsComputer2() {
		random = new Random(System.currentTimeMillis());
	}
	
	@Override
	public void waitReady() {
		System.out.println("컴퓨터 플레이어를 세팅하고 있습니다...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Position play(List<Position> emptyPositions) {
		return emptyPositions.get(random.nextInt(emptyPositions.size()));
	}
}
	
	
	
	
