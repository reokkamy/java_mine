package ch3;

import java.util.Scanner;

public class Mini_quiz2_Func {
    // -- 퀴즈1,
    // -- 사용자로부터 정수 5개를 입력받아 배열에 저장하고 역순 출력
    public static void quiz1(Scanner scanner) {
        // 사용자로부터 정수 5개를 입력받아 배열에 저장하고
        int[] numbers = new int[5]; // 빈 배열

        System.out.println("정수 5개를 입력하세요:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt(); // 예시) 1 2 3 4 5 , 공백을 기준으로 입력.
        }

        System.out.println("역순 출력:");
        // 정방향 출력, : numbers[0] ~ numbers[4]
        // 역순 출력, : numbers[4] ~ numbers[0]
        // numbers.length : 배열의 길이, 전체 크기 5
        // numbers.length - 1 : 마지막 인덱스 4
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

    }

    // -- 퀴즈2,
    // -- 3x3 배열을 만들어 모든 요소에 1~9 채우고 출력
    public static void quiz2() {
        int[][] array = new int[3][3]; // 3x3 배열 생성
        // 빈 배열의 모양
        // 0 1 2 열
        // 0행 0 0 0
        // 1행 0 0 0
        // 2행 0 0 0

        int value = 1; // 1부터 시작
        for (int i = 0; i < array.length; i++) { // 행 반복
            for (int j = 0; j < array[i].length; j++) { // 열 반복
                array[i][j] = value++; // 값 할당 후 증가
            }
        }

        // 배열 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(); // 행 끝나면 줄바꿈
        }
    }

    // -- 퀴즈3,
    // -- 문자열 배열을 메서드로 받아 가장 긴 문자열을 반환
    // String[] strings : {"apple", "banana", "cherry", "date"}
    public static String quiz3(String[] strings) {
        // 기본 유효성 체크
        if (strings == null || strings.length == 0) {
            return null; // 빈 배열 처리
        }
        // 상태 변수, 가장 긴 문자열을 임시로 저장.
        // 초기값이 예시 : "apple"
        String longest = strings[0]; // 첫 번째 문자열로 초기화

        // strings 문자열을 요소로 가지는 배열을 반복하면서, 하나씩 꺼내서 비교
        for (String str : strings) {
            // longest : 예시 , "apple", length() : 5
            // str : 예시 , "banana" , length() : 6
            if (str.length() > longest.length()) {
                longest = str; // 더 긴 문자열 발견 시 업데이트
            }
        }

        return longest; // 가장 긴 문자열 반환
    }

    // 임의로, 크기가 5개인, 문자열의 길이는 10개이하인, 랜덤한 문자열을 생성하는 메서드
    // 반환 타입 : 문자열 배열 ,
    public static String[] generateRandomStrings(int size) {
        // size : 생성할 문자열의 개수
        String[] randomStrings = new String[size];
        String characters = "abcdefghijklmnopqrstuvwxyz"; // 소문자 알파벳,26

        for (int i = 0; i < size; i++) {
            int length = (int) (Math.random() * 10) + 1; // 1~10 사이의 길이
            // StringBuilder: 문자열인데, 메모리 절약하는 문자열이다.
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < length; j++) {
                int index = (int) (Math.random() * characters.length()); // 0 ~ 25 사이의 랜덤 인덱스
                // sb : 문자열 배열,
                // charAt(0), 문자열의 인덱스에 해당하는 문자 가져오기
                // characters.charAt(index) : 문자열 중에서, 길이가 26, 인덱스 치면, 0~25
                // characters.charAt(0) -> 'a',
                // characters.charAt(1) -> 'b',
                // ..., characters.charAt(25) -> 'z'
                // sb.append('a'); // 랜덤 문자 추가
                sb.append(characters.charAt(index)); // 랜덤 문자 추가
            }

            randomStrings[i] = sb.toString(); // 문자열로 변환하여 배열에 저장
        }

        return randomStrings; // 생성된 문자열 배열 반환
    }
}
