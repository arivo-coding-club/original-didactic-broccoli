package mission03.answer;

public class LearningStaticAndPrivate {
	public static void main(String[] args) {
		StaticTest t1 = new StaticTest();
		t1.static name = "T1";
		t1.dynamicName = "T1";
		StaticTest t2 = new StaticTest();
		t2.static name = "T2";
		t2.dynamicName = "T2";
		StaticTest t3 = new StaticTest();
		t3.static name = "T3";
		t3.dynamicName = "T3";
		System.out.println(t1.static name);
		System.out.println(t1.dynamicName);
		System.out.println(t2.static name);
		System.out.println(t2.dynamicName);
		System.out.println(t3.static name);
		System.out.println(t3.dynamicName);
	}
}

class PrivateTest {
	
}

class StaticTest {
	public static String static name = "Hello";
	public String dynamicName = "";
}
