package mission03;

import java.util.*;

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
                    emptyPositions.add(new Position(i, j));
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
        for(int x = 0 ; x < grid.length ; x++) {
            System.out.print("| ");
            StringJoiner joiner = new StringJoiner(" | ");
            for(int y = 0 ; y < grid[x].length ; y++) {
                joiner.add(getSymbol(x, y));
            }
            System.out.println(joiner.toString() + " |");
        }
    }

    public boolean isTicTacToe() {
        // 열방향
        if(isRowTicTacToe()) return true;

        // 행방향
        if(isColTicTacToe()) return true;

        // 대각선
        return isTicTacToe(0, 1, 0, 1) || isTicTacToe(BOARD_SIZE - 1, -1, 0, 1);
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
        for(int i = 0 ; i < BOARD_SIZE ; i++) {
            if(isTicTacToe(0, 1, i, 0)) {
                return true;
            }
        }

        return false;
    }

    private boolean isTicTacToe(int row, int rowDirection, int col, int colDirection) {
        Piece p1 = grid[row][col];
        Piece p2 = grid[row + rowDirection][col + colDirection];
        Piece p3 = grid[row + rowDirection * 2][col + colDirection * 2];

        if(Objects.isNull(p1) || Objects.isNull(p2) || Objects.isNull(p3)) return false;

        return p1.equalPlayer(p2) && p2.equalPlayer(p3);
    }

    private String getSymbol(int x, int y) {
        return Optional.ofNullable(grid[x][y])
                .map(Piece::getPlayer)
                .map(Player::getSymbol)
                .orElse(" ");
    }
}
