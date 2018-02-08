package practice;

public class KoreanCharacterResolver {
	static char[] 받침 = {
		' ', 'ㄱ','ㄲ',
		'ㄳ','ㄴ','ㄵ',
		'ㄶ','ㄷ','ㄹ',
		'ㄺ','ㄻ','ㄼ',
		'ㄽ','ㄾ','ㄿ',
		'ㅀ','ㅁ','ㅂ',
		'ㅄ','ㅅ','ㅆ',
		'ㅇ','ㅈ','ㅊ',
		'ㅋ','ㅌ','ㅍ',
		'ㅎ',
	};
	
	static char[] 모음 = {
			'ㅏ','ㅐ','ㅑ','ㅒ','ㅓ','ㅔ','ㅕ','ㅖ','ㅗ','ㅘ','ㅙ','ㅚ','ㅛ','ㅜ','ㅝ','ㅞ','ㅟ','ㅠ','ㅡ','ㅢ','ㅣ'
	};
	
	static char[] 초성 = {
'ㄱ','ㄲ','ㄴ',
'ㄷ','ㄸ','ㄹ',
'ㅁ','ㅂ','ㅃ',
'ㅅ','ㅆ','ㅇ',
'ㅈ','ㅉ','ㅊ',
'ㅋ','ㅌ','ㅍ',
'ㅎ'
	};
 
	public static void main(String[] args) {

		// First, check parameter. - is Korean Character?
        // We use first parameter. args[0].
        String input = args[0];
        input = "ㄱㄴㄷ가나다";
        for(int i = 0 ; i < input.length(); i++) {
        	// we can retrieve each character.
        	System.out.println(input.charAt(i));
        	
        	// and check each character
        	char c = input.charAt(i);
        	if(('가' <= c && '힣' >= c) || ('ㄱ' <= c && c <= 'ㅎ')) {
        		// ok!
        	} else {
        		System.out.println("파라미터가 한글이 아닙니다.");
        		System.exit(0);;
        	}
        }
        
        // resolve a character~!
    	char c = '김';
    	
    	int i = c;
    	System.out.println(c);
    	System.out.println(i);
    	
    	System.out.println((char)44608);
    	System.out.println((int)'ㄱ');
    	
    	for(char ch= 'ㄱ'; ch <= 'ㅎ'; ch++ ) {
    		System.out.print(ch);
    	}
    	
    	//다음에 영어로 입력했을 때 한글로 자동변환하는 것 만들어보기
    	// dlrkddms -> 이강은 
    	// ㅇㅣㄱㅏㅇㅇㅡㄴ
    	// 이강
    	// 익ㅏㅇ
    	
    	System.out.println('김'-'가');
    	
    	//28은 받침의 개수. 한글자에서 항상 맨 첫번째 완성형 글자인 '가'를 뺀후 사잇값을 받아와 계산함
    	//%를 모듈러라고 함
    	char Last =  받침[('김'-'가')% 28];
    	
    	System.out.println(('김'-'가')%28);
    	System.out.println(Last);
    	
    	//28은 모음의 개수
    	char middle =  모음[(('김'-'가') / 28) % 21];
    	
    	System.out.println((('김'-'가')/28));
    	System.out.println((('김'-'가')/28)%21);
    	System.out.println(middle);
    	
    	//19는 초성의 개수
    	char first =  초성[((('김'-'가') / 28) / 21) % 19];
    	
    	System.out.println(((('김'-'가')/28)/21));
    	System.out.println(((('김'-'가')/28)/21)%19);
    	System.out.println(first);
   //        
//        for(int i = 0; i < 21; i++) {
//        	System.out.println("\'" + (char)('가' +i*28*21
//        			)+ "\',");
//        }

//		for(int i = 0; i < args.length; i++) {
//			String text = Arrays.toString(args); 
//			for(char ch : text.toCharArray() )
//				if(i%3==0) {
//					char initial = ch;
//					//if(initial.contains(Hangul)) {
//						System.out.println("초성 :"+initial);
//				} else if(i%3==1) {
//					System.out.println("medial ="+args[i]);
//				} else {
//					System.out.println("final ="+args[i]);
//				}
//			//} else {
//				//System.out.println("파라미터가 한글이아닙니다");
//			}
	}
}
		
//		
//		for(int i=0; i< args.length; i++) {
//			String initial = "";
//			String medial = "";
//			String finall = "";
//			
//			if(i%3==0) {
//				initial = args[i];
//				if(initial.contains(Hangul)) {
//					System.out.println("초성 :"+initial);
//			} else if(i%3==1) {
//				System.out.println("medial ="+args[i]);
//			} else {
//				System.out.println("final ="+args[i]);
//			}
//			//} else {
//				//System.out.println("파라미터가 한글이아닙니다");
//			}
//		
//		
//		}
//	}
//}
