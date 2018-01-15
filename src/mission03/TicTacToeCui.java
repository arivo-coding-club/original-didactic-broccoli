package mission03;

import java.util.Scanner;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class TicTacToeCui {
    private Tool tool;

    void init() {
        this.tool = new Tool(new Scanner(System.in));
    }

    void start() {
        init();
        System.out.println("Tic-Tac-Toe");
        System.out.println("=======================");
        int mode = printModeAndSelect();

        System.out.println("선택한 모드는 " + mode); // FIXME mode도 모델링

        new LocalGameMode(tool).start();
    }

    int printModeAndSelect() {
        System.out.println("모드를 선택해 주세요");
        System.out.println("1. Local Mode");
        System.out.println("2. Computer Mode");
        System.out.println("3. Remote Mode");

        return Integer.parseInt(tool.getScanner().nextLine());
    }

    public static void main(String[] args) {
        new TicTacToeCui().start();
    }
}
