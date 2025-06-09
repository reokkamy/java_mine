package user_mini_project;

import java.util.Scanner;

import ch2.OperConditionTest;
import util.user.UserService;

public class MainClass_switch_case_doc {
    public static void main(String[] args) {
        // 공용으로 사용할 스캐너 생성
        Scanner scanner = new Scanner(System.in);

        // 무한 루프이고, 메인 메뉴를 출력하는 부분
        // 반복문 안에서, 리턴등으로 나오지 않는 이상, 계속 출력이 됨.
        while (true) {
            System.out.println("========================================================");
            System.out.println("회원 관리 시스템에 오신 것을 환영합니다. 배운거 복습 적용해보기");
            // 순서3
            // 3번 메뉴 추가
            System.out.println("1. 회원 가입  2.로그인 3.산술 연산자 테스트  4.산술 연산자 테스트2  0.종료");
            System.out.println("========================================================");
            System.out.println("메뉴 번호를 선택해주세요 (0~4): ");
            // 사용자가 입력한 번호를 문자열 형태로 받기
            String choice = scanner.nextLine();
            // 두번째, switch 형태의 조건문
            switch (choice) {
                case "1":
                    // 회원 가입 기능 호출
                    UserService.registerUser(scanner);
                    break;
                case "2":
                    // 로그인 기능 호출
                    UserService.loginUser(scanner);
                    // 순서4
                    // 3번 메뉴 로직 추가 후 실행.
                    break;
                case "3":
                    // 산술연산자 테스트 기능 호출
                    OperConditionTest.oper1();
                    break;
                case "4":
                    // 산술연산자 테스트 기능 호출
                    OperConditionTest.oper2();
                    break;
                case "0":
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다. 감사합니다!");
                    scanner.close(); // 스캐너 자원 반납
                    return; // while 루프 종료
                default:
                    // 잘못된 입력 처리
                    System.out.println("잘못된 입력입니다. 0, 1, 2 중에서 선택해주세요.");
            }
        }
    }
}
