package mission03.answer;

import java.util.*;

public class LearningCurrentTimeBirthday {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
			
		System.out.println("현재 시각 - ");
		
		System.out.println(new java.util.Date()); // 생략해도 현재 시간의 Date 객체를 만듬
		
		System.out.println("생일 - ");
		System.out.println(new java.util.Date(java.util.Date.UTC(92, 6, 4, 0, 0, 0)));
		
		
		//@SuppressWarnings("deprecation")
		long mybirthday = java.util.Date.UTC(92, 6, 4, 0, 0, 0);
		
		long millis = mybirthday;
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		long hours = minutes / 60;
		long days = hours / 24;
		long years = days / 365;
		
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + millis + " 밀리초 지남");
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + seconds + " 초 지남");
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + minutes + " 분 지남");
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + hours + " 시 지남");
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + days + " 일 지남");
		System.out.println(new java.util.Date(92, 6, 4) + "으로부터 " + years + " 년 지남");
		
		// 긋쟙! 금방 잘 해냈네요! :D
		// 
		// 그리고 참고로 자바에는 Deprecated 라는 게 있어요.
		// 위에 코드보면 java.util.Date(92, 6, 4) 에서 Date에 취소선이 그어진거 보이죠?
		// 이클립스에서 Deprecated된 코드를 자동으로 저렇게 표시해 주는데, 
		// Deprecated는 이번 버전이 되어서 삭제된 코드는 아니지만 쓰지 말라고 알려주는 역할을 해요
		// 역시 마찬가지로 java.util.Date.UTC 에서 UTC 역시 그렇구요.
		
		// UTC에 마우스를 올리고 기다리면 툴팁이 뜨는데 아래와 같이 나타날거예요
		/*
			@Deprecated
			Deprecated. As of JDK version 1.1, replaced by Calendar.set(year + 1900, month, date, hrs, min, sec) 
			or GregorianCalendar(year + 1900, month, date, hrs, min, sec), 
			using a UTC TimeZone, followed by Calendar.getTime().getTime().
		 */
	    // UTC에 주석으로 작성되어 있는 내용인데요.
		// UTC 대신에 java.util.Calendar 클래스의 set 메서드를 사용하거나,
		// GregorianCalendar를 사용하라는 안내예요.
		
		// 예시를 위해 Date를 쓰긴 했지만, 여러가지로 부족한 부분들이 있고, 잘못설계되어 있어서 Deprecated 되었어요.
		// Deprecated는 @Deprecated 라는 애너테이션을 태그해주면 자동으로 그렇게 처리되는데, 애너테이션(Annotation)은 다음에 알아볼게요 :)
	}
	
	/**
	 * 이 메서드는 다음 버전에서는 지원되지 않습니다. 유의해주세요.
	 */
	@Deprecated // 이 메서드를 deprecated 처리하기 위해 @Deprecated 애너테이션을 태그함
	public void dontUseThisMethod() {
		// 책 초반부에 나왔을 수도 있겠지만
		// 자바의 주석에는 지금 이 주석을 적고 있는 것과 같이 슬래시 두개 (//)
		// 또는 /* 주석 */ 
		// 또는 /** 주석 */ 이렇게 쓸 수 있는데, 세 번째의 형식을 javadoc 주석이라고 해요.
		// 이 메서드 이름에 마우스를 올려보면 javadoc 주석으로 작성한 '이 메서드는...' 이게 툴팁으로 보여질 거예요.
		// javadoc 은 java documentation 의 줄임말이고, 마우스를 올렸을 때 알 수 있다시피
		// 메서드나 클래스, 변수 등의 설명을 하는 역할을 해요.
	}

}

