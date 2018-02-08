package iotHome;

public class IoTHome {
//인터페이스는 메서드의 모양만 넣을수 있는 클래스(인터페이스 : 수식어로 짓기. turunable이 되는 TV. 이름첫문자는 대문자로! 클래스처럼)
//추상 클래스는 추상메서드를 가질 수 있는 메서드
	interface turnable{
		void turnOn();
	}
	
	interface volumnSwitchable{
		void volumnUp();
		
		void volumnDown();
	}
	
	interface channelSwitchable{
		void channelUp();
		
		void channelDown();
	}
	
	interface temperatureTurnable{
		void turnUp();
		
		void turnDown();
	}
	
	interface timeLimitable{
		void autoTurnOff();
	}
	
	interface mutable{
		void mute();
	}
	
	interface pause {
	}	
	
	interface cookable {
		void cook();
	}
	
	public static void main(String[] args) throws Exception {
		AirCleaner aircleaner = new AirCleaner();
		AirConditioner airConditioner = new AirConditioner();
		Boiler boiler = new Boiler();
		Computer computer = new Computer();
		DishWasher dishWasher = new DishWasher();
		FrontDoor frontdoor = new FrontDoor();
		Humidifier humidifier = new Humidifier();
		
		Radio radio = new Radio();
		Refrigerator refrigerator = new Refrigerator();
		RiceCooker riceCooker = new RiceCooker();
		Television television = new Television();
		WashingMachine washingMachine = new WashingMachine();
		
		//전등
		KitchenLight kitchenLight = new KitchenLight();
		LivingRoomLight livingRoomLight = new LivingRoomLight();
		Room1Light room1Light = new Room1Light();
		Room2Light room2Light = new Room2Light();
	
		
		//테스트
//		System.out.println(riceCooker.printMessage());
//		System.out.println();
//		riceCooker.turnOn();
//		System.out.println(riceCooker.printStatus());
//		System.out.println();
//		riceCooker.turnUp();
//		// 이 cook은 결과가 뜨지 않는 오류가 납니다..
//		System.out.println(riceCooker.printStatus()); //
//
//		
		riceCooker.turnOn();
		riceCooker.printStatus();
		
		riceCooker.turnUp();
		riceCooker.printStatus();
		
		riceCooker.turnUp();
		riceCooker.printStatus();
		
		riceCooker.turnUp();
		riceCooker.printStatus();
		
		riceCooker.turnUp();
		riceCooker.printStatus();
	}
}









