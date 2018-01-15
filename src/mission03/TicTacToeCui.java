package mission03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class TicTacToeCui {
    private Tool tool;

    private Map<String, Menu> mainMenu;

    private boolean exit;

    void init() {
        this.tool = new Tool(new Scanner(System.in));
        this.mainMenu = new TreeMap<>();

        initMenu();
    }

    void initMenu() {
        mainMenu.put("1", new Menu("1", "Local Mode") {
            @Override
            protected void onSelected() {
                new LocalGameMode(tool).start();
            }
        });

        mainMenu.put("2", new Menu("2", "Computer Mode") {
            @Override
            protected void onSelected() {
                new ComputerGameMode(tool).start();
            }
        });

        mainMenu.put("3", new Menu("3", "Remote Mode") {
            @Override
            protected void onSelected() {
                System.out.println(getText() + "는 아직 지원하지 않는 모드입니다.");
            }
        });

        mainMenu.put("3", new Menu("3", "Remote Mode") {
            @Override
            protected void onSelected() {
                System.out.println(getText() + "는 아직 지원하지 않는 모드입니다.");
            }
        });

        mainMenu.put("4", new Menu("4", "종료") {
            @Override
            protected void onSelected() {
                System.out.println("게임을 종료합니다.");
                exit();
            }
        });
    }

    void exit() {
        this.exit = true;
    }

    void start() {
        init();

        System.out.println("Tic-Tac-Toe");
        System.out.println("=======================");

        while(!exit) {
            String selectedMenu = printMainMenuAndSelect();

            select(selectedMenu);
        }
    }

    String printMainMenuAndSelect() {
        System.out.println("모드를 선택해 주세요.");
        mainMenu.forEach((key, menu) -> {
            System.out.println(key + ". " + menu.getText());
        });

        return tool.getScanner().nextLine();
    }

    void select(String selectedMenu) {
        if(mainMenu.containsKey(selectedMenu)) {
            Menu menu = mainMenu.get(selectedMenu);
            menu.select();
        } else {
            System.out.println("잘못된 메뉴 입력입니다. - " + selectedMenu);
        }
    }

    public static void main(String[] args) {
        new TicTacToeCui().start();
    }
}
