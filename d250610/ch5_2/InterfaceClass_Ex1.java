package d250610.ch5_2;

public class InterfaceClass_Ex1 {
    // 인터페이스
    // : 기능을 갖추기 위한 약속(계약)
    // 자바는 다중 상속을 지원하지 않음. 다중 구현을 하기 위해서 도입됨.
    // 키워드 :상속 abstract vs interface ,
    // 구현시 :상속 extends vs implements
    // 기능 규약 정의, 설계 기반 제공.
    // 구성품, 상수 또는 추상 메서드를 기본으로 구성함.
    // 자바 8이전에는 전부 추상 메서드로만 구성이 되었지만,
    // 현재는 static, default 그 밖의 여러 기능도 도입 이 가능함.
    // 기본 예시
    // interface Flyable {
    // void fly() ; // 추상 메서드
    // }
    // 구현
    // class Bird implements Flyable {
    // @Override
    // public void fly() { // 의무적으로 재정의 해야함.
    // System.out.println("훨훨 날기~~")
    // }
    // }
}
