package ch4;

public class PhoneMain {
    public static void main(String[] args) {
        // 퀴즈2, 본인 만든 클래스에서,
        // 각각의 매개변수가 정의된 생성자를, 오버로딩해서,
        // 각각에 객체(인스턴스) 생성 해보기.
        // 정보 출력해보기.

        // 설계한 클래스를 이용해서, 객체를 3개 생성.
        // 모양,
        // 클래스명 객체명(인스턴스 변수명) = new 클래스명();
        Phone phone1 = new Phone(); // 기본 생성자 호출 ,Phone() : 소괄호안에 매개변수가 없는 것.
        // 값을 직접 할당. 실무에서는 private 선언하고, setter 등으로 설정함, 캡슐화,
        phone1.model = "Galaxy S23";
        phone1.price = "100만원";
        phone1.company = "삼성전자";
        // 기능 확인, 객체명.메소드명();
        phone1.showInfo();
        System.out.println("-----------------");
        // 2번째 객체 생성은, 기본 생성자가 아닌, 매개변수를 이용한 생성자를 이용하기. .
        // 순서, 1) 매개변수가 정의된 생성자를 만들기, 2) 이용.
        Phone phone2 = new Phone("iPhone 14", "120만원", "Apple"); // 매개변수 생성자 호출
        phone2.showInfo();
        System.out.println("-----------------");
        // 3번째 객체 생성
        Phone phone3 = new Phone("Pixel 7", "90만원", "Google"); // 매개변수 생성자 호출
        phone3.showInfo();
        System.out.println("-----------------");
        // 4번째 객체 생성, 매개변수 2개인 생성자를 이용함.
        Phone phone4 = new Phone("OnePlus 11", "80만원"); // 매개변수 생성자 호출
        phone4.company = "OnePlus"; // company는 기본 생성자에서 초기화 안했으니, 직접 할당}
        phone4.showInfo();
        // 5번째 객체 생성, 매개변수 1개인 생성자를 이용함.
        Phone phone5 = new Phone("Xiaomi 13"); // 매개변수 생성자 호출
        phone5.price = "70만원"; // price는 기본 생성자에서 초기화 안했으니, 직접 할당
        phone5.company = "Xiaomi"; // company는 기본 생성자에서 초기화 안했으니, 직접 할당
        phone5.showInfo();
        System.out.println("-----------------");

    }
}
