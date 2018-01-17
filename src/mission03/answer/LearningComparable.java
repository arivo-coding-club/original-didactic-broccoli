package mission03.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mission03.game.LocalPlayer;
import mission03.game.Player;
import mission03.model.Menu;

public class LearningComparable {
	public static void main(String[] args) {
		// java.lang.Comparable은 이름 그대로 직역하면 '비교할수 있는' 이 되고, 
		// 여기서 비교한다는 건 순서를 의미해요. 내가 우선이냐, 나랑 비교하는 다른 객체가 우선이냐.
		
		// Comparable 인터페이스의 소스코드를 살펴보면 int compareTo(T other) 이 메서드 하나만 있어요
		/*
		   public interface Comprable<T> {
		     int compareTo(T other);
		   }
		 */
		
		// 아직 제네릭(Generic)을 배우지 않았지만, 간단하게 설명하면 클래스나 인터페이스의 이름에
		// <T>와 같이 써주고, 그 클래스를 쓸 떄는 Comparable<String> 이런 식으로 실제 타입을 넣어주게 돼요.
		// 그럼 T 로 되어있던 게 String으로 대체되는 역할을 해요
		// 즉 int compareTo(T other) -> int compareTo(String other); 이렇게 돼요
		
		// 그럼 이 Comparable은 순서를 비교해주는 메서드를 가지고 있고,
		// 순서를 비교하는 걸 어디에 쓸 수 있냐면, 배열이나, 리스트 등을 정렬할 때 써요.
		// 정렬을 우리가 직접 구현해도 되지만, 자바에서 정렬을 해주는 기능을 제공하기 때문에 
		// 우리는 정렬의 순서만 자바에게 알려주면 자바가 그 순서대로 정렬을 해줄 수 있어요.
		// 그 정렬의 순서를 Comparable 인터페이스를 구현해서 자바에게 알려줄 수 있어요.
		
		// 자바에 있는 기본 타입들은 기본적으로 Comparable을 구현하고 있어요
		// byte, char, short, int, long, double, float, String 등
		// 그래서 그냥 자바에게 정렬을 해줘! 이미 순서를 알고 있기 때문에 정렬을 해줘요.
		String[] languages = {"한글", "영어", "일본어", "독일어", "중국어", "태국어"};
		// 위와 같이 정렬되지 않은 배열을 만들고.
		
		// 자바에게 정렬을 해달라고 부탁합니다.
		Arrays.sort(languages);
		
		System.out.println("자바에 있는 배열 정렬 메서드 호출 결과");
		for(String language: languages) {
			System.out.println(language);
		}
		
		// 배열과 달리 크기가 늘어나는 리스트를 만들었어요.
		List<Integer> numbers = new ArrayList<>();
		// 숫자 몇 개를 넣어줍니다. 리스트는 넣어준 순서대로 보관을 하고 있어요.
		numbers.add(9182);
		numbers.add(1023);
		numbers.add(59);
		numbers.add(9123);
		numbers.add(204);
		
		System.out.println("정렬을 하기 전 -");
		for(Integer number: numbers) {
			System.out.println(number);
		}
		
		// 배열은 Arrays 클래스에 있는 sort 메서드를 사용했지만
		// 리스트는 Collections 클래스에 있는 sort 메서드를 사용해요.
		Collections.sort(numbers);
		System.out.println("정렬을 한 후 -");
		for(Integer number: numbers) {
			System.out.println(number);
		}
		
		
		// 위의 String 배열과, Integer 리스트를 정렬할 수 있는 이유는 저 타입들이 
		// 정렬의 순서를 알려주는 Comparable 인터페이스를 구현하기 때문인데요, 
		// 그럼 Comparable 인터페이스를 구현하지 않은 객체를 정렬하려고 하면 어떻게 될까요?
		// 우리가 만든 클래스 중에 Player 라는 클래스를 정렬해보도록 할게요.
		List<Player> players = new ArrayList<>();
		players.add(new LocalPlayer(null, "빌게이츠", "O"));
		players.add(new LocalPlayer(null, "스티브 잡스", "X"));
		players.add(new LocalPlayer(null, "마틴 파울러", "X"));
		players.add(new LocalPlayer(null, "켄트 백", "X"));
		
		// 리스트를 사용했으니 Collections
		// Collections.sort(players);
		// 위 코드는 컴파일에 실패해요.
		// sort 메서드는 Comparable을 구현한 객체를 담고있는 리스트만 정렬을 할 수 있도록 되어 있어요.
		// 어쩌면 당연할 수도 있어요.
		// sort 메서드 입장에서는 LocalPlayer 객체를 '뭘 기준'으로 정렬하라고? 하는 의문을 가질테니까요
		
		// TicTacToeCui에서 메뉴를 담고 있는 mainMenu는 Map 이라 List와는 조금 다르지만,
		// 메뉴를 출력할 때 순서대로 보여주기 위해서 Menu 클래스에서 Comparable을 구현했어요.
		// 명시적으로 정렬을 한 부분은 없지만 어쨌든 메뉴를 순서대로 출력하기 위해서라고 이해해주세요~!
		// 차차 설명드릴게요 :)
		
		// 그렇다면! Comparable을 구현하지 않는 LocalPlayer와 달리 Menu는 이미 Comparable을 구현하도록 되어 있으니
		// 아래와 같이 정렬할 수 있겠죠?
		// Menu 클래스의 compareTo 메서드는 메뉴의 키(key, 사용자가 메뉴를 고를 때 입력하는 값)를 기준으로 정렬하도록 되어 있어요
		// key가 String 타입이기 때문에 String이 가지고 있는 compareTo를 그대로 사용하도록 했어요.
		// 그럼 문자열의 정렬 순서인 가나다순으로 정렬이 돼요. (정확하게는 문자의 값 크기 순서)
		List<Menu> menus = new ArrayList<>();
		menus.add(new Menu("I", "아이스 아메리카노") {
			protected void onSelected() { }
		});
		menus.add(new Menu("L", "카페라떼") {
			protected void onSelected() { }
		});
		menus.add(new Menu("D", "더치커피") {
			protected void onSelected() { }
		});
		menus.add(new Menu("G", "녹차") {
			protected void onSelected() { }
		});
		
		System.out.println("\n메뉴 정렬 전");
		for(Menu menu: menus) {
			System.out.println(menu.toString());
		}
		
		Collections.sort(menus);
		System.out.println("메뉴 정렬 후");
		for(Menu menu: menus) {
			System.out.println(menu.toString());
		}
	}
}
