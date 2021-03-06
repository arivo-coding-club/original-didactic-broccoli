package mission03.game;

import java.util.List;
import java.util.Random;

import mission03.model.Position;

/**
 * Created by newt.on on 2018. 1. 12..
 */
public class ComputerPlayer implements Player {
    private Random random;

    public ComputerPlayer() {
    	//currentTimeMillis()이 무슨 뜻인가요?
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public String getSymbol() {
        return "C";
    }

    @Override
    public void waitReady() {
        System.out.println("컴퓨터 플레이어를 세팅하고 있습니다...");
        try {
        	//Thread.sleep(2000)이 무슨뜻인가요?
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
