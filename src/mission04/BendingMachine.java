package mission04;

import java.util.*;

public class BendingMachine extends Casher{
	int inputtedMoney = 0;
	
	public static void main(String[] args) throws Exception {
		BendingMachine bendingMachine = new BendingMachine();
		bendingMachine.start();
	}
	
	public void start() {
		//start가 실행되면 음료의 메뉴와 가격을 보여줍니다
		System.out.println(Beverage.show());

		while(true) {			
			System.out.println("===금액을 투입하세요===(숫자로만 입력)");
			
			//금액을 입력받습니다
			inputtedMoney = getInput();
			
			
			//만약, 7을 입력할 경우 거스름돈을 반환하고 프로그램을 종료합니다
			if(isExitCommand(inputtedMoney)) {
				System.out.println(remainedMoney+"원을 반환합니다. 안녕히 가십시오");
				break;
			} 
			
			//투입한 금액을 표시하고, 추후에 추가 투입 금액이 있을 경우 추가합니다
			System.out.println(inputtedMoney+"원을 투입했습니다");
			addMoney(inputtedMoney);
			howMuchRemain();
			
			//투입한 금액이 음료를 선택하기 위한 최소값(2800)보다 적은지 판단합니다
			if(isTooLess(remainedMoney)) {
				System.out.println("음료를 선택하기 위해서는 최소 2800원이 필요합니다.");
				continue;
			}
			
			//이제 음료를 선택할 수 있습니다. 
			Select.selection();	
			
			//금액이 남아있는 경우 계속해서 음료를 고를 수 있습니다
			while(!(7==remainedMoney)) {
				Select.selection();
			}
			
        } // while	
	} //start
		 
	private boolean isExitCommand(int inputtedMoney) {
		return (7 == inputtedMoney);
	}
	
	private boolean isTooLess(int remainedMoney) {
		return remainedMoney < 2800;
	}

	
	//사용자의 입력값을 받아 inputtedMoney로 설정합니다
	@SuppressWarnings("resource")
	public int getInput() {
		Scanner inputMoney = new Scanner(System.in);
		int inputtedMoney = Integer.parseInt(inputMoney.nextLine().trim());
		return inputtedMoney;
	}

	public static void howMuchRemain() {
		System.out.println("현재 잔액은 "+remainMoney()+"원입니다"); 
	}
} //class


