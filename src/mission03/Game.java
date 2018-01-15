package mission03;

import java.util.List;
import java.util.Scanner;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class Game {
    private Player[] players = new Player[2];

    private Tool tool;

    private Board board;

    private int turn;

    public Game(Tool tool, Player first, Player second) {
        this.tool = tool;
        this.players[0] = first;
        this.players[1] = second;

        this.board = new Board();
        this.turn = 0;
    }

    public Scanner getScanner() {
        return tool.getScanner();
    }

    public void start() {
        System.out.println("게임을 시작합니다.\n");

        while(true) {
            Player currentPlayer = players[turn];

            List<Position> emptyPositions = board.getEmptyPositions();
            System.out.println(currentPlayer.getName() + "님 차례입니다.");
            Position position = currentPlayer.play(emptyPositions);
            board.make(currentPlayer, position);
            board.print();
            System.out.println();

            // TODO TicTacToe 체크
            if(board.isTicTacToe()) {
                win();
                break;
            }

            if(emptyPositions.isEmpty()) {
                draw();
                break;
            }

            toggleTurn();
        }
    }

    private void win() {
        System.out.println(players[turn].getName() + "이/가 승리하였습니다!");
    }

    private void draw() {
        System.out.println("비겼습니다 게임을 종료합니다.");
    }

    private void toggleTurn() {
        this.turn = (turn + 1) % 2;
    }
}
