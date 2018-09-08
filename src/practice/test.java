package practice;

public class test {
	String title;
	int value;

	public test() {
		title += " World";
	}

	public test(int value) {
		this.value = value;
		title = "Hello";
		new test();
	}

	public static void main(String[] args) {
		test c = new test(5);
		System.out.println(c.title);
	}
}