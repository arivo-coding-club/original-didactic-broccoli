package iotHome;

public class IoTHome {

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
	
	public static void main(String[] args) {
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
		System.out.println(riceCooker.toString());
		riceCooker.turnOn();
		System.out.print(riceCooker.toString());
		riceCooker.turnUp();
		// 이 cook은 결과가 뜨지 않는 오류가 납니다..
		System.out.print(riceCooker.toString());
	}
}









