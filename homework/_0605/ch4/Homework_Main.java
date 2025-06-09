package homework._0605.ch4;

import java.util.Scanner;

import ch3.Mini_quiz1_Func;

public class Homework_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        do {
            System.out.println("자동차 관리 프로그램");
            System.out.println("=================================================================");
            System.out.println("1. 자동차 추가 , 2. 자동차 조회, 3. 정보 수정, 4. 정보 삭제, 5.더미 데이터 추가 5개, 6. 검색기능,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 6): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    Homework_func.addCar(scanner); // 도서 추가
                    break;
                case 2:
                    Homework_func.viewCars(); // 도서 조회
                    break;
                case 3:
                    Homework_func.updateCar(scanner); // 도서 수정
                    break;
                case 4:
                    Homework_func.deleteCar(scanner); // 도서 삭제
                    break;
                case 5:
                    Homework_func.addDummy(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    Homework_func.searchCar(scanner); // 회원 검색
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
