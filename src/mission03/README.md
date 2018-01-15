# Tic Tac Toe the 틱택토
`Tic Tac Toe` 게임은 3x3 격자에서 서로 번갈아가며 말을 놓고, 일직선으로 같은 말을 놓으면 이기는 게임입니다.
이 게임을 모델링 하려면 다양한 방법으로 할 수 있겠지만, 우리는 조금 더 멋진 틱택토를 만들기 위해 처음부터 설계를 잘 해보려고 합니다.

처음에는 텍스트 기반의 화면(까만 화면에 글자만 있는 - 꼭 까만 화면이 아닐 수도.., CUI)에서 틱택토 게임을 만들어보고,
이 후에 Java AWT나 Swing을 이용해서 코드를 재활용해서 CUI에서 GUI로 조금 더 있어보이도록 만들어 볼 거예요.

그리고 2명이 하는 게임이다 보니 나 혼자 만들고 나 혼자 테스트 하는 것보단 다른 플레이어를 넣어서 게임을 해보는 게 좋을테니
게임을 하는 플레이어의 개념을 확장해서 나혼자(Local), 컴퓨터, 네트워크를 통해 다른 사람과 플레이할 수 있는 Remote로 구분해서 만들어볼까합니다.
Local, Remote라는 용어를 썼는데 Local은 게임을 실행하고 있는 현재 컴퓨터를 의미하고, Remote는 네트워크로 연결된 컴퓨터를 의미한다고 생각하면 됩니다.

위는 앞으로 만들어볼 틱택토 게임의 큰 그림(?)에 대한 설명이고, 시작은 가볍게 CUI 기반, Local 플레이어와 플레이할 수 있도록 만들어볼 예정입니다.
말은 어려워 보이지만 아래와 같이 될 거예요.

```
Tic Tac Toe 게임을 시작합니다.

플레이 모드를 입력해 주세요
1. Local
2. Computer (아직 미지원)
3. Remote (아직 미지원)
입력: 2
Computer 모드는 아직 지원하지 않습니다.

플레이 모드를 입력해 주세요
1. Local
2. Computer (아직 미지원)
3. Remote (아직 미지원)
입력: 1
Local 모드를 시작합니다.

1번 플레이어의 이름을 입력해 주세요: queen
2번 플레이어의 이름을 입력해 주세요: king

|   |   |   |
|   |   |   |
|   |   |   |

queen 님 차례입니다. 좌표를 입력해 주세요: 1,1
| O |   |   |
|   |   |   |
|   |   |   |

king 님 차례입니다. 좌표를 입력해 주세요: 2, 2
| O |   |   |
|   | X |   |
|   |   |   |

...

| O | X | X |
| O | X |   |
| O | O |   |
queen 님이 이겼습니다.
```
  
---
  
# Tic Tac Toe 를 본격적으로 시작하기 전에 연습 문제
## 1. Parsing
글자로만 구성되어 있는 텍스트 데이터를 읽어서 의미 있는 데이터로 만드는 것을 Parse 라고 합니다.
틱택토를 만들면서 이것저것 파싱할 일이 생길 것 같지만 여기서는 연습문제로 좌표를 문자열로 입력 받아서 Position 클래스의 객체로 저장해봅시다.
인터넷 검색도 마음껏 하면서 문제를 풀어주세요~!

좌표 파싱을 위한 재료
```
정규표현식 - Chapter 9. 505 페이지
Scanner 클래스 - Chapter 9. 510 페이지
String 클래스의 split 메서드, trim 메서드 - split 메서드는 정규표현식을 이용해 문자열을 나누도록 되어있어요
Integer 클래스의 parseInt 정적 메서드
```

프로그램을 실행하면 아래와 같이 되도록 만들어 봅시다.
- 좌표를 입력해 주세요: 라고 되어있는 부분은 사용자의 입력을 받는 부분입니다.
- 좌표의 형식은 숫자 콤마 숫자로 구성된 것만 받도록 합니다.
- 잘못된 좌표의 판단은 정규표현식을 통해 숫자,숫자의 패턴이 맞는지 확인합니다.
- 사용자가 "종료"라고 입력하면 입력을 그만 받습니다(무한 루프 중지), 그렇지 않으면 계속해서 반복하여 입력 받습니다.
```
좌표를 입력해 주세요: 1
1은 잘못된 좌표입니다. 

좌표를 입력해 주세요: 1, 2
입력된 좌표는 x=1, y=2

좌표를 입력해 주세요: 1,2,3,4
1,2,3,4는 잘못된 좌표입니다.

좌표를 입력해 주세요: 3, 3
입력된 좌표는 x=3, y=3

좌표를 입력해 주세요: 종료
좌표 입력을 종료합니다.
```

