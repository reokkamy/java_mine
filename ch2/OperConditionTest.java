package ch2;

public class OperConditionTest {

    // 순서1
    // 연습하는 메서드 추가
    public static void oper1() {
        // 1. 산술 연산자
        int a = 10;
        int b = 20;
        System.out.println("산술 연산자 테스트");
        System.out.println("a + b = " + (a + b)); // 덧셈
        System.out.println("a - b = " + (a - b)); // 뺄셈
        System.out.println("a * b = " + (a * b)); // 곱셈
        System.out.println("몫: b / a = " + (b / a)); // 나눗셈
        System.out.println("나머지: b % a = " + (b % a)); // 나머지
    }

    // 퀴즈 ,
    // 1) 여기에 임의의 산술 연산하는 기능의 정적 메서드 만들기. 메서드명 : oper2()
    // 2) 클래스명 : OperConditionTestMain, 여기에서 메서드명 : oper2( 1차 실행 확인
    // 3) 클래스명 : MainClass, 여기에 4번 메뉴로 추가하기
    // 4) MainClass에서 실행 확인하기
    public static void oper2() {
        // 1. 산술 연산자
        int a = 100;
        int b = 200;
        System.out.println("산술 연산자 테스트2");
        System.out.println("a + b = " + (a + b)); // 덧셈
        System.out.println("a - b = " + (a - b)); // 뺄셈
        System.out.println("a * b = " + (a * b)); // 곱셈
        System.out.println("몫: b / a = " + (b / a)); // 나눗셈
        System.out.println("나머지: b % a = " + (b % a)); // 나머지
    }

    // 조건문 예시 메서드
    public static void conditionExample() {
        int number = 0;

        System.out.println("조건문 if 예시 시작");
        // if 문 예시
        if (number > 0) {
            System.out.println("양수입니다.");
        } else if (number < 0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0입니다.");
        }

        System.out.println("조건문 스위치 예시 시작");
        // switch 문 예시
        switch (number) { // 스위치 조건으로 확인 후, break 문으로 빠져나옴
            // 만약, break 문이 없으면, 다음 case로 계속 진행됨
            case 0:
                System.out.println("0입니다.");
                break; // case 0에서 빠져나옴
            case 1:
                System.out.println("1입니다.");
                break; // case 1에서 빠져나옴
            default:
                System.out.println("1이 아닌 다른 숫자입니다.");
                break; // default에서 빠져나옴
        }
    }
    // if문 vs switch문 성능 차이

    // | 항목 | `if` 문 | `switch` 문 |
    // | ------------------ | ---------------- |
    // --------------------------------------- |
    // | **조건 평가 방식** | 위에서 아래로 차례로 평가 | 컴파일러가 jump table로 최적화 |
    // | **성능 (분기 수 많을 때)** | 느려질 수 있음 | 더 빠름 (특히 `int`, `enum`, `String`) |
    // | **최적화** | 명확한 패턴 없으면 단순 분기 | JVM이 내부적으로 jump table 또는 hash table 최적화 |
    // | **실행 시간** | 조건 많을수록 늘어남 | 대부분 일정 (O(1) 수준 가능) |

    // 💡 **요약**:

    // * 분기 수가 많고 조건 값이 명확(숫자, 문자, enum, 문자열)하면 `switch`가 성능상 더 유리
    // * 분기가 3\~4개 이하거나 복잡한 조건이면 `if`가 더 적절

}
