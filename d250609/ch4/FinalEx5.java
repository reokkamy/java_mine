package d250609.ch4;

public class FinalEx5 {
    // final : 값 변경 금지 (변수에 사용시) -> 상수가 됨.

    // 뒤에서 , 상속 할 때 설명하기.
    // 메서드, 클래스에서도 사용함.
    // 메서드 : final 사용시, 오버라이딩 금지
    // 클래스 : final 사용시, 상속 금지
    public static final double PI = 3.14159;

    public void circleMethod(int radius) {
        double result = radius * radius * PI;
        System.out.println("원 면적 : " + result);

    }
}
