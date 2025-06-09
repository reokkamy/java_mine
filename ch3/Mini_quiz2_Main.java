package ch3;

import java.util.Scanner;

public class Mini_quiz2_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 클래스명.메서드 부분에, 이해가 안가요,
        // 디버깅 하기,
        // 1) 중단점 찍기, 코드 라인 번호 앞에 클릭 시, 빨간점이 생성.
        // 2) 실행 , 디버깅 시작, f5
        // 3) 디버깅 중, f10 : 단위 실행, 다음 단계로 넘어가기
        // 언제 다음 단계로 넘어가냐?, 메서드 진입, 반복문에 진입 아닌 것들,
        // 출력, 변수 정의, 그냥 넘어가기,
        // f11 : 메서드 내부로 이동(단계정보), 메서드, 반복문에 보통 들어가고, 다른 기능은 가급적 안들어가기
        // 만약, 들어가면, 궁금하지 않은 메서드의 구체적인 실행 단계를 다봐야 함. 피로도 상승함.
        // shift + f11 : 메서드 나가기(단계 출력)
        // 만약, 잘못 들어가거나, 다시 나올 경우에는
        // Mini_quiz2_Func.quiz1(scanner);

        // 퀴즈2, 3x3 배열을 만들어 모든 요소에 1~9 채우고 출력
        // Mini_quiz2_Func.quiz2();
        scanner.close();

        // 퀴즈3, 문자열 배열을 메서드로 받아 가장 긴 문자열을 반환
        // 방법1
        String[] strings = { "apple", "banana", "cherry", "date" };
        String longestString = Mini_quiz2_Func.quiz3(strings);
        System.out.println("방법1, 가장 긴 문자열: " + longestString);
        // 방법2, strings, 랜덤하게 생성하는 메서드 이용해서,
        String[] randomStrings = Mini_quiz2_Func.generateRandomStrings(5);
        String longestRandomString = Mini_quiz2_Func.quiz3(randomStrings);
        System.out.println("방법2, 랜덤 문자열 중 가장 긴 문자열: " + longestRandomString);

    }
}
