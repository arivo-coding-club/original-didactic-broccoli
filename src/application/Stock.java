package application;

public class Stock{
	private static int beverageRemain1 = 10;
	private static int beverageRemain2 = 10;
	private static int beverageRemain3 = 10;
	private static int beverageRemain4 = 10;
	private static int beverageRemain5 = 10;
	private static int beverageRemain6 = 10;

	
	//??�������� �ڵ� -> ó�� �ʿ� 
	public static String stock1() { 
	
		if(beverageRemain1 == 0) 
			return "������";
		beverageRemain1 -= 1;
			int price = 2800;
			return price+"�� �����Ϸ�"; }
	

	public static String stock2() { 
		if(beverageRemain2 == 0)
			return "������";
		beverageRemain2 -= 1; 
			int price = 3000;
			return price+"�� �����Ϸ�"; }
		
	public static String stock3() { 
		if(beverageRemain3 == 0)
			return "������";
		beverageRemain3 -= 1; 
			int price = 3500;
			return price+"�� �����Ϸ�"; }
		
	public static String stock4() {
		if(beverageRemain4 == 0)
			return "������";
		beverageRemain4 -= 1; 
			int price = 2500;
			return price+"�� �����Ϸ�"; }
		
	public static String stock5() { 
		if(beverageRemain5 == 0)
			return "������";
		beverageRemain5 -= 1; 
			int price = 2800;
			return price+"�� �����Ϸ�"; }
		
	public static String stock6() {
		
		if(beverageRemain6 == 0)
			return "������";
		beverageRemain6 -= 1; 
			int price = 500;
			return price+"�� �����Ϸ�"; }
		

	public static String HowManyBeverageRemain() {
		return ("���ڿ�����: "+beverageRemain1+"��\n"
				+ "��Ʈ������: "+beverageRemain2+"��\n"
				+ "�ٴҶ�����: "+beverageRemain3+"��\n" 
				+ "������(H): "+beverageRemain4+"��\n"
				+ "������(I): "+beverageRemain5+"��\n"
				+ "����: "+beverageRemain6+"��");
	}

	
	//�ڡڡڡڡ�??�۵����� �ʴ� �޼ҵ�. ���� stock(i)�� �����ϰ� ǥ���ϱ� ���� �޼ҵ� �ۼ� �ʿ�
//	public static String HowMuchStock(int i){
//		int beverageRemain= Integer.parseInt("beverageRemain"+i);
//		if(beverageRemain==0)
//			return "������";
//		 beverageRemain -= 1;
//			return "500 �� �����Ϸ�";
//	}

	
}







