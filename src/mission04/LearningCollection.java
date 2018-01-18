package mission04;

public class LearningCollection {
	/*
	 * 자바의 정석 11 장에서는 Collection(컬렉션) 에 대해서 다루고 있어요.
	 * Collection은 이름에서 뜻하는 것과 같이 무엇인가의 모음이예요. 1개가 아니라 여러 개를 효율적으로 다루기 위해서 써요.
	 * 
	 * 초반에 배우는 배열도 컬렉션과 유사하게 여러 개의 데이터를 모아서 한 번에 다룰 수 있어요.
	 * 컬렉션과 배열의 차이라면 배열은 단순하게 락커룸처럼 정해진 칸이 있고, 그 칸에 데이터를 넣거나, 탐색할 수 있어요.
	 * 배열 객체는 락커룸의 갯수를 더 늘릴 수 없는 구조로 되어 있어요.
	 * 
	 * 컬렉션은 뒤에서 자세하게 설명하겠지만 List, Set, Map, Queue 등으로 배열과 같이 데이터(객체)를 모아서 관리하는데,
	 * 배열보다는 조금 더 다양한 방법으로 다룰 수 있고, 조금 더 복잡하게 다뤄요. 그리고 크기도 자동적으로 늘어날 수 있게 해 뒀구요.
	 * 
	 * 컬렉션을 배우는데 어렵게 느껴지거나 걸림돌이 될 수 있는 건 제네릭(책에서는 지네릭이라고 되어있는데, 보통은 제네릭이라고 써요.) 이나
	 * List를 배우는데 ArrayList는 뭐고 LinkedList는 또 뭔가 하는 걸거예요.
	 * Map 역시 그냥 Map이 아니고 왜 HashMap이고 TreeMap이야 하는 거구요.
	 * 
	 * 그걸 하나씩 깨면서 공부해볼게요.
	 */
	
	// 먼저 제네릭 - 간단 버전
	// 물건(객체)를 담을 수 있는 Box 클래스를 만들어서 예를 들어볼게요.
	// 
	// 먼저 String을 담을 수 있도록 하는 String 박스예요.
	class StringBox {
		String contents;
	}
	void usingStringBox() {
		// 그냥 평범하게 이렇게 쓰겠죠?
		StringBox stringBox = new StringBox();
		stringBox.contents = "스트링 박스에 담긴 문자열";
	}
	
	// 다음은 Int를 담을 수 있는 Integer 박스를 만들어볼게요
	class IntBox {
		int contents;
	}
	void usingIntBox() {
		// 얘도 그냥 이렇게 쓰겠죠
		IntBox intBox = new IntBox();
		intBox.contents = 1992;
	}
	
	// 근데 만들다보니 Double 박스도 필요하고 String[] 박스도 필요하고
	// Player 박스도 필요해졌어요.
	// 생각해보니 굳이 타입별로 박스를 만들지 않고 모든 타입을 담을 수 있는 ObjectBox를 만들면 되겠다고 생각하고
	// 이렇게 만듭니다.
	class ObjectBox {
		Object contents;
	}
	void usingObjectBox() {
		ObjectBox objectBox = new ObjectBox();

		// 오! 역시 Object가 최상위 클래스니까 잘 담아지네요.
		objectBox.contents = "오브젝트 박스에 문자열 담기";
		// 조금 귀찮긴 하지만 꺼내는 것도 잘 꺼내져요.
		String str = (String) objectBox.contents;
		
		// int 타입도 무리없이 잘 담아집니다.
		objectBox.contents = 1992;
		int year = (int) objectBox.contents;
		// 뭐 역시 (int)로 타입캐스팅하긴 조금 귀찮지만 하나의 박스 클래스로 모든 타입을 담을 수 있게 되었어요.
		
		String message = (String) objectBox.contents;
		// 어쩌다보니 실수로 담겨 있던 게 int 였는데 String으로 타입캐스팅을 해버렸어요.
		// 근데 컴파일 오류가 안나니까 실수인지 이 때는 몰랐는데, 나중에 실행해보니 ClassCastException 예외가 발생하네요!
		// ClassCastException은 타입 캐스팅을 잘못했을 때 발생하는 예외예요.
		
		// 지금은 바로 다음 줄에 있어서 알아채기 쉽지만,
		// 코드의 양이 많아지고, 복잡해지고, 오타가 있을 수도 있고, 사람이라 헷갈릴 수도 있는지라
		// 알아차리기 힘든 시점에 실수를 하게 돼요.
		
		// 이런 실수를 최소화 해서 런타임(실행했을 때) 알아 차리는게 아니라, 컴파일 타임에 알아차릴 수 있도록 도와줘요.
		// 물론 StringBox, IntBox 와 같이 하나하나 만들 필요 없이 유연하게 타입을 바꿔 쓸 수 있구요.
		// 그걸 위해 나온 게 Generic이예요.
	}
	
