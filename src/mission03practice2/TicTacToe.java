package mission03practice2;

public class TicTacToe {

	public static void main(String[] args) {
		GameBoard myGame = new GameBoard();
		myGame.displayBoard();
		int counter = 1;
		
		while(myGame.gameActive() && counter <10) {
			if(counter % 2 == 0) 
				myGame.askPlayer('O');
			else
				myGame.askPlayer('X');
			counter++;
			
			System.out.println("\n");
			myGame.displayBoard();
			myGame.checkForWinner();
		}
		
		if(counter == 10)
			System.out.println("Stale mate!\n");
	}
}
