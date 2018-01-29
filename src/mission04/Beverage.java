package mission04;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Beverage{
	
	//음료를 담을 HashMap을 선언합니다
	private static HashMap<String, Integer> beverage = new HashMap();
	//generate메소드를 이용하여 음료와 가격을 HashMap 타입의 beverage에 담아줍니다
	static HashMap<String, Integer> set = generate();
	
	public static HashMap<String, Integer> generate() {	
		
		beverage.put("초코오레오", 2800);
		beverage.put("바닐라오레오", 2800);
		beverage.put("민트오레오", 3000);
		beverage.put("피치망고요거트", 2800);
		beverage.put("블루베리요거트", 2800);
		beverage.put("리얼피치망고", 3000);
		beverage.put("리얼블루베리", 3000);
		beverage.put("초코씨리얼", 2800);
		
		return beverage;
	}

	public static String show() {
		
		//HashMap을 set으로 만듭니다
		//hashMapToSet메소드를 통해 hasMap을 set에 담고 iterator로 읽어오기 위한 준비를 마칩니다
		Iterator it = hashMapToSet();
		
		//읽어올때는 스무디 이름과 가격(원)을 표시합니다
		while(it.hasNext()) {
			for(int i = 1; i < generate().size()+1; i++) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(i+"."+e.getKey()+"스무디 "+":"+e.getValue()+"원");
			}
		}	
		return "";
	}
	
	private static Iterator hashMapToSet() {
		Set set = generate().entrySet();
		return set.iterator();
	}
}
