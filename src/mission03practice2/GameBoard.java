package mission03practice2;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	private char[][] gameBoard;
	private boolean gameOnGoing = true;

	public GameBoard() {
		gameBoard = new char[3][3];

		for (int row = 0; row < gameBoard.length; row++) {
			// 왜 이게 칸대로 맞춰질까?
			// fill하면 한줄만채워지는거아님?
			Arrays.fill(gameBoard[row], ' ');
		} 
	} // end of constructor

	public void displayBoard() {
		for (int row = 0; row < gameBoard.length; row++) {
			for (int col = 0; col < gameBoard[0].length; col++) {
				System.out.print("\t" + gameBoard[row][col]);
				if (col == 0 || col == 1)
					System.out.print("|");
			}
			if (row == 0 || row == 1)
				System.out.print("\n----------------------------\n");
		}
		System.out.println();
	}

	public boolean makeMove(char player, int row, int col) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			if (gameBoard[row][col] != ' ') {
				return false;
			} else {
				gameBoard[row][col] = player;
				return true;
			}
		} else {
			return false;
		}
	} // end of make move

	public boolean gameActive() {
		return gameOnGoing;
	}	

	public boolean notValid(int row, int col) {
		if(row >3 || row < 1 || col >3 || col < 1 || !isEmpty(row, col))
			return true;
		else
			return false;
	}

	public void askPlayer(char player) {
		Scanner keyboard = new Scanner(System.in);
		int row, col;
		
		do {
			System.out.printf("Player %s please enter a row (1-3)", player);
			row = keyboard.nextInt();
			
			System.out.printf("Player %s please enter a col (1-3)", player);
			col = keyboard.nextInt();
			
		} while(notValid(row,col));
		
		makeMove(player,row-1,col-1);
	} //end of askPlayer method
	
	public boolean isEmpty(int row, int col) {
		if(gameBoard[row-1][col-1]==' ') {
			return true;
		}
		else {
			System.out.println("That position is taken.\n");
			return false;
		}
	}

	public boolean checkForWinner() {
		for(int row=0; row<gameBoard.length; row++) {
			if(gameBoard[row][0]==gameBoard[row][1] && gameBoard[row][1]==gameBoard[row][2]
					&& gameBoard[row][0]!=' ') {
				System.out.println("The winner is " + gameBoard[row][0]);
				gameOnGoing=false;
			}
		}
		
		for(int col=0; col<gameBoard[0].length; col++) {
			if(gameBoard[0][col]==gameBoard[1][col] && gameBoard[1][col]==gameBoard[2][col]
					&& gameBoard[0][col]!=' ') {
			System.out.println("The winner is " + gameBoard[0][col]);
			gameOnGoing=false;
			}
		}
		
		if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2]
				&& gameBoard[0][0] != ' ') {
			System.out.println("The winner is " + gameBoard[0][0]);
			gameOnGoing=false;
		}
		
		if(gameBoard[0][2]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][0]
				&& gameBoard[0][2] != ' ') {
			System.out.println("The winner is " + gameBoard[0][2]);
			gameOnGoing=false;
		}
		return false;
	}
}

