package iotHome.sample;

public class SizeControl {
	// 크기값 
	private int size;
	
	// 최소값
	private final int min;
	
	// 최대값
	private final int max;
	
	public SizeControl(int size, int min, int max) {
		this.size = size;
		this.min = min;
		this.max = max;
	}
	
	public int getSize() {
		return size;
	}
	
	// 업 시키면서 1 증가된 값을 반환 +1, getter와 같은 역할
	public int up() {
		if(size < max) {
			size++;
			System.out.println("size를 1증가 합니다. 현재값: " + size);
		} else {
			System.out.println("최대 값입니다.");
		}
		
		return size;
	}
	
	public int down() {
		if(size > min) {
			size--;
			System.out.println("size를 1감소 합니다. 현재값: " + size);
		} else {
			System.out.println("최소 값입니다.");
		}
		
		return size;
	}
}
