package util.model;

public class Member {
    // 사용할 멤버 변수,
    // 이름, 패스워드, 이메일, 등록일 , 모두 문자열 형태
    // 생성자는 매개변수 4개를 구성하기,
    // 각각의 정보를 호출하는 인스턴스 메서드를 생성.
    // 주의사항) 현재, 접근 지정자, 상속, 객체지향 기법을 모두 배운게 아니라서,
    // 현재 캡슐화 등 안하고, 일단 public 하는점 이해하기. 생략시 default 접근 지정자,
    String name;
    String password;
    String email;
    String regDate;

    public Member(String name, String password, String email, String regDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.regDate = regDate;
    }

    public void showInfo() {
        System.out.println("회원 이름 : " + this.name);
        System.out.println("회원 이메일 : " + this.email);
        System.out.println("회원 패스워드 : " + this.password);
        System.out.println("회원 등록일 : " + this.regDate);
    }

    // 검색을 위해서, 해당 이름과, 이메일 정보를 조회 하는 기능,
    // 이름 조회 기능, 게터 , 자동 생성, 또는 라이브러리 사용해서, 자동 생성된 기능을 이용할 예정.
    // 또는 수동으로 만들어서 사용도 함.
    // 결론, 나중에 라이브러리 많이 사용함.,
    public String getName() {
        return name;
    }

    // 이메일 조회 기능, 게터 getter
    public String getEmail() {
        return email;
    }
}