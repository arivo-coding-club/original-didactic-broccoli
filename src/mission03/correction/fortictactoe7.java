package mission03.correction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class fortictactoe7 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String coordinate = "";

        while(true) {
            System.out.print("좌표를 입력해 주세요: ");

            /*
             우선 이 프로그램에서 정상적인 입력으로 간주하는 것은 숫자,숫자 거나 종료죠?
             거기에 조금 보태 조금 사용자의 입력에서 편의를 봐주기 위해 trim() 메서드를 이용해 공백을 제거해줄 수 있어요

             "종료" -> O
             " 종료 " -> O
             "종 료" -> 이건 무리

             위에서 "종 료"는 replaceAll 메서드를 이용해 수정해줄 수 있긴해요.
             // input이 "종 료"일 때
             input = input.replaceAll(" ", ""); // " "을 모두 ""로 변환
             System.out.println(input); // "종료" 출력

             여기서 우리는 문자열에서 공백을 없애기 위한 두 가지의 방법을 살펴봤어요.
             그 때 그 때 상황에 맞는 것을 활용해 주면 돼요.
             trim()은 문자옆의 앞, 뒤에 있는 공백을 없애는 것이고
             replaceAll은 특정 문자열을 다른 문자열로 바꾸는 기능을 제공하는데 그걸 이용해 공백을 빈 문자로 바꿨어요.
             쉽게 얘기하면 replaceAll은 우리가 워드프로세서에서 쓰는 "찾아 바꾸기" 기능에 해당한다고 볼 수 있어요.

             어쨌든 문제에서는 trim을 써보는 것이었으니 trim을 활용하는 방법으로 첨삭을 할게요

             일단 "종료"를 처리하는 방법은 위와 같고,
             숫자,숫자 형태의 입력은 종료라는 정해진 두 글자에 비해서 처리하는 게 더 복잡하겠죠?

             그래서 정규표현식을 활용해보는 거구요. 앞으로 정규표현식은 자주 만나게 될 거예요.

             우선은 정규표현식이 익숙하지 않으니 먼저 설명을 해보자면
             숫자,숫자 형태로 입력을 받길 원하지만 사용자가 의도치 않게 버릇이나 오타로 공백이 들어갈 수 있는 것 정도는 우리가 처리해주겠다.
             라는 의도로 프로그램을 짜본다면
              "숫자,숫자", "숫자, 숫자", " 숫자 , 숫자 " 이렇게 다양하게 입력할 수 있을거구요.

             여기서 하나의 조건이 추가된다면 틱택토에서 사용할 거니까 저 숫자는 배열 인덱스의 시작인 0을 시작값으로 본다면
             0, 1, 2만 가능하겠죠?

             그렇다면 정규표현식으로도 그 패턴을 표현할 수 있어요.
             [0-9]를 사용하셨으니 이 의미는 알고 있다고 가정하고, [0-9]는 0에서 9사이의 글자를 의미하는 것이니까
             0, 1, 2 외의 불필요한 3~9도 패턴에 포함이 돼요.
             그래서 0, 1, 2만 받는다면

             "[0-9],[0-9]" -> "[012],[012]"
             로 바꾼다면 3~9라는 글자를 처리할 필요는 없겠죠?

             그리고 거기에 앞 뒤에 공백이 포함될 수도 있으니까
             "[012],[012]" -> " *[012],[012] *"
             콤마 양 옆으로도 공백을 넣을 수도 있으니까
             " *[012] *, *[012] *"

             조금은 논외의 이야기이지만 프로그램이든 앱이든 쓰는 사람이 당연하게 쓰는 것들을 지원하기 위한 코드를 보고 UX(User Experience)를 고려한 코드라고 할 수 있어요.
             주로 UX는 우리가 쓰는 앱처럼 그래픽으로 구성된 프로그램에서 쓰긴 하지만, 우리는 글자밖에 없는 환경에서 사용자와 상호작용하는 부분이
             사용자의 입력을 처리하는 부분이니 UX라고 할 수 있어요.

             ex)
             불친절한 UX: 무조건 "숫자,숫자" 를 정확하게 입력해야함. 아닌 경우 재입력
             친절한 UX: 어떻게 입력하든 숫자 콤마 숫자가 섞여 있으면 정상 입력으로 코드를 짜는 사람이 가공해서 사용
             */
            String input = s.nextLine();
            input = input.trim();

            if("".equals(input))
                continue;


            if(input.equals("종료")) {
                System.out.println("좌표 입력을 종료합니다.");

                ///// System.exit(0);은 분명하게 프로그램을 종료할 수 있지만
                ///// 만약 무한으로 돌고 있는 while 반복문만 종료하고 싶다면 break; 만 써줘도 되겠죠?
                System.exit(0);
            }

            ///// Arrays.toString() 메서드를 쓴 건 그뤠잇! 그치만 여기서는 Arrays.toString()을 쓰지 않는게 덜 번거로울 수 있어요
            ///// 왜냐하면 input.split(",")의 결과는 콤마로 나눠진 문자열을 배열로 반환하니까
            ///// String[] coordinates = input.split(",");
            ///// 이렇게 해두면 coordinates[0]은 첫 번째 숫자,, coordinate[1]은 두 번째 숫자니까
            ///// 뒤에서 다시 substring으로 대괄호를 제거해주는 작업이 없어도 되겠죠?
            //입력값을 콤마를 기준으로 구분하고 배열문에서 [ ]을 제거합니다
            coordinate = Arrays.toString(input.split(","));
            coordinate = coordinate.substring(1,coordinate.length()-1);


            ///// 정규표현식에서 . 은 하나의 글자를 의미하기 때문에
            ///// 아래 [0-9].[0-9] 패턴은
            ///// 1.1 -> match
            ///// 1,1 -> match
            ///// 1?1 -> match
            ///// 1가1 -> match
            ///// 있는 그대로의 . 문자를 정규표현식에서 쓰기 위해서는 역슬래시 두개를 앞에 붙여주면 돼요
            ///// [0-9].[0-9] -> [0-9]\\.[0-9]
            ///// 이렇게 문자열내에서 글자 그대로가 아니라 어떤 의미를 갖는 문자를 글자 그대로 사용하기 위해서 \\ 를 붙이는 걸 escaping 한다고 해요.
            ///// 개발하다보면 가끔씩 만나게 될 용어일거예요.
            ///// 정규표현식에서는 백슬래시를 두 개 붙이고, HTML에서는 태그가 <html> 이렇게 꺽쇠 괄호가 있어서, 그냥 괄호 문자를 쓰기 위해서는
            ///// <html> -> &lt;html&gt; 과 같이 이스케이핑해 줘요. 그 때 그 때 다르지만 어쨌든 저런 걸 이스케이프라고 하는 걸로 알 고 있으면 돼요~!

            ///// 저는 String.matches 메서드를 사용할 걸로 예상했는데 Pattern, Matcher 클래스까지 찾아서 쓰다니 멋져요. 크으 乃乃
            ///// 여기서도 알 수 있지만 정규표현식의 패턴과 비교할 수 있는 방법도 적어도 두 가지라는 걸 알 수 있겠죠?
            Pattern p = Pattern.compile("[0-9].[0-9]");
            Matcher m = p.matcher(input);


            //입력값 첫번째를 x값으로 설정합니다(입력값 개수에 따라 if문을 나누었기 때문에, 한자리수는 반드시 입력받으므로 x값만 우선 설정했습니다)
            ///// 여기도 역시 Arrays.toString을 쓰지 않았더라면
            ///// String x = cooordinates[0].charAt(0) 으로 쓸 수 있겠죠?
            ///// 조금 더 보태자면
            ///// int x = coordinates[0].charAt(0) - '0' 으로 할 수도 있고
            ///// int x = Integer.parseInt(coordinate[0]) 으로 할 수도 있어요.
            String x = String.valueOf(coordinate.charAt(0));


            //숫자 두개가 있는 패턴과 입력값이 일치하는지 확인합니다
            if (m.matches()) {

                //일치한다면 두번째 입력값을 y값으로 설정합니다
                String y = String.valueOf(coordinate.charAt(3));
                System.out.println("입력된 좌표는 x="+x+", y="+y);

                continue;
            }

            ///// 저는 여기서 감동..!
            ///// 그냥 패턴이 일치하지 않으면 불친절하게 ~ 은/는 잘못된 입력입니다. 라고 출력하고 다시 입력을 받으려고 했는데
            ///// 각 케이스별로 하나하나 체크하는 디테일에 가산점 드리겠습니당 ㅋㅋㅋ

            //숫자 두개가 있는 패턴과 일치하지 않는 경우, 숫자 한개 패턴을 만든 후 일치하는지 확인합니다
            Pattern a = Pattern.compile("[0-9]");
            Matcher b = a.matcher(coordinate);


            if (b.matches()) {

                CountNumber cn = new CountNumber();

                String negative = "-";

                //한자리 수 중 음수인지 확인합니다
                if(coordinate.indexOf(negative)>-1) {
                    System.out.print(negative);
                    cn.negativeone(coordinate);
                    continue;

                    //한자리 수 중 양수인지 확인합니다
                } else {
                    cn.positiveone(coordinate);
                    continue;
                }
            }

            //숫자 한개의 패턴과도 일치하지 않는 경우 자동으로 세개 이상의 값을 입력받았을 경우로 넘어갑니다
            CountNumber cn = new CountNumber();
            System.out.print(coordinate);
            cn.threeormore(coordinate);

            continue;
        }
    }
}


