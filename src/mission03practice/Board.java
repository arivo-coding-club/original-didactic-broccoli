package mission03practice;

import java.util.stream.IntStream;

/**
 * Make Board 3*3
 */

//

public class Board {
	public static final int BOARD_SIZE = 3;
	
	private int Piece [][] = new int [BOARD_SIZE][BOARD_SIZE];
	
	public static void main(String[] args){
		IntStream.range(0, 3).forEach(Board::printLine);
		
		for(int i = 0; i<BOARD_SIZE; i++) {
			System.out.print("| ");
			for(int j = 0; j<BOARD_SIZE -2; j++) {
				System.out.print(" |  | ");		
			}
			System.out.println(" |");
			System.out.println("----------");
		}
	}
	
	static void printLine(int i) {
		System.out.print("| ");
		IntStream.range(0, 3).forEach(Board::printColumn);
		System.out.println(" |");
		System.out.println("----------");
	}
	
	static void printColumn(int j) {
		System.out.print(" |  | ");
	}
}



