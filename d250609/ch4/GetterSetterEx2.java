package d250609.ch4;

public class GetterSetterEx2 {
    // public String name; // 이름이 외부에 직접 접근이 가능한 문제점 발견
    private String name;
    private String email;
    private String password;

    // 매개변수가 3개인 생성자
    public GetterSetterEx2(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
    }

    // Getter : 데이터를 가져오는 역할.
    // Setter : 데이터를 쓰는 역할.
    // 접근 지정자를 : private 이용시,
    // 왜? private 접근 지정자를 사용하나요? 외부에서 해당 데이터에 직접 접근을 막기 위해서,
    // 캡슐화, 데이터 은닉, 숨기기. -> 왜? 숨기지? 왜냐하면, 해당 인스턴스 직접 값을 변경하게 되면,
    // 불변성 또는 데이터 일관성등이 깨지는 확률이 생김. 실수할 확률이 발생함.

    // 외부에서, 조회 하는 경우 , Getter 사용하고,
    public String getName() {
        return this.name; // 현재 인스턴스에 설정이 된 이름.
    }

    public String getEmail() {
        return this.email; // 현재 인스턴스에 설정이 된 이름.
    }

    public String getPassword() {
        return this.password; // 현재 인스턴스에 설정이 된 이름.
    }

    // 외부에서, 변경을 하는 경우, Setter 사용함.

    // 자동으로 코드를 생성해줌. 일단, 수동으로 확인.
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 불변성 이유로, Setter 보다는, 데이터를 변경하는 메서드를 따로 설정해서 작업을함.
}
