package application.model;

/**
 * 음료 모델 클래스
 *
 */
public class Beverage extends Item {
	// 음료 타입 - 별로 의미는 없지만 모델링 연습삼아서
	private BeverageType beverageType;

	public Beverage(String name, String item, String price, BeverageType beverageType) {
		super(name, item, price);
		this.beverageType = beverageType;
	}

	public BeverageType getBeverageType() {
		return beverageType;
	}

	public void setBeverageType(BeverageType beverageType) {
		this.beverageType = beverageType;
	}
}
