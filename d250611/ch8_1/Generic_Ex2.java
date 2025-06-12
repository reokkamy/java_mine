package d250611.ch8_1;

import d250611.member_project.model.Member;

public class Generic_Ex2<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        // 타입을 문자열
        Generic_Ex2<String> boxString = new Generic_Ex2<>();
        boxString.set("이상용");
        String resultStr1 = boxString.get();
        System.out.println("제너릭으로 타입을 설정한 클래스의 인스턴스를 생성 후, 정보 가져오기");
        System.out.println(" 값 : " + resultStr1);

        // 타입 정수,
        Generic_Ex2<Integer> boxInteger = new Generic_Ex2<>();
        boxInteger.set(100);
        Integer resutInt = boxInteger.get();
        System.out.println("제너릭 타입을 Integer 버전 : " + resutInt);

        // 타입, 멤버-> 클래스 형으로 작업, 추천
        Generic_Ex2<Member> boxMember = new Generic_Ex2<>();
        // 방법1
        boxMember.set(new Member("이상용", "1234", "lsy@naver.com", "2025-06-11"));

        // 방법2
        Member member = new Member("이상용", "1234", "lsy@naver.com", "2025-06-11");
        boxMember.set(member);
        boxMember.get().showInfo();
    }

}
