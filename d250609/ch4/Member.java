package d250609.ch4;

public class Member {
    // 변수
    private String name;
    private String email;
    private String password;

    // 생성자
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
    }

    // 우클릭 소스작업 - Generate Getters,Setters
    // 게터
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // 세터

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 세터느느 각멤버 변수를 하나씩 수정하고
    // changeNameEmailPassword, 메서드는 각각 멤버 변수 3개를 한번에 수정해보기
    public void changeNameEmailPassword(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

}
