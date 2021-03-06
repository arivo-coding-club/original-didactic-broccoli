package mission03practice3.model;

/**
 * Created by newt.on on 2018. 1. 11..
 */

public class Position {
	private static final String REGEX = " *\\d+ *, *\\d+ *";
	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//이부분이 왜 필요한지에 대한 궁금증
	public String toString() {
		return "Position{" +
				"x=" + x +
				", y=" + y +
				"}";
	}
	
	public static Position parse(String input) {
		if(!input.matches(REGEX)) {
			throw new IllegalArgumentException("잘못된 형식의 좌표입니다.");
		}
		
		String[] split = input.split(",");
		return new Position(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
	}
}
