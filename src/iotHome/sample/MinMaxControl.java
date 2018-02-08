package iotHome.sample;

public abstract class MinMaxControl {
	private int value;
	
	//초기값을 받아서 value에 담아줌
	public MinMaxControl(int initialValue) {
		this.value = initialValue;
	}
	
	//setter
	public void setValue(int value) {
		this.value = value;
	}
	
	//getter
	public int getValue() {
		return value;
	}
	
	public void up() {
		if(getMax() > value) {
			value++;
			System.out.println("value가 1 증가되었습니다. 현재값: " + value);
		} else {
			System.out.println("MAX에 도달했습니다.");
		}
	}
	
	public void down() {
		if(getMin() < value) {
			System.out.println("value가 1 감소되었습니다. 현재값: " + value);
			value--;
		} else {
			System.out.println("MIN에 도달했습니다.");
		}
	}
	
	abstract int getMin();
	
	abstract int getMax();
}
