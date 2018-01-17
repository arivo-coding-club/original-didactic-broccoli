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
		
	}

}

