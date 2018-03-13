//package mission03practice;
//
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//public class SelectPosition {
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//        String coordinate = "";
//
//        while(true) {
//            System.out.print("좌표를 입력해 주세요: ");
//
//
//            String input = s.nextLine();
//            input = input.trim();
//
//            if("".equals(input))
//                continue;
//
//
//            if(input.equals("종료")) {
//                System.out.println("좌표 입력을 종료합니다.");
//
//                ///// System.exit(0);은 분명하게 프로그램을 종료할 수 있지만
//                ///// 만약 무한으로 돌고 있는 while 반복문만 종료하고 싶다면 break; 만 써줘도 되겠죠?
//                break; // System.exit(0)에서 수정함
//            }
//
//
//            coordinate = Arrays.toString(input.split(","));
//            coordinate = coordinate.substring(1,coordinate.length()-1);
//
//
//            Pattern p = Pattern.compile("[0-9].[0-9]");
//            Matcher m = p.matcher(input);
//
//
//            String x = String.valueOf(coordinate.charAt(0));
//
//
//            //숫자 두개가 있는 패턴과 입력값이 일치하는지 확인합니다
//            if (m.matches()) {
//
//                //일치한다면 두번째 입력값을 y값으로 설정합니다
//                String y = String.valueOf(coordinate.charAt(3));
//                System.out.println("입력된 좌표는 x="+x+", y="+y);
//
//                continue;
//            }
//
//            //숫자 두개가 있는 패턴과 일치하지 않는 경우, 숫자 한개 패턴을 만든 후 일치하는지 확인합니다
//            Pattern a = Pattern.compile("[0-9]");
//            Matcher b = a.matcher(coordinate);
//
//
//            if (b.matches()) {
//
//                CountNumber cn = new CountNumber();
//
//                String negative = "-";
//
//                //한자리 수 중 음수인지 확인합니다
//                if(coordinate.indexOf(negative)>-1) {
//                    System.out.print(negative);
//                    cn.negativeone(coordinate);
//                    continue;
//
//                    //한자리 수 중 양수인지 확인합니다
//                } else {
//                    cn.positiveone(coordinate);
//                    continue;
//                }
//            }
//
//            //숫자 한개의 패턴과도 일치하지 않는 경우 자동으로 세개 이상의 값을 입력받았을 경우로 넘어갑니다
//            CountNumber cn = new CountNumber();
//            System.out.print(coordinate);
//            cn.threeormore(coordinate);
//
//            continue;
//        }
//	}
//}
//
//
//class CountNumber {
//
//    //숫자 한개를 입력받았고, 그 값이 음수인 경우입니다
//    String negativeone(String coordinate)  {
//
//        //마이너스 부호를 빼고 절대값을 구합니다
//        coordinate = coordinate.substring(1);
//
//        Is is = new Is();
//        is.eunnun(coordinate);
//
//        return coordinate;
//    }
//
//    //숫자 한개를 입력받았고, 그 값이 양수인 경우입니다
//    void positiveone(String coordinate) {
//
//        System.out.print(coordinate);
//
//        Is is = new Is();
//        is.eunnun(coordinate);
//    }
//
//
//    //숫자 세개를 입력받았을 경우입니다
//    void threeormore(String coordinate) {
//        // 1,2,3을 입력받았을 경우 3,2,1로 뒤집습니다. 맨 마지막 자리수에 따라 '은'이 붙을지'는'이 붙을지 결정되기 때문입니다.
//        String reverse = (new StringBuffer(coordinate)).reverse().toString();
//        // 뒤집은 값의 첫번째 자리수를 구합니다
//        char tmp=reverse.toCharArray()[0];
//
//        String A = String.valueOf(tmp);
//
//        Is is = new Is();
//        is.eunnun(A);
//    }
//}
//
/////// 이 클래스 네이밍 좋았어요!
/////// 관례적으로 is 나 has 같은 걸 true/false 판단할 때 쓰거든요. 클래스 이름엔 is를 잘 쓰지는 않지만 Is 클래스 참신해요!
//class Is {
//    void eunnun(String A){
//        //2,4,5,9가 입력값에 포함되었는지 확인하는 패턴을 만들고 확인합니다
//        Pattern c = Pattern.compile("2||4||5||9");
//        Matcher d = c.matcher(A);
//
//        ///// 은/는 조사까지 구분해서 출력하는 디테일함...!!
//        if (d.matches()) {
//            System.out.println("는 잘못된 좌표입니다.");
//        } else {
//            System.out.println("은 잘못된 좌표입니다.");
//        }
//    }
//}
