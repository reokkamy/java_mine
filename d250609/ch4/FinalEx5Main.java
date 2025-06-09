package d250609.ch4;

public class FinalEx5Main {
    // 퀴즈 2
    // BankAccount 클래스 만들기,
    // 인스턴스 멤버 변수 : 소유자(owner) 문자열 타입,

    // static 멤버 변수,
    // 계좌개설건수 (accountCount) int 타입 , static
    // 이자율 : 상수 final 로 선언, : INTEREST_RATE = 0.02;, double 타입 , static

    // 생성자는 , 매개변수가 하나인 생성자, owner ,
    // 추가로, 계좌 개설시, 계좌개설건수 자동으로 하나씩 증가
    // 현재 총 계좌 건수, 이자율를 확인하는 메소드 : showInfo()

    // 인스턴스 최소 3개이상 만들기.

    public static void main(String[] args) {
        FinalEx5 finalEx5 = new FinalEx5();
        finalEx5.circleMethod(10);
        // final 로 정의한, 공유 상수 변경 시도 -> 변경 불가.
        // FinalEx5.PI = 3.14;
    }
}