///// 아래 클래스와 메서드들을 나눠서 쓴 건 정말 좋았어요
///// 가끔 원래 개발을 배웠었나 하는 생각이 들게 하는 ㅋㅋ
///// 조금 보태자면 매번 객체를 생성해서 사용하지 않아도 되도록
///// static 메서드로 만들면 더 좋을 것 같아요!
class CountNumber {

    //숫자 한개를 입력받았고, 그 값이 음수인 경우입니다
    String negativeone(String coordinate)  {

        //마이너스 부호를 빼고 절대값을 구합니다
        coordinate = coordinate.substring(1);

        Is is = new Is();
        is.eunnun(coordinate);

        return coordinate;
    }

    //숫자 한개를 입력받았고, 그 값이 양수인 경우입니다
    void positiveone(String coordinate) {

        System.out.print(coordinate);

        Is is = new Is();
        is.eunnun(coordinate);
    }


    //숫자 세개를 입력받았을 경우입니다
    void threeormore(String coordinate) {
        // 1,2,3을 입력받았을 경우 3,2,1로 뒤집습니다. 맨 마지막 자리수에 따라 '은'이 붙을지'는'이 붙을지 결정되기 때문입니다.
        String reverse = (new StringBuffer(coordinate)).reverse().toString();
        // 뒤집은 값의 첫번째 자리수를 구합니다
        char tmp=reverse.toCharArray()[0];

        String A = String.valueOf(tmp);

        Is is = new Is();
        is.eunnun(A);
    }
}

