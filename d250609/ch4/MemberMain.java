package d250609.ch4;

public class MemberMain {
    public static void main(String[] args) {
        // 인스턴스3개생성
        Member member1 = new Member("김무진", "qyiante@naver.com", "1234");

        Member member2 = new Member("홍길동", "qqq@google.com", "5566");

        Member member3 = new Member("이순신", "dnglgl@daum.com", "9090");

        // 방금 만든 설계 클래스를 담을 배열 생성하기
        // Member[] mamberArray = new Member[3]
        Member[] memberArray = { member1, member2, member3 };

        // 반복문으로 담기
        // for (int i = 0; i < memberArray.length; i++) {
        // memberArray[i] = MemberTempArray[i];
        // }

        System.out.println("=============인스턴스 기본 생성 후 , 확인 해보기 ===========");
        // 각 인스턴스를 반복문 이용해서 출력해보기
        for (Member member : memberArray) {
            member.showInfo();
        }
        System.out.println("===============수정 후 , 확인 해보기 ============================");
        // 각 인스턴스 멤버의 변수를 3개다 변경하는 메소드 이용해서 수정하고 다시출력
        member1.changeNameEmailPassword("수정1 김무진1", "qiii@naver.com", "3333");
        member2.changeNameEmailPassword("수정1 김무진2", "eeeei@naver.com", "1111");
        member3.changeNameEmailPassword("수정1 김무진3", "dddd@naver.com", "2222");

        for (Member member : memberArray) {
            member.showInfo();
        }
    }

}
