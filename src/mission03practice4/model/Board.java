package mission03practice4.model;

import java.util.Arrays;

public class Board {
	private static final int BOARD_SIZE = 3;
	
	private static char[][] grid;
	
	public Board() {
		this.grid = new char[BOARD_SIZE][BOARD_SIZE];
		
		for(int ROW = 0; ROW < grid.length; ROW++) {
			Arrays.fill(grid[ROW], 'A');
		}
	}
	
	public static void makeBoard() {
		for(int ROW = 0 ; ROW < grid.length; ROW++) {
			for(int COL = 0 ; COL < grid[0].length; COL++) {
				System.out.println("\t" + grid[ROW][COL]);
				if(COL == 0 || COL == 1)
				System.out.print("    |  ");
			} 
			if(ROW == 0 || ROW == 1) 
			System.out.print("\n-----------------\n");
		}
	}
	
	
	
	public static void main(String args[]) {
		makeBoard();
	}
}
