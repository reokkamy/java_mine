package ch4;

public class Quiz1 {

    String name;
    String number;
    String company;

    public Quiz1() {

    }

    public Quiz1(String name) {
        this.name = name;

    }

    // 2개의 매개변수를 가지는 생성자
    public Quiz1(String name, String number) { // 매개변수 매번 다름, 동적인값
        this.name = name; // this.name, 위에 정의한 멤버 변수, name: 동적인 값.
        this.number = number;
    }

    // 주의사항, 매개변수가 있는 생성자를 생성시, 기본 생성자는 더이상 지원을 안해줌.
    // 그래서, 만약 기본 생성자를 따로 필요하다면, 따로 만들어야 함.
    // 3개 형태의 생성자
    public Quiz1(String name, String number, String company) { // 매개변수 매번 다름, 동적인값
        this.name = name; // this.name, 위에 정의한 멤버 변수, name: 동적인 값.
        this.number = number;
        this.company = company;
        // 기본 생성자 내용은 비워둠, 필요시 초기화 작업 가능
    }

    // 메소드
    public void showInfo() {
        // this : 현재 객체를 가리키는 키워드
        System.out.println("이름 : " + this.name);
        System.out.println("제조번호 : " + this.number);
        System.out.println("회사 : " + this.company);
    }

}
