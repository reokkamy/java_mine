package d250611.member_project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import d250611.member_project.model.Member;
import d250611.member_project.util.DateUtil;

public class UserService_HashMap_version {
    static final int MAX_USERS = 100; // 최대 회원 수

    // Member 클래스를 담아 둘 배열 생성. 크기는 동일하게 100명으로 정하기.
    // 변경1, 기존 배열 -> 컬렉션으로 변경,
    // 전
    // static Member[] members = new Member[MAX_USERS];
    // 후
    // private static ArrayList<Member> members = new ArrayList<>();

    // 변경 HashMap 1, ArrayList -> HashMap 형태로 변경
    // 전
    // private static ArrayList<Member> members = new ArrayList<>();
    // 후
    private static HashMap<Integer, Member> members = new HashMap<>();
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

            Member member = new Member(name, password, email, registrationDate);

            // 변경2. 기존 배열에서 추가 -> 컬렉션에서 추가
            // 전
            // members[userCount] = member;
            // 후
            // members.add(member);

            // 변경 HashMap 2, ArrayList -> HashMap 형태로 변경
            // 전
            // members.add(member);
            // 후
            members.put(userCount, member);

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

        // 변경3. 기존 배열에서 -> 컬렉션으로 수정.
        // 전
        // for (int i = 0; i < userCount; i++) {
        // members[i].showInfo();
        // }
        // 후
        // for (int i = 0; i < members.size(); i++) {
        // System.out.println("인덱스 번호 : " + i);
        // members.get(i).showInfo();
        // }

        // 변경 HashMap 3, ArrayList -> HashMap 형태로 변경
        // 전
        // for (int i = 0; i < members.size(); i++) {
        // System.out.println("인덱스 번호 : " + i);
        // members.get(i).showInfo();
        // }
        // 후
        // members.entrySet() -> 기능을 사용하면, 키와 값을 가지는 하나의 테이블 정보를 제공해줌.
        // 위의 정보 테이블에서, 하나의 그룹을 (키,값)의 형태로 되어 있음.
        for (Map.Entry<Integer, Member> entry : members.entrySet()) {
            System.out.println("인덱스 번호: " + entry.getKey());
            System.out.println("회원 정보");
            entry.getValue().showInfo();
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

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();

        // 변경할 정보를 담아둘 Member 객체 생성
        // 변경3-2 , 메모, new Member(); 이런 형식이 새로운 인스턴스를 생성하는 부분이라서,
        Member member = new Member(name, password, email, registrationDate);
        // 해당 인덱스에 수정된 회원 정보 저장

        // 변경4, 기존 member(0x100)에서,
        // 변경할 내용으로 수정이 된 새로운 member(0x200) 로 교체 작업
        // 전
        // members[index] = member;
        // 후
        // members.set(index, member);

        // 변경 HashMap 4, ArrayList -> HashMap 형태로 변경
        // 전
        // members.set(index, member);
        // 후
        members.put(index, member);

        System.out.println("회원 정보가 수정되었습니다: " + name + ", " + email + ", "
                + registrationDate);
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
        // 변경5,
        // 전
        // Member member = members[index];
        // System.out.println("삭제할 회원 정보: ");
        // member.showInfo(); // 회원 정보 출력

        // members[index] = null; // 해당 인덱스의 회원 정보 삭제
        // for (int i = index; i < userCount - 1; i++) {
        // members[i] = members[i + 1]; // 다음 인덱스의 회원 정보를 현재 인덱스로 이동
        // }
        // members[userCount - 1] = null; // 마지막 인덱스의 회원 정보 삭제
        // 후
        // 기존 삭제 할 회원 정보를 가져오기
        // Member member = members.get(index);
        // System.out.println("삭제할 회원 정보 : ");
        // member.showInfo();
        // // 삭제,
        // members.remove(index);

        // 변경 HashMap 5, ArrayList -> HashMap 형태로 변경
        // 전
        // Member member = members.get(index);
        // System.out.println("삭제할 회원 정보 : ");
        // member.showInfo();
        // // 삭제,
        // members.remove(index);
        // 후
        Member member = members.get(index);
        System.out.println("삭제할 회원 정보 : ");
        member.showInfo();
        members.remove(index);
        // 회원 수 감소
        userCount--;
        System.out.println("회원이 삭제되었습니다.");
    }
    // 회원 삭제 메서드

    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummyUsers() {
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                Member dummyMember = new Member(
                        "더미회원" + (i + 1),
                        "password" + (i + 1),
                        "dummy" + (i + 1) + "@example.com",
                        DateUtil.getCurrentDateTime());
                // 변경6,
                // 전
                // members[userCount] = dummyMember;
                // 후
                // members.add(dummyMember);

                // 변경 HashMap 6, ArrayList -> HashMap 형태로 변경
                // 전
                // members.add(dummyMember);
                // 후
                members.put(userCount, dummyMember);

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
            // 변경7
            // 전
            // if (members[i].getName().contains(searchQuery) ||
            // members[i].getEmail().contains(searchQuery)) {
            // members[i].showInfo(); // 회원 정보 출력
            // found = true;
            // }
            // 후
            // if (members.get(i).getName().contains(searchQuery) ||
            // members.get(i).getEmail().contains(searchQuery)) {
            // System.out.println("검색 결과 ");
            // members.get(i).showInfo();
            // found = true;
            // }

            // 전
            // if (members.get(i).getName().contains(searchQuery) ||
            // members.get(i).getEmail().contains(searchQuery)) {
            // System.out.println("검색 결과 ");
            // members.get(i).showInfo();
            // found = true;
            // }
            // 후
            // 맵에서, 해당 키에 해당하는 값의 멤버를 가져오고, 메일과 이름으로 검색 해보기
            if (members.get(i).getName().contains(searchQuery) ||
                    members.get(i).getEmail().contains(searchQuery)) {
                members.get(i).showInfo();
                found = true;
            }
        }

        if (!found) { // 검색 결과가 있을 경우, 실행이 안됨, found = true; -> false;
            System.out.println("검색 결과가 없습니다.");
        }
    }
    // 검색 기능
}
