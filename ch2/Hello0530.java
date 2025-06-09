package ch2;

public class Hello0530 {
    public static void main(String[] args) {
        System.out.println("Test~~출력");
        // 만들었던 클래스를 불러와서, 재사용 해보기.
        // 본인 소개 및, 간단 계산 해보기.
        // 본인 소개.
        String myInfo = Introduce.introduce("이상용", "010-7661-3709", "lsy@naver.com");
        System.out.println(myInfo);
        String myHobby = Introduce.introduce_hobby("비빔밥", "러닝", "스타1");
        System.out.println(myHobby);

        // 퀴즈 1
        // Introduce 클래스에, 정의한 사칙연산 메소드를 이용해서, 각각 계산 결과를
        // result1, result2, result3, result4 변수에 담아서, 출력해보기
        int result1 = Introduce.sum(100, 200);
        System.out.println("sum 이라는 함수 이용해서 결과 출력 : " + result1);

        int result2 = Introduce.mul(10, 20);
        System.out.println("mul 이라는 함수 이용해서 결과 출력 : " + result2);
    }
}
