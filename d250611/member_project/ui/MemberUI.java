package d250611.member_project.ui;

import java.util.Scanner;

import d250611.member_project.service.UserService_ArrayList_version;
import d250611.member_project.service.UserService_HashMap_version;

public class MemberUI {
    public static void drawUI(Scanner scanner) {
        // Ex3-6-4, 배열을 이용한 회원 관리 프로그램 예시
        int menu;
        do {
            System.out.println("회원 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 회원 추가 , 2. 회원 조회, 3. 회원 수정, 4. 회원 삭제, 5.더미 데이터 추가 5개, 6. 검색기능,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 6): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    // UserService_ArrayList_version.addUser(scanner); // 회원 추가
                    UserService_HashMap_version.addUser(scanner); // 회원 추가
                    break;
                case 2:
                    // UserService_HashMap_version.viewUsers(); // 회원 조회
                    UserService_HashMap_version.viewUsers(); // 회원 조회
                    break;
                case 3:
                    // UserService_ArrayList_version.updateUser(scanner); // 회원 수정
                    UserService_HashMap_version.updateUser(scanner); // 회원 수정
                    break;
                case 4:
                    // UserService_ArrayList_version.deleteUser(scanner); // 회원 삭제
                    UserService_HashMap_version.deleteUser(scanner); // 회원 삭제
                    break;
                case 5:
                    // UserService_ArrayList_version.addDummyUsers(); // 더미 데이터 추가
                    UserService_HashMap_version.addDummyUsers(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    // UserService_HashMap_version.searchUser(scanner); // 회원 검색
                    UserService_HashMap_version.searchUser(scanner); // 회원 검색
                    System.out.println("회원 검색 기능이 실행되었습니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
    }
}
