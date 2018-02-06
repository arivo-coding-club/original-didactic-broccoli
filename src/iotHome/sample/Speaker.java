package iotHome.sample;

public class Speaker extends MinMaxControl {
	public static final int SPEAKER_MAX_VOLUME = 100;
	
	public Speaker() {
		super(10);
	}

	@Override
	int getMin() {
		// 그냥 이렇게 숫자를 반환해도 되고,
		return 0;
	}

	@Override
	int getMax() {
		// 상수로 만든 숫자를 반환해도 돼요
		return SPEAKER_MAX_VOLUME;
	}

}
