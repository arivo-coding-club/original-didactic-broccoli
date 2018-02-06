package iotHome.sample;

public class HeatingPad extends MinMaxControl {
	public static final int MAX_TEMPERATURE = 60;
	
	public static final int MIN_TEMPERATURE = 15;
	
	public HeatingPad() {
		// 최소값을 초기값으로 설정함
		super(MIN_TEMPERATURE);
	}

	@Override
	int getMin() {
		return MIN_TEMPERATURE;
	}

	@Override
	int getMax() {
		return MAX_TEMPERATURE;
	}

}
