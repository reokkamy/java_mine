package d250611.member_project.model;

public class Member {
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

    public String getName() {
        return name;
    }

    // 이메일 조회 기능, 게터 getter
    public String getEmail() {
        return email;
    }
}
