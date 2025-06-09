package ch3;

import java.util.Scanner;

import ch2.Exs;

public class Exs_ch3_Main {
    public static void main(String[] args) {
        // 공용으로 사용할 스캐너
        Scanner scanner = new Scanner(System.in);

        // ex3-8-2, 배열을 리턴하는 메서드
        int[] returnArray = Exs_ch3.ex3_8_return(); // 배열 생성, 조회, 반복문 출력 예시
        System.out.println("ex3-8-2, 리턴된 배열의 값:");
        for (int number : returnArray) {
            System.out.print(number + " "); // 1 2 3 4 5 출력
        }

        // Ex3-8, 배열 생성, 조회, 반복문 출력 예시
        // Exs_ch3.ex3_8();
        System.out.println("============================");

        // ex3_7 , 확인 하는 예시 메소드
        // Exs_ch3.ex3_7(scanner);
        System.out.println("============================");

        // 회원 관리 프로그램 예시, ui 그리기,
        // Exs_ch3.ex_user_ui(scanner);
        System.out.println("============================");

        // Ex3-6-3, 이중 배열 예시
        // Exs_ch3.ex3_6_3();
        System.out.println("============================");

        // Ex3-6-2, 배열 직접 생성과 값 할당 예시
        // Exs_ch3.ex3_6_2();

        // Ex3-6, 배열1, 기본 생성과, 값 할당, 반복문 활용한 출력 예시
        // Exs_ch3.ex3_6();
        System.out.println("============================");

        // Ex3-5, continue 확인 , 다음 반복으로 넘어가는 예시,
        // Exs_ch3.ex3_5(scanner);
        System.out.println("============================");

        // Ex3-4 , 중첩 반복문 이용해서 구구단 출력해보기
        // Exs_ch3.ex3_4();

        // Ex3-3 퀴즈 ,do while 문 예시 확인.
        // Exs_ch3.ex3_3();
        System.out.println("\n============================");

        // Ex3-2 퀴즈 , 예시 확인.
        // int count = Exs_ch3.ex3_2_quiz(scanner);
        // System.out.println("입력한 문자 개수: " + count);
        System.out.println("============================");

        // Ex3-2 , 예시 확인.
        // Exs_ch3.ex3_2(scanner);
        System.out.println("============================");

        // Ex3-1 , 예시 확인.
        // int result_ex3_1 = Exs_ch3.getSum(10); // 55
        // System.out.println("Ex3-1: 1~10까지의 합 = " + result_ex3_1);

        scanner.close(); // 스캐너 자원 반납
    }
}
