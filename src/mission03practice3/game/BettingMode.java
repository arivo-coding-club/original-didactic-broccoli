package mission03practice3.game;

import java.util.*;

import mission03practice3.model.Menu;

/**
 * Created by newt.on on 2018. 1. 11..
 */
public class BettingMode extends GameMode{
	
	public BettingMode(Tool tool) {
		super(tool);
	}
	
	private Tool tool;
	
	private Map<String, Menu> mainMenu;
	
	private boolean exit;
	
	void init() {
		this.tool = new Tool(new Scanner(System.in));
		this.mainMenu = new TreeMap<>();
		
		initMenu();
	}
	
	void initMenu() {
		mainMenu.put("1", new Menu("1", "Computer") {
			@Override
			protected void onSelected() {
				new ComVsComGameMode(tool).start();
			}
		});
		
		mainMenu.put("2", new Menu("2", "SecondComputer") {
			@Override
			protected void onSelected() {
				new ComVsComGameMode(tool).start();
			}
		});
		
	}
	
	void exit() {
		this.exit = true;
	}
	
	public void start() {
		init();
		
		String selectedMenu = printMainMenuAndSelect();
		
		select(selectedMenu);
	}
	
	String printMainMenuAndSelect() {
		System.out.println("컴퓨터를 선택하세요.");
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
	
	@Override
	protected Player getFirstPlayer() {
		return null;
	}
	
	@Override
	protected Player getSecondPlayer() {
		return null;
	}
}






