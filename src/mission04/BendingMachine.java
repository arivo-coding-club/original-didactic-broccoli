package mission04;

import java.util.*;

public class BendingMachine {

	public static void main(String[] args) {
		System.out.println("<<음료 자판기>>");
		HashMap map = new HashMap();
		
		map.put("초코오레오", new Integer(2800));
		map.put("바닐라오레오", new Integer(2800));
		map.put("민트오레오", new Integer(3000));
		
		map.put("피치망고요거트", new Integer(2800));
		map.put("블루베리요거트", new Integer(2800));
		map.put("리얼피치망고", new Integer(3000));
		map.put("리얼블루베리", new Integer(3000));
		
		map.put("초코씨리얼", new Integer(2800));

		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			for(int i = 1; i < map.size()+1; i++) {
			Map.Entry e = (Map.Entry)it.next();
				System.out.println(i+"."+e.getKey()+"스무디 "+e.getValue()+"원");
			}
		}
		Scanner smoothieName = new Scanner(System.in);
		
		while(true) {
			System.out.println("----스무디 이름을 입력하세요----");
			String choosed = smoothieName.nextLine().trim();
			//int needMoney = (int) map.get(choosed);
			
			if(!map.containsKey(choosed)) {
				System.out.println("선택하신 스무디는 존재하지 않습니다. 다시 입력해주세요");
				continue;
			} else {
				System.out.println(choosed+"스무디를 선택했습니다");
				System.out.println(map.get(choosed)+"원 결제방법을 선택하세요");
				int needMoney = (int) map.get(choosed);
				
				System.out.println("1. 현금");
				System.out.println("2. 카드");
				
				Scanner payNumber = new Scanner(System.in);
				String pay = payNumber.nextLine().trim();
				
				if(pay.equals("1")) {
					System.out.println("현금을 투입하세요");
					
					Scanner inputMoney = new Scanner(System.in);
					int Money = Integer.parseInt(inputMoney.nextLine().trim());
					
					if(Money > needMoney) {
						int Minus = Money - needMoney;
						System.out.println("결제가 완료되었습니다. 거스름돈 "+Minus+"원을 가져가세요");
						break;
					} else if(Money == needMoney) {
						System.out.println("결제가 완료되었습니다.");
						break;
					} else {
						int More=needMoney-Money;
						System.out.println("현금이 부족합니다"+More+"원을 투입하세요");
						continue;
					}
	
				} else if(pay.equals("2")) {
					System.out.println("카드를 투입하세요");
					System.out.println("결제가 완료되었습니다");
					break;
				} else {
					System.out.println("선택하신 결제방법은 존재하지 않습니다. 다시 입력해주세요");
					continue;
				}		
			}
		} //while
	
		System.out.println("스무디를 받아가세요.");
	} //main
} //public class
