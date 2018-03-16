package mission03practice3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import mission03practice3.game.Player;

/**
 * Created by newt.on on 2018. 1. 12..
 */

public class Board {
	private static final int BOARD_SIZE = 3;
	
	private Piece[][] grid;
	
	public Board() {
		this.grid = new Piece[BOARD_SIZE][BOARD_SIZE];
	}
	
	public List<Position> getEmptyPositions() {
		List<Position> emptyPositions = new ArrayList<>();
		
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[i].length ; j++) {
				if(Objects.isNull(grid[i][j])) {
					emptyPositions.add(new Position(i,j));
				}
			}
		}
		
		return emptyPositions;
 	}
	
	public void make(Player player, Position position) {
		Piece piece = new Piece(player, position);
		grid[position.getX()][position.getY()] = piece;
	}
	
	public void print() {
		for(int x = 0 ;  x < grid.length ;  x++) {
			System.out.println("| ");
			StringJoiner joiner = new StringJoiner(" | ");
			
			//이게 뭔지 아직도 모르겠다..
			//joiner = new Stringjoiner("-")
			//joiner.add("1")
			//add 2, 3하면
			//joiner.toString() = 1-2-3 이렇게 됨
			for(int y = 0 ; y < grid[x].length ; y++) {
				joiner.add(getSymbol(x, y));
			}
			System.out.println(joiner.toString() + " |");
		}
	}
	
	public boolean isTicTacToe() {
		//열방향
		if(isRowTicTacToe()) return true;
		
		//행방향
		if(isColTicTacToe()) return true;
		
		//대각선
		return isTicTacToe(0, 1, 0, 1) || isTicTacToe(BOARD_SIZE -1, -1, 0, 1);
	}
	
	private boolean isRowTicTacToe() {
		for(int i = 0 ; i < BOARD_SIZE ; i++) {
			if(isTicTacToe(i, 0, 0, 1)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isColTicTacToe() {
		for(int i = 0; i < BOARD_SIZE ; i++) {
			if(isTicTacToe(0, 1, i, 0)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isTicTacToe(int row, int rowDirection,int col, int colDirection) {
		Piece p1 = grid[row][col];
		Piece p2 = grid[row + rowDirection][col + colDirection];
		Piece p3 = grid[row + rowDirection * 2][col + colDirection * 2];
		
		if(Objects.isNull(p1) || Objects.isNull(p2) || Objects.isNull(p3)) return false;
		
		return p1.equalPlayer(p2) && p2.equalPlayer(p3);
	}
	
	//null체크를 좀더 객체지향적으로 표현하기 위해서 Optional사용
	//ofNullable은 staticFactoryMethod임
	//옵셔널에는 isPresent메서드가 있는데 ofNullable로 만들어진 Optional객체에담긴게
	//null인지 아닌지 알 수 있음
	// ::은 메서드 레퍼런스
	//optional의 map메서드는 타입을 바꾸는 역할을 하고
	//piece::getPlayer은 piece가 들어가면 player가 나오는 동작이 됨
	private String getSymbol(int x, int y) {
		return Optional.ofNullable(grid[x][y])
				.map(Piece::getPlayer)
				.map(Player::getSymbol)
				.orElse(" ");
	}
}