```
package mission03;

import java.util.Scanner;

public class Parser {
    private Scanner scanner;

    public Parser() {
        // 파싱에 필요한 것
        scanner = new Scanner(System.in);
    }

    public void start() {
        // 입력을 계속해서 받도록 하기 위해 무한 루프
        while(true) {
            print("좌표를 입력해 주세요: ");

            String input = getInput();

            if(isExitCommand(input)) {
                print("좌표 입력을 종료합니다.");
                break;
            }

            if(isCoordinatePattern(input)) {
                Coordinate coordinate = toCoordinate(input);
                print("입력한 좌표는 " + coordinate + " 입니다.");
            } else {
                // 좌표 패턴이 아닌 경우
                print(input + " 은/는 잘못된 좌표 형식입니다.");
            }
        }
    }

    void print(String message) {
        System.out.print(message);
    }

    String getInput() {
        return scanner.nextLine();
    }

    boolean isExitCommand(String input) {
        // 종료는 문자열만 비교하면 되므로 String의 equals 메서드 사용
        // String의 equals는 글자가 같은지를 비교하도록 구현되어 있어요.
        return "종료".equals(input);
    }

    boolean isCoordinatePattern(String input) {
        // 정규표현식 간단 정리
        // \\d -> 숫자 1자리: 0~9
        // + -> 앞에 온 문자가 1개 이상인 것을 의미
        // \\d+ -> 숫자가 1개 이상
        // , 콤마는 그냥 콤마
        // 정리하면 \\d+,\\d+ 는 숫자 1개 이상 콤마 숫자 1개 이상이므로
        // 123,456 같은 좌표 형식인 경우에는 true가 됨

        // 1,1 -> true
        // 1, -> false
        // 11 -> false
        // 12345678,123987139821 -> true

        // 공백(스페이스)를 입력할 수도 있으므로
        // 이 경우는 정상 입력으로 간주하고, trim으로 자름
        // + 는 1개 이상이었다면
        // * 는 0개 이상. 즉 있을수도 있고 없을 수도 있음
        // 공백* 의 의미는 공백이 있을 수도 있고, 없을 수도 있음
        return input.matches(" *\\d+ *, *\\d+ *");
    }

    Coordinate toCoordinate(String input) {
        String[] splitted = input.split(",");

        // trim으로 공백을 제거해서 다시 배열에 저장
        splitted[0] = splitted[0].trim();
        splitted[1] = splitted[1].trim();

        // int 타입으로 변환 (parseInt 메서드 활용)
        // Integer.parseInt 메서드는 숫자문자로 구성된 문자열을 숫자 타입으로 변환
        // "123" -> 123
        int x = Integer.parseInt(splitted[0]);
        int y = Integer.parseInt(splitted[1]);

        Coordinate coordinate = new Coordinate(x, y);
        return coordinate;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.start();
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        // toString 메서드를 오버라이드해서 출력할 때 사용할 예정
        return "x=" + x + ", y=" + y;
    }
}
```

## 2. Parsing2
URL(Universal Resource Locator) - Wiki https://ko.wikipedia.org/wiki/URL  
`scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]`   
Recursive  


## 2. 3x3 배열을 출력해보기
- 작성 중 -

## 3. 클래스 모델링
- 작성 중 -
- 2차원 좌표: 위에서 좌표를 입력해 주세요. 라고 했을 때 입력한 좌표를 저장할 클래스입니다.
```
public class Position {
  private final int x;
  private final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
```

- 플레이어 인터페이스
```
public interface Player {
  void setName();
  String getName();
  boolean isReady();
  Position play();
}
```

- 로컬 플레이어 클래스
public class LocalPlayer implements Player {

}


```
public class Game {

}
```

```
public class Piece {

}

public class Board {

}
```

Menu, MenuGroup
-- 작성 중..


