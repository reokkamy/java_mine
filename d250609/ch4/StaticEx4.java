package d250609.ch4;

public class StaticEx4 {
    // static : 클래스 단위로 공유되는 필드 / 메서드

    String name;

    // static 키워드를 사용해서, 모든 객체가 공유하는 변수
    static int studentCount = 0;

    // 생성자 호출시, 학생의 번호가 증가 하도록 만들기.
    public StaticEx4(String name) {
        this.name = name;
        // 공유 변수인, 학생 수를 카운트 하는 변수를 증가.
        studentCount++;
    }

    // 인스턴스 메서드
    // 인스턴스 , (객체) 생성후, 해당 , 인스턴스명으로 호출.
    // A a = new A();
    // a.showInfo()
    public void showInfo() {
        System.out.println("이름 : " + name);
    }

    // 스태틱 메서드
    // 클래스명으로 바로 사용이 가능함.
    // A : 클래스명
    // A.showInfoTotal()
    public static void showInfoTotal() {
        System.out.println("총 학생수 : " + studentCount);
    }
}
