package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HowToSystemOutToFile {
	static final int INFO = 1;
	static final int ERROR = 2;
	
	static int logLevel = INFO;
	public static void main(String[] args) throws IOException {
		String dir = "C:\\Users\\gramgram\\Downloads\\apache-tomcat-9.0.5\\apache-tomcat-9.0.5\\logs";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		ArrayList<String> list = null;
		String[] array = {};
		list.toArray(array);
		LocalDate today = LocalDate.now();
		String fileName =dir + "\\stdout-" + formatter.format(today) + ".log";
		// => ...\logs\stdout-20180330.log
		
		// 위에서 만든 파일이름으로 파일 객체 생성
		File file = new File(fileName);
		
		// 파일에 출력하기 위한 아웃풋 스트림 생성
		FileOutputStream fos = new FileOutputStream(file);
		
		// 시스템.아웃을 대체하기 위하여 같은 타입인 프린트스트림 타입으로 감싸기
		PrintStream ps = new PrintStream(fos);
		// 기존의 아웃을 변경 = System.out <- This!
		System.setOut(ps);
		
		logLevel = ERROR;
		info("Hello %s", "Leegang");
		error("Hello(ERROR Level) %s", "Leegang");
		fos.close();
	}
	
	public static void info(String message, Object... args) {
		if(logLevel <= INFO) {
			System.out.printf("[INFO] " + message + "\n", args);
		}
	}
	
	public static void error(String message, Object... args) {
		if(logLevel <= ERROR) {
			System.out.printf("[ERROR] " + message + "\n", args);
		}
	}
}
