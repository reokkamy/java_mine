package ch3;

import java.util.Scanner;

import util.date.*;
import util.model.Member;

public class Exs_ch3_2_user_array_doc_backup1 {

    // 퀴즈,
    // 아래 코드를 이용해서,
    // 도서 관리 프로그램을 만들기,
    // + @ : 검색 기능 넣기
    // 도서 정보 1) 도서명, 2) 저자, 3) 출판사, 4) 등록일로 구성,
    // 도서 정보 CRUD , 추가, 조회, 수정, 삭제 기능, 검색까지 구현.
    // 검사 확인시, 기능 구현 다 보여주고, 각 메서드 기능에 대해서 질문 할 예정.

    // 회원 관리 프로그램 버전2, 저장소: 임시 메모리(배열) 이용할 예정.
    // 배열 주의 사항) 1) 고정 길이 , 2) 크기 변경 불가, 3) 같은 타입 사용.
    // 조건), 1) 회원 수는 100명 이하, 2) 회원 정보는 이름, 이메일, 패스워드, 등록일로 구성.
    // 회원 정보 CRUD , 추가, 조회, 수정, 삭제 기능 구현.

    static final int MAX_USERS = 100; // 최대 회원 수
    // 이름, 이메일, 패스워드, 등록일을 저장할 배열 선언
    // 예시) 1명이 회원 가입 하게 되면, 이상용, lsy@naver.com , 1234, 2025-06-04
    // 배열은 순서, 인덱스 표현하고, 0부터 시작함.
    // names 배열 : ["이상용"] -> names[0] = "이상용"
    // emails 배열 : ["lsy@naver.com"] -> emails[0] = "lsy@naver.com"
    // passwords 배열 : ["1234"] -> passwords[0] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00"] -> registrationDates[0] =
    // "2025-06-04 12:00:00"

    // 예시2) 1명 회원 더 추가시, 홍길동 , hong@naver.com, 1234, 2025-06-04
    // names 배열 : ["이상용", "홍길동"] -> names[1] = "홍길동"
    // emails 배열 : ["lsy@naver.com", "hong@naver.com"] -> emails[1] =
    // "hong@naver.com"
    // passwords 배열 : ["1234", "1234"] -> passwords[1] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00", "2025-06-04 12:00:00"] ->
    // registrationDates[1] = "2025-06-04 12:00:00"

    // 예시3) 1명 회원 더 추가시, 김철수 , kim1111@naver.com , 1234, 2025-06-04
    // names 배열 : ["이상용", "홍길동", "김철수"] -> names[2] = "김철수"
    // emails 배열 : ["lsy@naver.com", "hong@naver.com", "kim1111@naver.com"] ->
    // emails[2] = "kim1111@naver.com"
    // passwords 배열 : ["1234", "1234", "1234"] -> passwords[2] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00", "2025-06-04 12:00:00",
    // "2025-06-04 12:00:00"] -> registrationDates[2] = "2025-06-04 12:00:00"

    // 결론, 배열은 임시 메모리 저장소이고, 각 배열의 모양
    // names[0] = "이상용", names[1] = "홍길동", names[2] = "김철수" 처럼,
    // emails[0] = "", emails[1] = "", emails[2] = "" 처럼,
    // passwords[0] = "", passwords[1] = "", passwords[2] = "" 처럼,
    // registrationDates[0] = "", registrationDates[1] = "", registrationDates[2] =
    // "" 처럼,
    // MAX_USERS = 100 이므로, 인덱스 : 0 ~ 99 까지 사용 가능.
    static String[] names = new String[MAX_USERS];
    static String[] emails = new String[MAX_USERS];
    static String[] passwords = new String[MAX_USERS];
    static String[] registrationDates = new String[MAX_USERS];

    // Member 클래스를 담아 둘 배열 생성. 크기는 동일하게 100명으로 정하기.
    static Member[] members = new Member[MAX_USERS];

    // 추가작업-1,개요
    // 클래스 타입으로 데이터를 모아놓고,
    // 배열에 폰 클래스 타입으로 담는 작업? 퀴즈로 했음.
    // 0) 콘솔에서 입력 받은 정보들을 클래스에 담기.
    // 1) 회원 정보를 담아 둘 클래스를 정의, Member 클래스 만들기.
    // 1)-2 , 멤버 : 이름, 이메일, 패스워드, 등록일 , 기능 : 각 정보를 보여주는 기능.
    // 2) 회원 클래스를 담아 둘 배열를 생성하기.

    // 상태 변수,
    static int userCount = 0; // 현재 등록된 회원 수

