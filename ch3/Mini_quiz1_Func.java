package ch3;

import java.util.Scanner;

import util.date.DateUtil;

// 퀴즈,
// 아래 코드를 이용해서,
// 도서 관리 프로그램을 만들기,
// + @ : 검색 기능 넣기
// 도서 정보 1) 도서명, 2) 저자, 3) 출판사, 4) 등록일로 구성,
// 도서 정보 CRUD , 추가, 조회, 수정, 삭제 기능, 검색까지 구현.
// 검사 확인시, 기능 구현 다 보여주고, 각 메서드 기능에 대해서 질문 할 예정.
public class Mini_quiz1_Func {
    static final int MAX_USERS = 100; // 최대 도서 수
    // 이름명만, 바꾸기 기능으로 변경함
    // 회원 -> 도서
    // names -> bookNames
    // emails -> authors
    // passwords -> publishers
    // userCount -> bookCount
    static String[] bookNames = new String[MAX_USERS];
    static String[] authors = new String[MAX_USERS];
    static String[] publishers = new String[MAX_USERS];
    static String[] registrationDates = new String[MAX_USERS];

    static int bookCount = 0; // 현재 등록된 도서 수

    // addUser -> addBook
    public static void addBook(Scanner scanner) {
        if (bookCount < MAX_USERS) { // 기본 유효성 체크
            System.out.println("도서명을 입력하세요: ");
            String bookName = scanner.nextLine();
            bookNames[bookCount] = bookName; // 도서명 저장

            System.out.println("저자 이름을 입력하세요: ");
            String authorName = scanner.nextLine();
            authors[bookCount] = authorName; // 저자 이름 저장

            System.out.println("출판사를 입력하세요: ");
            String publisherName = scanner.nextLine();
            publishers[bookCount] = publisherName; // 출판사 저장

            String registrationDate = DateUtil.getCurrentDateTime();
            registrationDates[bookCount] = registrationDate; // 등록일 저장

            bookCount++;
            System.out.println("도서이 추가되었습니다: 책이름: " + bookName + ", 저자: " + authorName + ", 등록일: " + registrationDate);
        } else {
            System.out.println("도서 수가 최대치를 초과했습니다.");
        }
    } // 도서 추가 메서드

    // 도서 조회 메서드
    // viewUsers -> viewBooks
    public static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("등록된 도서이 없습니다.");
            return; // 등록된 도서이 없을 때, 조회 기능 종료, 메서드(함수)를 나가기
        }
        System.out.println("등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("인덱스 번호 : " + i + ", " + (i + 1) + ". 도서명 : " + bookNames[i] + ", 저자: " + authors[i]
                    + ", 출판사: " + publishers[i] + ", 등록일 : "
                    + registrationDates[i]);
        }
    } // 도서 조회 메서드

    // 도서 수정 메서드
    // updateUser -> updateBook
    public static void updateBook(Scanner scanner) {
        System.out.println("수정할 도서의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 도서의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= bookCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 도서의 이름을 입력하세요: ");
        String bookName = scanner.nextLine();
        bookNames[index] = bookName; // 이름 수정

        System.out.println("수정할 저자의 이름을 입력하세요: ");
        String authorName = scanner.nextLine();
        authors[index] = authorName; // 이메일 수정

        System.out.println("수정할 도서의 출판사 이름을 입력하세요: ");
        String publisherName = scanner.nextLine();
        publishers[index] = publisherName; // 패스워드 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        registrationDates[index] = registrationDate; // 등록일 수정

        System.out.println("도서 정보가 수정되었습니다: " + bookNames[index] + ", " + authors[index]);
    } // 도서 수정 메서드

    // 도서 삭제 메서드
    // deleteUser -> deleteBook
    public static void deleteBook(Scanner scanner) {
        System.out.println("삭제할 도서의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 도서의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= bookCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 삭제할 도서 정보 출력
        System.out.println("삭제할 도서 정보: " + bookNames[index] + ", " + authors[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 도서 정보를 삭제하고, 뒤에 있는 도서 정보를 앞으로 이동
        for (int i = index; i < bookCount - 1; i++) {
            bookNames[i] = bookNames[i + 1];
            authors[i] = authors[i + 1];
            publishers[i] = publishers[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 도서 정보는 null로 설정
        bookNames[bookCount - 1] = null;
        authors[bookCount - 1] = null;
        publishers[bookCount - 1] = null;
        registrationDates[bookCount - 1] = null;

        // 도서 수 감소
        bookCount--;
        System.out.println("도서이 삭제되었습니다.");
    }
    // 도서 삭제 메서드

    // 도서 더미 데이터 5개 추가하는 메서드
    // addDummyUsers -> addDummyBooks
    public static void addDummyBooks() {
        for (int i = 0; i < 5; i++) {
            if (bookCount < MAX_USERS) {
                bookNames[bookCount] = "더미도서" + (i + 1);
                authors[bookCount] = "이상용 " + (i + 1) + " 저자";
                publishers[bookCount] = "상용 출판사" + (i + 1);
                registrationDates[bookCount] = DateUtil.getCurrentDateTime();
                bookCount++;
            } else {
                System.out.println("더미 도서 추가 실패: 최대 도서 수 초과");
                break;
            }
        }
        System.out.println("더미 도서 5명이 추가되었습니다.");
    }
    // 도서 더미 데이터 5개 추가하는 메서드

    // 검색 기능
    // 도서 목록에서 이름 또는 이메일로 검색하는 기능을 추가할 수 있습니다.
    // searchUser -> searchBook
    public static void searchBook(Scanner scanner) {
        System.out.println("검색할 도서의 이름 또는 저자 이름을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (bookNames[i].contains(searchQuery) || authors[i].contains(searchQuery)) {
                System.out.println("검색 결과: " + (i + 1) + ". " + bookNames[i] + ", " + authors[i] + ", "
                        + registrationDates[i]);
                found = true;
            }
        }

        if (!found) { // 검색 결과가 있을 경우, 실행이 안됨, found = true; -> false;
            System.out.println("검색 결과가 없습니다.");
        }
    }
    // 검색 기능
}
