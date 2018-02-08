package iotHome.sample;

public class SizeControl {
	// 크기값 
	private int size;
	
	// 최소값
	private final int min;
	
	// 최대값
	private final int max;
	
	//immutable은 값이 바뀌지 않는 클래스를 말함
	//이건 muttable
	
	//String은 immutable임. 불변 클래스
	String str = "hello";
	String str2 = str.replace("h", "H");
	
	//mutable은 멀티쓰레드에서 문제가 많이 발생
	//immutable을 적용해서 해결할 수 있음
	
	//생성자가 이렇게 중요함
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