///// 이 클래스 네이밍 좋았어요!
///// 관례적으로 is 나 has 같은 걸 true/false 판단할 때 쓰거든요. 클래스 이름엔 is를 잘 쓰지는 않지만 Is 클래스 참신해요!
class Is {
    void eunnun(String A){
        //2,4,5,9가 입력값에 포함되었는지 확인하는 패턴을 만들고 확인합니다
        Pattern c = Pattern.compile("2||4||5||9");
        Matcher d = c.matcher(A);

        ///// 은/는 조사까지 구분해서 출력하는 디테일함...!!
        if (d.matches()) {
            System.out.println("는 잘못된 좌표입니다.");
        } else {
            System.out.println("은 잘못된 좌표입니다.");
        }
    }
}



///// 컨벤션(Convention) 이야기
///// 컨벤션이라고 그냥 하기도 하고, 관습, 관례라고도 해요. 언어마다 어느정도 정해진 단어 표현 방법이나, 네이밍 등에 대한 관습이 조금씩 있어요.
///// 문법과 다른 점이라면 꼭 지키지 않아도 컴파일이 잘 되지만, 서로 컨벤션을 잘 지키면 보기도 편하고, 코드의 의도를 조금 더 쉽게 알 수 있어요.
///// 여러가지 자바 컨벤션들이 있지만 여기서는 간단하게 클래스 이름과 메서드 이름, 변수 이름에 대한 컨벤션을 잠깐 이야기하려고 해요
/////
///// 클래스 이름
///// 클래스 이름은 대문자로 시작하고, 보통은 명사로 지어요.
///// Is 도 좋았지만 컨벤션을 따른다면 Condition이나 Checker 같은 이름일 수도 있겠죠?
///// 여러 단어가 붙어 있는 경우에는 단어의 앞 글자를 대문자로 써주면 돼요.
///// 예) 조사 체크하는 클래스 -> PostpositionalWordChecker
/////
///// 인터페이스 이름
///// 인터페이스는 클래스와 같이 명사거나, 형용사로 지어요
///// "실행가능한"을 의미하는 Runnable 인터페이스
///// 형용사인 경우는 그 인터페이스를 구현(implements) 하는 클래스의 수식어가 될 수 있어요.
///// 예를 들어 Game 이라는 클래스가 Runnable 인터페이스를 구현한다면
///// 실행가능한 게임 이라고 자연스럽게 읽을 수 있겠죠?
/////
///// 메서드 이름, 변수 이름(멤버 변수, 지역변수, 매개변수)
///// 시작은 소문자로 하고, 여러 단어로 구성되는 경우에는 시작단어를 대문자로 써요. 이걸 camel case 라고 해요
///// 예를 들어 Is 클래스의 eunnun 메서드는 클래스 이름을 바꿔서 Check로 하고, 메서드 이름은 은는 여부를 체크해서 출력하니까
///// isEunnun 으로 할 수 있겠죠>
/////
///// 그치만 자바에선 is로 시작하는 메서드는 boolean을 반환하는 메서드가 많아서
///// printByEunnun 같은 것도 괜찮을 것 같아요!
/////
///// 부가적으로 메서드는 어떤 동작을 하는 역할을 하니까 동사로 된 단어로 지어줘요.