	// T라는 임의의 타입을 선언하고, 이 T는 나중에 String이나 Integer와 같은 타입으로 바꿔치기 될 거예요.
	class PerfectBox<T> {
		T contents;
	}
	// T 부분을 제너릭 타입 파라미터라고 해요,꼭 T일 필요는 없고 어떤 글자이든 상관이 없어요.
	class OtherBox<ABCDEFGHIJKLMN, KKKK> {
		ABCDEFGHIJKLMN contents1;
		KKKK contents2;
	}
	// 위와 같이 타입 파라미터는 어떤 이름이든 상관이 없어요. 타입이름을 담는 하나의 변수(파라미터)라고 생각하면 돼요.
	// 그리고 저렇게 콤마(,)로 여러개의 제너릭 타입을 선언할 수 있어요.
	// 몇 개까지 되는지 확인은 못해봤지만.. 적어도 필요한 만큼 추가할 수 있어요.
	
	// 자 그럼..!
	void usingPerfectBox() {
		// String을 담기 위해 
		PerfectBox<String> stringBox = new PerfectBox<String>();
		stringBox.contents = "Hello!";
		// stringBox.contents = 1992; // 컴파일 오류가 나요. 제너릭 타입이었던 T가 String으로 고정이 되었으므로
		// int(Integer)는 담을 수 없어요.
		
		// 역시 마찬가지로
		PerfectBox<Integer> integerBox = new PerfectBox<Integer>();
		integerBox.contents = 1992;
		// integerBox.contents = "IntegerBox에 문자열은 들어갈 수 없음."; // 역시 여기도 컴파일 오류가 나요.
		
		// 이렇게 제너릭을 이용하면 
		// StringBox, IntegerBox를 따로 만들지 않아도 해당 타입을 담을 수 있는 박스를 만들 수 있어요.
		// 더군다나 매번 (String)stringBox.contents; 이렇게 (String)으로 타입 캐스팅을 해줄 필요도 없고.
		// String이 아닌 객체가 들어갈 수도 없어서 안전한 타입이라고 해요
		// 타입 세이프티 하다. 라고 보통 표현을 해요. 왠만해서는 ClassCastException이 발생할 일이 없어요
		
		// 그치만 저 PerfectBox를 ObjectBox 처럼 String도 담고, Integer도 담고 싶을 땐 어떻게 해야할까요?
		// 그럴 떄는 Object를 써주면 되겠죠?
		PerfectBox<Object> giveMeAnyType = new PerfectBox<Object>();
		
		// 이건 조금 줄여서 아래와 같이 쓸 수 있어요.
		PerfectBox<Object> giveItToMe = new PerfectBox<>();
		// 뒤에 객체를 생성하는 부분에서 써주는 타입을 생략할 수도 있어요.
		// 자바가 앞의 변수에 있는 제너릭 타입을 보고 자동으로 유추할 수 있기 때문이예요.
		
		// 조금더 고급지게 제너릭을 쓰려면 PerfectBox<?> 처럼 물음표 기호 (wild card 타입이라고 해요.)를 쓸 수도 있고
		// 모든 타입을 다 쓸 수 있는 T가 아니라, 제한적으로 타입을 사용하게 할 수도 있어요.
		// 예를 들면 우리가 만들었던 Player의 하위 클래스들만 받을 수 있도록 한다던가 하는 식으로요.
		// 이건 조금 더 나중에 다루기로 해요 :>
	}
	
	// 다음 리스트.
	public void learningList() {
		// 리스트는 배열과 가장 비슷한 형태예요.
		// 배열로 할 수 있는 건 모양은 조금 다르지만 리스트로 대부분 할 수 있어요.
		
		// 객체 만들기
		// array: String[] array = new String[10];
		// list: List<String> list = new ArrayList<>(); // 배열처럼 크기를 입력하진 않음
		
		// 0 번째에 있는 요소(element) 
		// array[0] -> list.get(0);
		
		// 크기
		// array.length -> list.size()
		
		// 반복문 1
		// for(int i=0; i < array.length ; i++) {
		//   array[i] ...
		// }
		// 
		// for(int i=0; i < list.size() ; i++) {
		//    list.get(i); ...
		// }
		
		// 반복문 1 (foreach 구문)
		// for(String element: array) { ... }
		// 
		// for(String element: list) { ... } // 똑같이 생김!
		

		// 리스트만 할 수 있는 것
		// 추가.
		// list.add("item");
		// 물론 배열도 array[i++] = "item" 을 할 수 있지만
		// 배열의 크기를 벗어나면 ArrayIndexOutOfBoundException이 발생
		// list는 계속해서 add를 호출하면 계속해서 추가가 됨(할당할 수 있는 메모리의 한계까지)
		
		// 삭제
		// list.remove(3); // 인덱스 3에 있는 항목을 삭제
		// 리스트에 0, 1, 2, 3, 4 이렇게 담겨 있었다면
		// 3을 삭제하면
		// 0, 1, 2, 4가 되고 size()는 5에서 4가 됨.
		// 배열은 length 크기를 변경할 수 없고,
		// 인덱스 3에 있는 것을 지우면 빈자리가 됨
		// array[3] = null;
		// 0, 1, 2, null, 4
	}
}
