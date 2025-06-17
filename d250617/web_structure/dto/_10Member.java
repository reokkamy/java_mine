package d250617.web_structure.dto;

public class _10Member {
    // DTO : 데이터를 디비에 전달용으로 사용할 모델
    // 회원 관리 프로그램,
    // 회원 추가, id, name, email, password, reg_date
    // 자바 -> 데이터베이스 ,
    // 방법1) 각각 한개 씩 전달 할거냐?
    // 방법2) 비유, 쟁반(박스)에 담아서 보낼거냐? , 선호, 관리가 편해서.
    private int id;
    private String name;
    private String email;
    private String password;
    private String reg_date;

    // 1)생성자 추가
    // 기본 생성자
    public _10Member() {
    }

    // 매개변수 생성자
    public _10Member(int id, String name, String email, String password, String reg_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.reg_date = reg_date;
    }

    // 2) 게터 세터 추가

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    // 3) 모델 클래스의 인스턴스를 출력시, 우리가 정의한 내용으로 출력, toString()
    // int id, String name, String email, String password, String reg_date) {
    // ex) Member member = new Member("1","이상용","lsy@naver.com","1234","2025년 06월
    // 16일 오후 3시 56분")
    // System.out.println(member);
    // 출력 내용
    // _10Member [id=1, name=이상용, email=lsy@naver.com, password=1234, reg_date=2025년
    // 06월 16일 오후 3시 56분]
    @Override
    public String toString() {
        return "_10Member [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", reg_date="
                + reg_date + "]";
    }

    // 위의 3가지 작업을 많이 하다보니, 반자동으로 생성 , 우클릭 -> 소스 생성, 선택.

    // 나중에, lombok 라이브러리 이용하게 되면, 따로 생성 안해도, 자동으로 메모리에 생성 해줌.

}
