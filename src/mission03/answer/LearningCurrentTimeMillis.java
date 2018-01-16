package mission03.answer;

import java.util.Random;

public class LearningCurrentTimeMillis {
	public static void main(String[] args) {
		// 틱택토에서 컴퓨터 플레이어가 랜덤으로 플레이하도록 하기 위해
		// java.util.Random 클래스를 사용했는데, 거기에 System.currentTimeMillis() 메서드를 썼죠.
		
		// 우선 Random 클래스는 이름에서 강력하게 느껴지듯이 랜덤으로 뭔가를 뱉어주는(?) 클래스예요.
		// 사실 자바의 Random 클래스는 완전한 의미의 랜덤은 아니고 랜덤처럼 보이는 결과를 반환해요.
		// 랜덤 클래스에는 시드(seed)라는 인자를 넘겨줄 수 있는데, 
		// 랜덤이라고는 하지만 수학적으로 계산되는 값이라서 계산값을 시드를 통해서 계산해요.
		// 대략적으로는 이렇고, 어쨌든 랜덤은 그렇다 정도로만 알고 넘어가고,
		
		// 현대 컴퓨터에서 쓰는 시간 표현은 1970년 1월 1일 0시 0분 0초부터 세기 시작했어요.
		// UTC 표준시 기준이고, 한국시는 +9시간이니까 9시로 출력될 거예요.
		System.out.println(new java.util.Date(0)); // 또 Date라는 새로운게 나왔죠..
		// Date는 자바에서 날짜표현을 위한 클래스예요.
		
		// 위에 넘어간 0이라는 값은 밀리세컨드 단위의 시간이고,
		// 1970. 1. 1. 0시 0분 0초로부터 얼마나 밀리세컨드 단위로 지났는지 전달할 수 있어요.
		// 스레드 글에도 설명이 있지만 밀리세컨드는 1000분의 1초, 1초는 1000 밀리세컨드예요.
		// 그럼 1분은 1000(밀리세컨드) * 60(초) 가 되겠죠?
		// 1시간은? 1분 * 60이니까 1000 * 60 * 60
		// 하루는 위에 * 24.
		
		System.out.println(new java.util.Date(1000 * 60)); // 기준시로부터 1분이 지난 시각
		System.out.println(new java.util.Date(1000 * 60 * 60)); // 기준시로부터 60분이 지난 시각
		System.out.println(new java.util.Date(1000 * 60 * 60 * 24)); // 기준시로부터 하루가 지난 시각
		
		// 자 그렇다면, 이쯤되면 감이 왔겠지만
		// System.currentTimeMillis()는 어떤 의미일까요?
		// 바로 저 기준시로부터 얼마만큼의 밀리세컨드가 지났나를 알 수 있어요.
		// 특정 시간의 기준시로부터의 밀리세컨드를 타임스탬프(timestamp)나 unix timestamp 라고 해요.
		// 즉 currentTimeMillis()는 현재(current) 시각의(time) 밀리세컨드(millis)이고
		// 달리하면 현재 시간의 타임스탬프예요. 참고로 타입은 long
		System.out.println("현재 시각 - ");
		System.out.println(new java.util.Date(System.currentTimeMillis()));
		System.out.println(new java.util.Date()); // 생략해도 현재 시간의 Date 객체를 만듬
		
		long millis = System.currentTimeMillis();
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		long hours = minutes / 60;
		long days = hours / 24;
		long years = days / 365;
		
		System.out.println(new java.util.Date(0) + "으로부터 " + millis + " 밀리초 지남");
		System.out.println(new java.util.Date(0) + "으로부터 " + seconds + " 초 지남");
		System.out.println(new java.util.Date(0) + "으로부터 " + minutes + " 분 지남");
		System.out.println(new java.util.Date(0) + "으로부터 " + hours + " 시 지남");
		System.out.println(new java.util.Date(0) + "으로부터 " + days + " 일 지남");
		System.out.println(new java.util.Date(0) + "으로부터 " + years + " 년 지남");
		
		// 막간 퀴즈
		// 내 생일 구해보기
		long myBirthday = 0L; // 0 대신 내 생일의 millisecond 값으로 넣기
		
		// 내 생일로부터 몇 초 / 몇 분 / 몇 시간 / 며칠 / 몇 년 지났나? 출력하기
	}
}
