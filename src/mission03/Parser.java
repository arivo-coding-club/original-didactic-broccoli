package mission03;

import java.util.Scanner;

public class Parser {
    private Scanner scanner;

    public Parser() {
        // 파싱에 필요한 것 초기화
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