    // 회원 추가 메서드
    public static void addUser(Scanner scanner) {
        if (userCount < MAX_USERS) { // 기본 유효성 체크
            System.out.println("이름을 입력하세요: ");
            String name = scanner.nextLine();

            System.out.println("이메일을 입력하세요: ");
            String email = scanner.nextLine();

            System.out.println("패스워드를 입력하세요: ");
            String password = scanner.nextLine();

            // 현재 날짜와 시간 저장
            String registrationDate = DateUtil.getCurrentDateTime();

            // public Member(String name, String password, String email, String regDate) {
            // 사용자들로 부터 입력 받은 정보를, 모델 클래스의 인스턴스 생성 하는 곳에 사용.
            Member member = new Member(name, password, email, registrationDate);

            // 배열의 단점, 인덱스의 위치 조정 자동으로 안해줌.
            // 앞에 삭제시, 삭제후 인덱스 이동을 수동을 했음. 그래서,
            // 지금 배열의 불편한 부분을 감수하고, -> 배열의 업그레이드 버전 -> arrayList 등으로 해결.

            members[userCount] = member;
            // 회원 수 증가
            userCount++;
            System.out.println("회원이 추가되었습니다: " + name + ", " + email + ", " + registrationDate);
        } else {
            System.out.println("회원 수가 최대치를 초과했습니다.");
        }
    } // 회원 추가 메서드

    // 회원 조회 메서드
    public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return; // 등록된 회원이 없을 때, 조회 기능 종료, 메서드(함수)를 나가기
        }
        System.out.println("등록된 회원 목록:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("인덱스 번호 : " + i + ", " + (i + 1) + ". " + names[i] + ", " + emails[i] + ", "
                    + registrationDates[i]);
        }
    } // 회원 조회 메서드

    // 회원 수정 메서드
    // 회원 전체 목록에서, 해당 회원의 인덱스를 번호를 이용해서, 회원 정보를 수정해보기.
    public static void updateUser(Scanner scanner) {
        System.out.println("수정할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 회원의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        names[index] = name; // 이름 수정

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();
        emails[index] = email; // 이메일 수정

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();
        passwords[index] = password; // 패스워드 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        registrationDates[index] = registrationDate; // 등록일 수정

        System.out.println("회원 정보가 수정되었습니다: " + names[index] + ", " + emails[index]);
    } // 회원 수정 메서드

    // 회원 삭제 메서드
    // 수정 처럼, 회원의 인덱스 번호를 입력시, 삭제하는 로직.
    public static void deleteUser(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 삭제할 회원 정보 출력
        System.out.println("삭제할 회원 정보: " + names[index] + ", " + emails[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 회원 정보를 삭제하고, 뒤에 있는 회원 정보를 앞으로 이동
        for (int i = index; i < userCount - 1; i++) {
            names[i] = names[i + 1];
            emails[i] = emails[i + 1];
            passwords[i] = passwords[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 회원 정보는 null로 설정
        names[userCount - 1] = null;
        emails[userCount - 1] = null;
        passwords[userCount - 1] = null;
        registrationDates[userCount - 1] = null;

        // 회원 수 감소
        userCount--;
        System.out.println("회원이 삭제되었습니다.");
    }
    // 회원 삭제 메서드

    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummyUsers() {
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                names[userCount] = "더미회원" + (i + 1);
                emails[userCount] = "dummy" + (i + 1) + "@example.com";
                passwords[userCount] = "password" + (i + 1);
                registrationDates[userCount] = DateUtil.getCurrentDateTime();
                userCount++;
            } else {
                System.out.println("더미 회원 추가 실패: 최대 회원 수 초과");
                break;
            }
        }
        System.out.println("더미 회원 5명이 추가되었습니다.");
    }
    // 회원 더미 데이터 5개 추가하는 메서드

    // 검색 기능
    // 회원 목록에서 이름 또는 이메일로 검색하는 기능을 추가할 수 있습니다.
    public static void searchUser(Scanner scanner) {
        System.out.println("검색할 회원의 이름 또는 이메일을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < userCount; i++) {
            // 배열.contins() 메서드를 사용하여 검색어가 이름 또는 이메일에 포함되어 있는지 확인
            // contains() 메서드는 문자열에 특정 문자열이 포함되어 있는지 확인하는 메서드입니다.
            // 예시) names[i].contains(searchQuery) -> names[0] = "이상용" , searchQuery = "이상용"
            if (names[i].contains(searchQuery) || emails[i].contains(searchQuery)) {
                System.out.println("검색 결과: " + (i + 1) + ". " + names[i] + ", " + emails[i] + ", "
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