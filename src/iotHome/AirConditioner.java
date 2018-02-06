package iotHome;

public class AirConditioner extends Boiler {
	private boolean on;
	
	//풍량
	private int volumn = 5;
	private int temperature = 20;
	
	private static final int MIN_VOLUMN = 0;
	private static final int MAX_VOLUMN = 10;
	
	private static final int MIN_TEMPERATURE = 20;
	private static final int MAX_TEMPERATURE = 45;
	
	public void turnOn() {
		on = !on;
	}
	
	//AirVolumn
	public void VolumnUp() {
		if(volumn == MAX_VOLUMN) {
			volumn = MAX_VOLUMN ;
		} else {
			++volumn;
		}
	}
	
	public void VolumnDown() {
		if(volumn == MIN_VOLUMN) {
			volumn = MIN_VOLUMN;
		} else {
			--volumn;
		}
	}
	
	//Min과 MAX값만 바꾼채 상속하는 방법?
	//클래스로 MIN, MAX 메소드 만들어서 상속하니 return을 못 받아오고 끝남...
	@Override
	public void turnUp() {
		if(temperature == MAX_TEMPERATURE) {
			temperature = MAX_TEMPERATURE ;
		} else {
			++temperature;
		}
	}
	
	@Override
	public void turnDown() {
		if(temperature == MIN_TEMPERATURE) {
			temperature = MIN_TEMPERATURE;
		} else {
			--temperature;
		}
	}
	
	@Override
	public String toString() {
		if(on) {
			return "Current Temperature:" + temperature + ", Current Volumn:" + volumn;
		} else {
			return "Current Status : Off";
		}
	}
}
