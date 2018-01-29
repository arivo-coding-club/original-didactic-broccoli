package mission04;

import java.util.*;

public class Select extends Beverage{
	String BeveragePlease = null;
	int beveragePrice = 0;
	
	public static void selection() {
	System.out.println("===음료를 선택하세요===('스무디'는 빼고 입력)");
	
	//선택한 음료를 thisBeveragePlease로 설정합니다
	String thisBeveragePlease = getInput();

	while(true) {
		//만약 7을 입력받으면 거스름돈을 반환합니다 *여기서 BendingMachine과 달리 완전히 종료되지 않고 다시 ===음료를 선택하세요===창이 떠서 강제종료 시켰습니다ㅠㅠ*
		if(thisBeveragePlease.equals("7")) {
			System.out.println(Casher.remainedMoney+"원을 반환합니다. 안녕히 가십시오");
			System.exit(0);
			
		//선택한 스무디가 존재하지 않으면 이를 알리고 다시 스무디를 선택하게 합니다
		} else if(!generate().containsKey(thisBeveragePlease)) {
			System.out.println("선택하신 스무디는 존재하지 않습니다");
			show();
			selection();
			break;
		
		} else {
			//선택한 스무디가 존재할 경우 BendingMachine으로 가서 스무디 가격을 차감하는 yesWehaveSmoothies 메소드를 실행합니다
			System.out.println(thisBeveragePlease+"스무디를 선택했습니다");
			yesWehaveSmoothie(thisBeveragePlease);
			break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	private static String getInput() {
		Scanner selectBeverage = new Scanner(System.in);
		String selectedBeverage = selectBeverage.nextLine().trim();
		return selectedBeverage;
	}
	
	//사용자가 고른 스무디의 이름이 올바른 경우, HashMap에서 스무디의 이름과 맵핑된 가격을 가져옵니다
	//이후 Casher클래스의 차감메소드를 통해 투입된 금액에서 가격이 차감됩니다
	private static void yesWehaveSmoothie(String thisBeveragePlease){
		System.out.println(set.get(thisBeveragePlease)+"원이 차감됩니다");
		Integer beveragePrice = set.get(thisBeveragePlease);
		Casher.minusMoney(beveragePrice);
		BendingMachine.howMuchRemain();
		System.out.println("거스름돈을 원할경우 '7'을 입력하세요");	
	}
}