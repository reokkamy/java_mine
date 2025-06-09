package ch3;

import java.util.Scanner;

public class Mini_quiz1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        do {
            System.out.println("도서 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 도서 추가 , 2. 도서 조회, 3. 도서 수정, 4. 도서 삭제, 5.더미 데이터 추가 5개, 6. 검색기능,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 6): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    Mini_quiz1_Func.addBook(scanner); // 도서 추가
                    break;
                case 2:
                    Mini_quiz1_Func.viewBooks(); // 도서 조회
                    break;
                case 3:
                    Mini_quiz1_Func.updateBook(scanner); // 도서 수정
                    break;
                case 4:
                    Mini_quiz1_Func.deleteBook(scanner); // 도서 삭제
                    break;
                case 5:
                    Mini_quiz1_Func.addDummyBooks(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    Mini_quiz1_Func.searchBook(scanner); // 회원 검색
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
