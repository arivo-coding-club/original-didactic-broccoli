package application;

public class Stock{
	private static int beverageRemain1 = 10;
	private static int beverageRemain2 = 10;
	private static int beverageRemain3 = 10;
	private static int beverageRemain4 = 10;
	private static int beverageRemain5 = 10;
	private static int beverageRemain6 = 10;

	
	//??지저분한 코드 -> 처리 필요 
	public static String stock1() { 
	
		if(beverageRemain1 == 0) 
			return "재고부족";
		beverageRemain1 -= 1;
			int price = 2800;
			return price+"원 결제완료"; }
	

	public static String stock2() { 
		if(beverageRemain2 == 0)
			return "재고부족";
		beverageRemain2 -= 1; 
			int price = 3000;
			return price+"원 결제완료"; }
		
	public static String stock3() { 
		if(beverageRemain3 == 0)
			return "재고부족";
		beverageRemain3 -= 1; 
			int price = 3500;
			return price+"원 결제완료"; }
		
	public static String stock4() {
		if(beverageRemain4 == 0)
			return "재고부족";
		beverageRemain4 -= 1; 
			int price = 2500;
			return price+"원 결제완료"; }
		
	public static String stock5() { 
		if(beverageRemain5 == 0)
			return "재고부족";
		beverageRemain5 -= 1; 
			int price = 2800;
			return price+"원 결제완료"; }
		
	public static String stock6() {
		
		if(beverageRemain6 == 0)
			return "재고부족";
		beverageRemain6 -= 1; 
			int price = 500;
			return price+"원 결제완료"; }
		

	public static String HowManyBeverageRemain() {
		return ("초코오레오: "+beverageRemain1+"개\n"
				+ "민트오레오: "+beverageRemain2+"개\n"
				+ "바닐라프랖: "+beverageRemain3+"개\n" 
				+ "녹차라떼(H): "+beverageRemain4+"개\n"
				+ "녹차라떼(I): "+beverageRemain5+"개\n"
				+ "버블: "+beverageRemain6+"개");
	}

	
	//★★★★★??작동하지 않는 메소드. 위의 stock(i)를 간단하게 표현하기 위한 메소드 작성 필요
//	public static String HowMuchStock(int i){
//		int beverageRemain= Integer.parseInt("beverageRemain"+i);
//		if(beverageRemain==0)
//			return "재고부족";
//		 beverageRemain -= 1;
//			return "500 원 결제완료";
//	}

	
}







